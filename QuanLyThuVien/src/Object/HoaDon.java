/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import java.sql.Date;

/**
 *
 * @author minh
 */
public class HoaDon extends PhieuTraSach {
    private int mAHD,mAPHIEUTRA,tIENNO,tIENTHU;

    public HoaDon() {
    }

    public HoaDon(int mAPHIEUTRA, int mADOCGIA, int tIENPHATKINAY, Date nGAYTRA) {
        super(mAPHIEUTRA, mADOCGIA, tIENPHATKINAY, nGAYTRA);
    }

    public int getmAHD() {
        return mAHD;
    }

    public void setmAHD(int mAHD) {
        this.mAHD = mAHD;
    }

    public int getmAPHIEUTRA() {
        return mAPHIEUTRA;
    }

    public void setmAPHIEUTRA(int mAPHIEUTRA) {
        this.mAPHIEUTRA = mAPHIEUTRA;
    }

    public int gettIENNO() {
        return tIENNO;
    }

    public void settIENNO(int tIENNO) {
        this.tIENNO = tIENNO;
    }

    public int gettIENTHU() {
        return tIENTHU;
    }

    public void settIENTHU(int tIENTHU) {
        this.tIENTHU = tIENTHU;
    }

    
}
    