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

public class DocGiaDAO {

    public static PreparedStatement pst = null;
    public static CallableStatement stmt = null;
    public static ResultSet rs = null;
    public static Connection conn = Connect.getConnect();

    public static boolean InsertDocGia(DocGia dg) {

        String sql = " insert into DOCGIA (HOTEN,NGAYSINH,LOAIDG,DIACHI,EMAIL,NGLAPTHE) values ( ?, ? , ?, ? , ? , ?) ";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, dg.gethOTEN());
            pst.setDate(2, (Date) dg.getnGAYSINH());
            pst.setString(3, dg.getlOAIDG());
            pst.setString(4, dg.getdIACHI());
            pst.setString(5, dg.geteMAIL());
            pst.setDate(6, (Date) dg.getnGAYLAPTHE());
            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }

    public static boolean DeleteDocGia(String madocgia) {

        String sql = "DELETE FROM DOCGIA where MADOCGIA = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, madocgia);
            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }

    public static int checkdg_muonsach(String madocgia) {
        int temp = 0;
        String sql = "select count(masach) as tongmuon from PHIEUMUONSACH P, CTMS CT where P.MAPHIEUMUONSACH = CT.MAPHIEUMUONSACH and p.madocgia = ?   and ct.TINHTRANG ='chưa trả'";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, madocgia);
            rs = pst.executeQuery();
            while (rs.next()) {
                temp = rs.getInt("tongmuon");
            }
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
        return temp;
    }

    public boolean UpdateDocGia(DocGia dg) {
        String sql = "update DOCGIA set  HOTEN = ?, NGAYSINH = ?, LOAIDG = ?, DIACHI=?, EMAIL =? where MADOCGIA = ?";

        try {
            pst = conn.prepareStatement(sql);
            pst.setString(6, dg.getmADOCGIA());
            pst.setString(1, dg.gethOTEN());
            pst.setDate(2, (Date) dg.getnGAYSINH());
            pst.setString(3, dg.getlOAIDG());
            pst.setString(4, dg.getdIACHI());
            pst.setString(5, dg.geteMAIL());

            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }
    
     public static boolean checkHanDocGia(String madg) {
         java.util.Date date = new java.util.Date();
         java.util.Date denhan = new java.util.Date();
        String sql = "SELECT NGDENHAN FROM DOCGIA WHERE MADOCGIA = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,madg);
            rs = pst.executeQuery();
            while (rs.next()){
                denhan = rs.getDate("NGDENHAN");
            }
            if (!denhan.after(date)) {
                return false;
            }
            return true;
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }
     public static boolean UpdateHan(int madg) {
        
        try {
            stmt = conn.prepareCall(
                    "{call UPDATENGDENHAN(?)}");
            stmt.setInt("madocgia", madg);
           boolean result = stmt.execute();
           return result;
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }
}
