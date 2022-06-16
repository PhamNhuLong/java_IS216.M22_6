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
public class ChiTietTraSach extends PhieuTraSach {
    private int mAPHIEUTRA, mASACH, sONGAYTRATRE, tIENPHAt;

    public ChiTietTraSach() {
    }

    public ChiTietTraSach(int mAPHIEUTRA, int mADOCGIA, int tIENPHATKINAY, Date nGAYTRA) {
        super(mAPHIEUTRA, mADOCGIA, tIENPHATKINAY, nGAYTRA);
    }

    public int getmAPHIEUTRA() {
        return mAPHIEUTRA;
    }

    public void setmAPHIEUTRA(int mAPHIEUTRA) {
        this.mAPHIEUTRA = mAPHIEUTRA;
    }

    public int getmASACH() {
        return mASACH;
    }

    public void setmASACH(int mASACH) {
        this.mASACH = mASACH;
    }

    public int getsONGAYTRATRE() {
        return sONGAYTRATRE;
    }

    public void setsONGAYTRATRE(int sONGAYTRATRE) {
        this.sONGAYTRATRE = sONGAYTRATRE;
    }

    public int gettIENPHAt() {
        return tIENPHAt;
    }

    public void settIENPHAt(int tIENPHAt) {
        this.tIENPHAt = tIENPHAt;
    }
    
}
