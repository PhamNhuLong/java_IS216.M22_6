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

public class ChiTietTraSachDAO {

    public static PreparedStatement pst = null;
    public static ResultSet rs = null;
    public static CallableStatement stmt = null;
    public static Connection conn = Connect.getConnect();

    public static boolean InsertCTTS(ChiTietTraSach ctts) {

        String sql = "call THEM_CTTS(?,?)";
        try {
            stmt = conn.prepareCall(sql);
            stmt.setInt(1, ctts.getmAPHIEUTRA());
            stmt.setInt(2, ctts.getmASACH());

            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }

    public static int InsertCTTS2(int mapts, String masach) {
        String[] word = masach.split(",");
        String ma = String.valueOf(mapts);
        int result = 0;
        for (int i = 0; i < word.length; i++) {
            String sql = "INSERT INTO CTTS VALUES (?,?,0,0)";
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, word[i]);
                pst.setString(2,ma);
                result = pst.executeUpdate();
            } catch (SQLException ex) {
                throw new ArithmeticException(ex.getMessage());
            }
        }
       return result;
    }

    public static boolean DeleteCTTS(ChiTietTraSach ctts) {

        String sql = "call XOA_CTTS(?,?)";
        try {
            stmt = conn.prepareCall(sql);
            stmt.setInt(1, ctts.getmAPHIEUTRA());
            stmt.setInt(2, ctts.getmASACH());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }

    public boolean UpdateCTTS(ChiTietTraSach ctts) {
        String sql = "update CTTS set  MASACH =  ?, SONGAYTRATRE = ?, TIENPHAT = ? where MAPHIEUTRA = ?";

        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(4, ctts.getmAPHIEUTRA());
            pst.setInt(1, ctts.getmASACH());
            pst.setInt(2, ctts.getsONGAYTRATRE());
            pst.setInt(3, ctts.gettIENPHAt());

            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }
}
