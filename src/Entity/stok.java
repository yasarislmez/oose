/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author ubuntu
 */
public class stok {
    
    private int stok_id;
    private int urun_id;
    private int adet;
    
     public stok() {
    }
    

    public stok(int stok_id, int urun_id, int adet) {
        this.stok_id = stok_id;
        this.urun_id = urun_id;
        this.adet = adet;
    }

    public int getStok_id() {
        return stok_id;
    }

    public void setStok_id(int stok_id) {
        this.stok_id = stok_id;
    }

    public int getUrun_id() {
        return urun_id;
    }

    public void setUrun_id(int urun_id) {
        this.urun_id = urun_id;
    }

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }

   
    
}
