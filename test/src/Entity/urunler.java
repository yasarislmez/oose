
package Entity;


public class urunler {

    private int u_id;
    private String u_adi;
    private double a_fiyati;
    private double s_fiyati;
    private int kategori_id;
    private int firma_id;

    public urunler() {
    }

    public urunler(int u_id, String u_adi, double a_fiyati, double s_fiyati, int uK_id, int uF_id) {
        this.u_id = u_id;
        this.u_adi = u_adi;
        this.a_fiyati = a_fiyati;
        this.s_fiyati = s_fiyati;
        this.kategori_id = uK_id;
        this.firma_id = uF_id;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getU_adi() {
        return u_adi;
    }

    public void setU_adi(String u_adi) {
        this.u_adi = u_adi;
    }

    public double getA_fiyati() {
        return a_fiyati;
    }

    public void setA_fiyati(double a_fiyati) {
        this.a_fiyati = a_fiyati;
    }

    public double getS_fiyati() {
        return s_fiyati;
    }

    public void setS_fiyati(double s_fiyati) {
        this.s_fiyati = s_fiyati;
    }

    public int getKategori_id() {
        return kategori_id;
    }

    public void setKategori_id(int kategori_id) {
        this.kategori_id = kategori_id;
    }

    public int getFirma_id() {
        return firma_id;
    }

    public void setFirma_id(int firma_id) {
        this.firma_id = firma_id;
    }
}