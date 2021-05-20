/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author ubuntu
 */
public class Dbconnection {
//    
//    private Connection connection;
//    
//    public Connection connection(){
//       
//        try {
//             Statement st = connection().createStatement();
//            Class.forName("org.postgresql.Driver");
//            this.connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/nyym","postgres","1234");
//        } catch (Exception e) {
//        }
//        return this.connection;
//    }

    private static Dbconnection dbConnectionSingleton;
    private Connection connection;

    private Dbconnection() {

    }

    public static Dbconnection getDbConnectionSingleton() {

        if (dbConnectionSingleton == null) {
            return dbConnectionSingleton = new Dbconnection();
        }
        return dbConnectionSingleton;

    }

    public Connection connection() {

        try {

            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/nyym", "postgres", "1234");
        } catch (Exception e) {
        }
        return this.connection;
    }
}
