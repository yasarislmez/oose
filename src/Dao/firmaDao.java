/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.firmalar;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Dbconnection;

/**
 *
 * @author ubuntu
 */
public class firmaDao {

    private List<firmalar> firmaListesi = new ArrayList();
    Dbconnection db = Dbconnection.getDbConnectionSingleton();

    public List<firmalar> read() {

        try {
            Statement st = db.connection().createStatement();
            ResultSet rs = st.executeQuery("select * from firmalar");

            while (rs.next()) {
                firmalar tmp = new firmalar(
                        rs.getInt("f_id"),
                        rs.getString("firma_marka_yayin_adi"),
                        rs.getInt("Gsm"),
                        rs.getString("Adres"));
                firmaListesi.add(tmp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return firmaListesi;

    }
    
     public void delete(int id) {

        try {
            Statement st = db.connection().createStatement();
            st.executeUpdate("delete from firmalar where f_id=" + id);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
     }
}
