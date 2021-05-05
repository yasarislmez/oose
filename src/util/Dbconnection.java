
package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dbconnection {
    private Connection connection;

    public Connection connection(){
        
        try {
            Class.forName("org.postgresql.Driver");
            this.connection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/urunler","postgres","5234");
        } catch (Exception e) {
        }
        return this.connection;
    }

}
