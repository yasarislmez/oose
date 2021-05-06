/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.stok;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Dbconnection;

/**
 *
 * @author ubuntu
 */
public class stokDao {

    Dbconnection db = Dbconnection.getDbConnectionSingleton();
    private List<stok> stokList = new ArrayList();

    public List<stok> read() {

        try {
            Statement st = db.connection().createStatement();
            ResultSet rs = st.executeQuery("select * from stok");

            while (rs.next()) {
                stok tmp = new stok(
                        rs.getInt("stok_id"),
                        rs.getInt("urun_id"),
                        rs.getInt("adet")
                );
                stokList.add(tmp);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return stokList;

    }
    
    
//    private static stokDao stokDaonesnesi;
//
//    public static stokDao getStokDaonesnesi() {
//        if (stokDaonesnesi == null) {
//            return stokDaonesnesi = new stokDao();
//        }
//        return stokDaonesnesi;
//    }
//    
//
//    private stokDao() {
//
//    }

   
}
