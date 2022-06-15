/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author minh,hai
 */
import Object.CuonSach;
import java.sql.*;

public class CuonSachDAO {

    public static PreparedStatement pst = null;
    public static ResultSet rs = null;
    public static CallableStatement stmt = null;
    public static Connection conn = Connect.getConnect();
    

    public static boolean DeleteCuonSach(int masach, int madausach) {
        try{
               stmt = conn.prepareCall(
                    "{call XOACUONSACH(?,?)}");
            stmt.setInt("masach", masach);
           stmt.setInt("mads", madausach);
           boolean result = stmt.execute();
           return result;
        }catch(SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
       
    }
    
   
    public static boolean DeleteCuonSachDauSach(String madausach) {
         String sql = "DELETE FROM CUONSACH where MADAUSACH = ?";
        try {
            stmt = conn.prepareCall(sql);
            stmt.setString(1,madausach);
            var rs =stmt.executeUpdate();
            if(rs > 0){
                return true;
            }
            return false; 
        } catch(SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }
}
