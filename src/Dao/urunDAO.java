/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.urunler;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Dbconnection;

/**
 *
 * @author ubuntu
 */
public class urunDAO extends Dbconnection {

    private List<urunler> urunlist = new ArrayList<>();

    public void create(urunler u) {

        try {
            Statement st = this.connection().createStatement();
            st.executeUpdate("insert into urunler (u_id,u_adi,a_fiyati,s_fiyati,kategori_id,firma_id)"
                    + " values('" + u.getU_id() + "''" + u.getU_adi() + "')'" + u.getA_fiyati() + "''"
                    + u.getS_fiyati() + "''" + u.getuK_id() + "''" + u.getuF_id() + "'");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public List<urunler> read(int a) {

        try {
            Statement st = this.connection().createStatement();
            ResultSet rs = st.executeQuery("select * from urunler where u_id=" + a + "");

            while (rs.next()) {
                urunler tmp = new urunler(rs.getInt("u_id"),
                        rs.getString("u_adi"),
                        rs.getDouble("a_fiyatı"),
                        rs.getDouble("s_fiyatı"),
                        rs.getInt("kategori_id"),
                        rs.getInt("firma_id"));
                urunlist.add(tmp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return urunlist;

    }

    public void update(urunler u) {

        try {
            Statement st = this.connection().createStatement();
            st.executeUpdate("update urunler set u_adi= '" + u.getU_adi() + "'where u_id=" + u.getU_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(urunler u) {

        try {
            Statement st = this.connection().createStatement();
            st.executeUpdate("delete from urunler where u_id=" + u.getU_id());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
