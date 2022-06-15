/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import java.sql.Date;

/**
 *
 * @author minh,hai
 */
public class DauSach {
    private String tENDAUSACH, tACGIA, nXB , vITRI;
    private int mADAUSACH, nAMXB,tONGSO, sANCO, dANGCHOMUON;

    public DauSach() {
    }

    public DauSach(String tENDAUSACH, String tACGIA, String nXB, String vITRI, int mADAUSACH, int nAMXB, int tONGSO, int sANCO, int dANGCHOMUON) {
        this.tENDAUSACH = tENDAUSACH;
        this.tACGIA = tACGIA;
        this.nXB = nXB;
        this.vITRI = vITRI;
        this.mADAUSACH = mADAUSACH;
        this.nAMXB = nAMXB;
        this.tONGSO = tONGSO;
        this.sANCO = sANCO;
        this.dANGCHOMUON = dANGCHOMUON;
    }

    public String gettENDAUSACH() {
        return tENDAUSACH;
    }

    public void settENDAUSACH(String tENDAUSACH) {
        this.tENDAUSACH = tENDAUSACH;
    }

    public String gettACGIA() {
        return tACGIA;
    }

    public void settACGIA(String tACGIA) {
        this.tACGIA = tACGIA;
    }

    public String getnXB() {
        return nXB;
    }

    public void setnXB(String nXB) {
        this.nXB = nXB;
    }

    public String getvITRI() {
        return vITRI;
    }

    public void setvITRI(String vITRI) {
        this.vITRI = vITRI;
    }

    public int getmADAUSACH() {
        return mADAUSACH;
    }

    public void setmADAUSACH(int mADAUSACH) {
        this.mADAUSACH = mADAUSACH;
    }

    public int getnAMXB() {
        return nAMXB;
    }

    public void setnAMXB(int nAMXB) {
        this.nAMXB = nAMXB;
    }

    public int gettONGSO() {
        return tONGSO;
    }

    public void settONGSO(int tONGSO) {
        this.tONGSO = tONGSO;
    }

    public int getsANCO() {
        return sANCO;
    }

    public void setsANCO(int sANCO) {
        this.sANCO = sANCO;
    }

    public int getdANGCHOMUON() {
        return dANGCHOMUON;
    }

    public void setdANGCHOMUON(int dANGCHOMUON) {
        this.dANGCHOMUON = dANGCHOMUON;
    }

    
    
}

    