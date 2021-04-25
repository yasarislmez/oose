/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ubuntu
 */
public class Dbconnection {
    
    private Connection connection;
    
    public Connection connection(){
        
        try {
            Class.forName("org.postgresql.Driver");
            this.connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/urunler","postgres","1234");
        } catch (Exception e) {
        }
        return this.connection;
    }
}
