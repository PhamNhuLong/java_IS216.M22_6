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
public class ChiTietMuonSachDAO {
    public static PreparedStatement pst = null;
    public static ResultSet rs = null;
    public static CallableStatement stmt = null ;
    public static Connection conn = Connect.getConnect();
  
      public static boolean InsertCTMS(ChiTietMuonSach ctms) {
        
        String sql = "insert into CTMS(maphieumuonsach, masach, tinhtrang) values(?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, ctms.getmAPHIEUMUONSACH());
            pst.setString(2, ctms.getmASACH());         
            pst.setString(3, "chưa trả");
            return pst.executeUpdate()>0; 
        } catch(SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }
       public static int InsertCTMS2(int mapms, String masach) {
        String[] word = masach.split(",");
        String ma = String.valueOf(mapms);
        int result = 0;
        for (int i = 0; i < word.length; i++) {
            String sql = "insert into CTMS(maphieumuonsach, masach, tinhtrang) values(?,?,?)";
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(2, word[i]);
                pst.setString(1,ma);
                pst.setString(3, "chưa trả");
                result = pst.executeUpdate();
            } catch (SQLException ex) {
                throw new ArithmeticException(ex.getMessage());
            }
        }
       return result;
    }
   public static boolean DeleteCTMS(ChiTietMuonSach ctms) {
        
         String sql = "call XOA_CTMS(?,?)";
        try {
            stmt = conn.prepareCall(sql);
            stmt.setString(1, ctms.getmAPHIEUMUONSACH());
            stmt.setString(2, ctms.getmASACH());         
            
            return stmt.executeUpdate()>0; 
        } catch(SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }
   public boolean UpdateCTMS(ChiTietMuonSach ctms)  {
        String sql = "update CTMS set  MASACH =  ? where MAPHIEUMUONSACH = ?";
        
        try
        {
           pst= conn.prepareStatement(sql); 
           pst.setString(2, ctms.getmAPHIEUMUONSACH());
           pst.setString(1, ctms.getmASACH()); 
               
            return pst.executeUpdate() >0;
        }        catch(SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
    }
}
   
    public static int getMadausach(int masach)
    {
        int temp = 0;
        String sql = "select madausach from cuonsach where masach = ?";
        try
        {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, masach);
            rs = pst.executeQuery();
            while(rs.next()){
               temp = rs.getInt("madausach");
            }
            
        }catch(SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
    }
        return temp;
    }
    
    public static boolean capnhatdausach(int madausach)
    {
        String  sql = "update dausach set dangchomuon = dangchomuon + 1, sanco = sanco - 1 where madausach = ?";      
        try 
        {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, madausach);
            return pst.executeUpdate() > 0;
            
        }catch(SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }
    public static boolean capnhatcuonsach(int masach)
    {
        String  sql = "update cuonsach set tinhtrang = ? where masach = ?";        
        try 
        {
            pst = conn.prepareStatement(sql);
            pst.setInt(2, masach);
            pst.setString(1, "đang cho mượn");
            return pst.executeUpdate() > 0;
            
        }catch(SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }
}
