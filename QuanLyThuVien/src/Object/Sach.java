/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

/**
 *
 * @author Nguyen Linh
 */
public class Sach {
    String MaSach, TenSach;

    public Sach() {
    }

    public Sach(String MaSach, String TenSach) {
        this.MaSach = MaSach;
        this.TenSach = TenSach;
    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }
    
}
