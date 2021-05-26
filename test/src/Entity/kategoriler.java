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
public class kategoriler {
    
    private int kategori_id;
    private String kategori_adi;

    public kategoriler() {
    }

    public kategoriler(int kategori_id, String kategori_adi) {
        this.kategori_id = kategori_id;
        this.kategori_adi = kategori_adi;
    }

    public int getKategori_id() {
        return kategori_id;
    }

    public void setKategori_id(int kategori_id) {
        this.kategori_id = kategori_id;
    }

    public String getKategori_adi() {
        return kategori_adi;
    }

    public void setKategori_adi(String kategori_adi) {
        this.kategori_adi = kategori_adi;
    }
    
    
    
    
}
