/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author minh
 */
import java.sql.*;
import Object.*;
import java.util.ArrayList;

public class HoaDonDAO {

    public static PreparedStatement pst = null;
    public static ResultSet rs = null;
    public static CallableStatement stmt = null;
    public static Connection conn = Connect.getConnect();

    public static boolean ThemHoaDon(HoaDon hd) {
        String sql = "INSERT INTO HOADON(MAPHIEUTRA,TIENTHU,TIENNO) VALUES (?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, hd.getmAPHIEUTRA());
            pst.setInt(2, hd.gettIENTHU());
            pst.setInt(3, hd.gettIENNO());

            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }

    public static boolean InsertHOADON(HoaDon hd) {

        String sql = "CALL THEM_HOA_DON(?,?,?)";
        try {
            stmt = conn.prepareCall(sql);
            stmt.setInt(1, hd.getmAHD());
            stmt.setInt(2, hd.getmAPHIEUTRA());
            stmt.setInt(3, hd.gettIENTHU());

            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }

    public static boolean DeleteHOADON(String mahd) {

        String sql = "delete from HOADON where MAHD=?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, mahd);
            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }

    public boolean UpdateHOADON(HoaDon hd) {
        String sql = "update HOADON set  MAPHIEUTRA = ?, TIENNO = ?, TIENTHU = ? where MAHD= ?";

        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(5, hd.getmAHD());
            pst.setInt(1, hd.getmAPHIEUTRA());
            pst.setInt(2, hd.gettIENNO());
            pst.setInt(3, hd.gettIENTHU());

            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }

    public static int kiemtra(String mapt) {
        String sql = "select tienno from hoadon where maphieutra = ?";
        int count = 0;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, mapt);
            rs = pst.executeQuery();
            while (rs.next()) {
                count = count + 1;
            }
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
        return count;
    }

    public static int getMa() {
        String sql = "select top 1 MAHD from hoadon order by MAHD DESC";
        int ma = 0;
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                ma = Integer.valueOf(rs.getString("MAHD"));
            }
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
        return ma;
    }

    public static ArrayList<ChiTietTraSachHoaDon> inhoadon(String mapts) {
        
        ArrayList<ChiTietTraSachHoaDon> list = new ArrayList<ChiTietTraSachHoaDon>();
        String sql = "select DAUSACH.TENDAUSACH as TEN, SONGAYTRATRE, TIENPHAT\n"
                + "FROM CTTS,CUONSACH,DAUSACH\n"
                + "WHERE CTTS.MASACH = CUONSACH.MASACH \n"
                + "AND DAUSACH.MADAUSACH = CUONSACH.MADAUSACH\n"
                + "AND MAPHIEUTRA = ?";
        try {
            pst = conn.prepareStatement(sql);
            System.out.println(mapts);
            pst.setString(1, mapts);
            rs = pst.executeQuery();
            
            while (rs.next()) {
               String ten = rs.getString("TEN");
               int ngay = rs.getInt("SONGAYTRATRE");
               int tien = rs.getInt("TIENPHAT");
               System.out.println(ten);
               ChiTietTraSachHoaDon tshd = new ChiTietTraSachHoaDon(ngay,tien,ten);
               list.add(tshd);
            }
            return list;
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }
}
