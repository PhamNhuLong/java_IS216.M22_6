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
}
