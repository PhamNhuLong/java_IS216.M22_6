/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import java.sql.*;
/**
 *
 * @author minh
 */
public class PhieuTraSach {
    private int mAPHIEUTRA,mADOCGIA, tIENPHATKINAY;
    private Date nGAYTRA;

    public PhieuTraSach() {
    }

    public PhieuTraSach(int mAPHIEUTRA, int mADOCGIA, int tIENPHATKINAY, Date nGAYTRA) {
        this.mAPHIEUTRA = mAPHIEUTRA;
        this.mADOCGIA = mADOCGIA;
        this.tIENPHATKINAY = tIENPHATKINAY;
        this.nGAYTRA = nGAYTRA;
    }

    public int getmAPHIEUTRA() {
        return mAPHIEUTRA;
    }

    public void setmAPHIEUTRA(int mAPHIEUTRA) {
        this.mAPHIEUTRA = mAPHIEUTRA;
    }

    public int getmADOCGIA() {
        return mADOCGIA;
    }

    public void setmADOCGIA(int mADOCGIA) {
        this.mADOCGIA = mADOCGIA;
    }

    public int gettIENPHATKINAY() {
        return tIENPHATKINAY;
    }

    public void settIENPHATKINAY(int tIENPHATKINAY) {
        this.tIENPHATKINAY = tIENPHATKINAY;
    }

    public Date getnGAYTRA() {
        return nGAYTRA;
    }

    public void setnGAYTRA(Date nGAYTRA) {
        this.nGAYTRA = nGAYTRA;
    }

    
}
