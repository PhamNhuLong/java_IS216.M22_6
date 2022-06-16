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
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhieuTraSachDAO {

    public static PreparedStatement pst = null;
    public static ResultSet rs = null;
    public static CallableStatement stmt = null;
    public static Connection conn = Connect.getConnect();

    public static boolean InsertPhieuTraSach(PhieuTraSach pts, String ms) {
        int count = 0;
        int temp = 0;
        String sql = "insert into PHIEUTRASACH(MADOCGIA, NGAYTRA, TIENPHATKINAY) values(?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, pts.getmADOCGIA());
            pst.setDate(2, (Date) pts.getnGAYTRA());
            pst.setInt(3, pts.gettIENPHATKINAY());
            count += pst.executeUpdate();
            if (count > 0) {
                int ma = getMa();
                if (ChiTietTraSachDAO.InsertCTTS2(ma, ms) != 0) {
                    temp++;
                }
            }
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
        if (temp > 0) {
            return true;
        }
        return false;
    }

    public static int getMa() {

        String sql = "SELECT TOP 1 MAPHIEUTRA  FROM PHIEUTRASACH ORDER BY MAPHIEUTRA DESC";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            int ma = 0;
            while (rs.next()) {
                ma = rs.getInt("MAPHIEUTRA");
            }
            return ma;
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }
//   public static boolean DeletePhieuTraSach(String maphieutra) {
//        
//         String sql = "call xoa_phieu_tra_sach(?)";
//        try {
//           stmt = conn.prepareCall(sql);
//           stmt.setString(1,maphieutra);
//            return stmt.executeUpdate()>0; 
//        } catch(SQLException ex) {
//            throw new ArithmeticException(ex.getMessage());
//        }
//    }

    public static boolean DeletePhieuTraSach(String maphieutra) {
        String SQL = "delete from PhieuTraSach where maphieutra=?";
        try {
            pst = conn.prepareStatement(SQL);
            pst.setString(1, maphieutra);
            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }

    public boolean UpdatePhieuTraSach(PhieuTraSach pts) {
        String sql = "update PhieuTraSach set  MADOCGIA = ?, NGAYTRA = ?, TIENPHATKINAY = ?  where MAPHIEUTRA = ?";

        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(4, pts.getmAPHIEUTRA());
            pst.setInt(1, pts.getmADOCGIA());
            pst.setDate(2, (Date) pts.getnGAYTRA());
            pst.setInt(3, pts.gettIENPHATKINAY());

            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }

    public static ArrayList<String> LoadDataCbb() {
        String sql = "select distinct D.MADOCGIA as MA, HOTEN FROM DOCGIA D JOIN PHIEUMUONSACH P ON P.MADOCGIA = D.MADOCGIA";
        ArrayList<String> list = new ArrayList<String>();
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("MA") + "," + rs.getString("HOTEN"));
            }
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
        return list;
    }

    public static ArrayList<String> LoadSach(String madg) {
        String sql = "SELECT MASACH \n"
                + "FROM CTMS JOIN PHIEUMUONSACH P ON CTMS.MAPHIEUMUONSACH = P.MAPHIEUMUONSACH\n"
                + "WHERE MADOCGIA  = ? AND TINHTRANG = ?;";
        ArrayList<String> list = new ArrayList<String>();
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, madg);
            pst.setString(2, "chưa trả");
            rs = pst.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("MASACH"));
            }
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }

        return list;
    }

    public static int checkExists(String mapts) {
        String sql = "SELECT COUNT(*) as count FROM HOADON WHERE MAPHIEUTRA = ?";
        int count = 0;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, mapts);
            rs = pst.executeQuery();
            while (rs.next()) {
                count = rs.getInt("count");
            }
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
        return count;
    }

}
