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
public class firmalar {
    
    
    private int f_id;
    private String firma_marka_yayin_adi;
    private int gsm;
    private String adres;

    public firmalar() {
    }

    public firmalar(int firma_id, String firma_marka_yayin_adi, Integer gsm, String adres) {
        this.f_id = firma_id;
        this.firma_marka_yayin_adi = firma_marka_yayin_adi;
        this.gsm = gsm;
        this.adres = adres;
    }

    public int getFirma_id() {
        return f_id;
    }

    public void setFirma_id(int firma_id) {
        this.f_id = firma_id;
    }

    public String getFirma_marka_yayin_adi() {
        return firma_marka_yayin_adi;
    }

    public void setFirma_marka_yayin_adi(String firma_marka_yayin_adi) {
        this.firma_marka_yayin_adi = firma_marka_yayin_adi;
    }

    public Integer getGsm() {
        return gsm;
    }

    public void setGsm(Integer gsm) {
        this.gsm = gsm;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
    
    
}
