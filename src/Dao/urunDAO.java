
package Dao;

import Entity.urunler;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Dbconnection;


public class urunDAO extends Dbconnection {

    //urun listesi
    private List<urunler> urunlist = new ArrayList<>();

    //bir urun eklemek icin
    public void create(urunler u) {
        try {
            Statement st = this.connection().createStatement();
            st.executeUpdate("insert into urunler (u_adi,a_fiyati,s_fiyati)"
                    + " values('" + u.getU_adi() + "','" + u.getA_fiyati() + "','"
                    + u.getS_fiyati() + "')");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    
     public List<urunler> read() {

        try {
            Statement st = this.connection().createStatement();
            ResultSet rs = st.executeQuery("select * from urunler");

            while (rs.next()) {
                urunler tmp = new urunler(rs.getInt("u_id"),
                        rs.getString("u_adi"),
                        rs.getDouble("a_fiyati"),
                        rs.getDouble("s_fiyati"),
                        rs.getInt("kategori_id"),
                        rs.getInt("firma_id"));
                urunlist.add(tmp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return urunlist;

    }
    //urunlari listelemek ve yazmak icin (yazan id'ye gore)
    public List<urunler> read(int a) {

        try {
            Statement st = this.connection().createStatement();
            ResultSet rs = st.executeQuery("select * from urunler where u_id=" + a + "");

            while (rs.next()) {
                urunler tmp = new urunler(rs.getInt("u_id"),
                        rs.getString("u_adi"),
                        rs.getDouble("a_fiyati"),
                        rs.getDouble("s_fiyati"),
                        rs.getInt("kategori_id"),
                        rs.getInt("firma_id"));
                urunlist.add(tmp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return urunlist;

    }
    
    //urunlari guncellemek icin giter butonu kullanarak
    public void update(urunler u) {

        try {
            Statement st = this.connection().createStatement();
            st.executeUpdate("update urunler set u_adi= '" + u.getU_adi()
                    + "',a_fiyati='"+u.getA_fiyati()+"', s_fiyati= '"
                    +u.getS_fiyati()+"' where u_id=" + u.getU_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    //bir urun silme metodu(yazan id'ye gore)
    public void delete(int id) {

        try {
            Statement st = this.connection().createStatement();
            st.executeUpdate("delete from urunler where u_id=" + id);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
