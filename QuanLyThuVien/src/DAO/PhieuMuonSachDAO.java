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

public class PhieuMuonSachDAO {

    public static PreparedStatement pst = null;
    public static ResultSet rs = null;
    public static CallableStatement stmt = null;
    public static Connection conn = Connect.getConnect();

    public static boolean InsertPhieuMuonSach(PhieuMuonSach pms, String ms) {

        int count = 0;
        int temp = 0;

        String sql = "insert into PHIEUMUONSACH (MADOCGIA ,NGAYMUON) values ( ?, ?)";
        try {
            pst = conn.prepareStatement(sql);
            //pst.setString(1, pms.getmAPHIEUMUONSACH());
            pst.setString(1, pms.getmADOCGIA());
            pst.setDate(2, (Date) pms.getnGAYMUON());
            count += pst.executeUpdate();
            if (count > 0) {
                int ma = getMa();
                if (ChiTietMuonSachDAO.InsertCTMS2(ma, ms) != 0) {
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

    public static boolean DeletePhieuMuonSach(String maphieumuonsach) {

        String sql = "call xoa_phieu_muon_sach(?)";
        try {
            stmt = conn.prepareCall(sql);
            stmt.setString(1, maphieumuonsach);
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }

    public boolean UpdatePhieuMuonSach(PhieuMuonSach pms) {
        String sql = "update PHIEUMUONSACH set  MADOCGIA = ?, NGAYMUON = ? where MAPHIEUMUONSACH = ?";

        try {
            pst = conn.prepareStatement(sql);
            pst.setString(3, pms.getmAPHIEUMUONSACH());
            pst.setString(1, pms.getmADOCGIA());
            pst.setDate(2, (Date) pms.getnGAYMUON());

            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }

    public static int getMa() {

        String sql = "SELECT TOP 1 MAPHIEUMUONSACH  FROM PHIEUMUONSACH ORDER BY MAPHIEUMUONSACH DESC";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            int ma = 0;
            while (rs.next()) {
                ma = rs.getInt("MAPHIEUMUONSACH");
            }
            return ma;
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }

    public static ArrayList<String> LoadDataCbb() {
        String sql = "select MADOCGIA, HOTEN from DOCGIA";
        ArrayList<String> list = new ArrayList<String>();
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("MADOCGIA") + "," + rs.getString("HOTEN"));
            }
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
        return list;
    }

    public static ArrayList<String> LoadSach() {
        String sql = "select MASACH from CUONSACH where TINHTRANG = ?";
        ArrayList<String> list = new ArrayList<String>();
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, "sẵn có");
            rs = pst.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("MASACH"));
            }
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }

        return list;
    }

    public static int kiemtraSL(String madg) {
        String sql = "  select count(MASACH) AS SL \n"
                + "  FROM CTMS,PHIEUMUONSACH\n"
                + "  WHERE CTMS.MAPHIEUMUONSACH = PHIEUMUONSACH.MAPHIEUMUONSACH\n"
                + "  AND MADOCGIA = ?\n"
                + "  AND TINHTRANG = N'chưa trả'";
        int sl = 0;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, madg);
            rs = pst.executeQuery();
            while (rs.next()) {
                sl = rs.getInt("SL");
            }
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }

        return sl;
    }

    public static int kiemtraQuaHan(String madg) {

        String sql = "  select COUNT(MASACH) AS SL\n"
                + "  FROM CTMS,PHIEUMUONSACH\n"
                + "  WHERE CTMS.MAPHIEUMUONSACH = PHIEUMUONSACH.MAPHIEUMUONSACH\n"
                + "  AND MADOCGIA = ?\n"
                + "  AND TINHTRANG = N'chưa trả'\n"
                + "  AND DATEDIFF(DAY,NGAYMUON,GETDATE()) > 4;";
        int sl = 0;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, madg);
            rs = pst.executeQuery();
            while (rs.next()) {
                sl = rs.getInt("SL");
            }
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }

        return sl;
    }
}
