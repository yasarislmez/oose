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
import oose.urunInterface;
import util.Dbconnection;

/**
 *
 * @author ubuntu
 */
public class idgorelistele extends urunDaodecorator{

    Dbconnection db = Dbconnection.getDbConnectionSingleton();
    private List<urunler> urunlist = new ArrayList<>();
    
    
    @Override
    public List<urunler> urunlistele(List urunlistele) {
        
        getUrundao().urunlistele(urunlistele);
        return read(9);
        
    }
   

   public List<urunler> read(int a) {

        try {
            Statement st = db.connection().createStatement();
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
    
}
