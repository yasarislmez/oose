/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;



/**
 *
 * @author ubuntu
 */
public class satis {
    
    private int satis_id;
    private int urun_id;
    private double satis_fiyati;
    private Date satis_tarihi;

    public satis() {
    }

    public satis(int satis_id, int urun_id, double satis_fiyati, Date satis_tarihi) {
        this.satis_id = satis_id;
        this.urun_id = urun_id;
        this.satis_fiyati = satis_fiyati;
        this.satis_tarihi = satis_tarihi;
    }

    public int getSatis_id() {
        return satis_id;
    }

    public void setSatis_id(int satis_id) {
        this.satis_id = satis_id;
    }

    public int getUrun_id() {
        return urun_id;
    }

    public void setUrun_id(int urun_id) {
        this.urun_id = urun_id;
    }

    public double getSatis_fiyati() {
        return satis_fiyati;
    }

    public void setSatis_fiyati(double satis_fiyati) {
        this.satis_fiyati = satis_fiyati;
    }

    public Date getSatis_tarihi() {
        return satis_tarihi;
    }

    public void setSatis_tarihi(Date satis_tarihi) {
        this.satis_tarihi = satis_tarihi;
    }
    
    
    
}
