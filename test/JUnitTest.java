
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import util.Dbconnection;
import Dao.*;
import oose.*;

import static org.junit.Assert.*;

/**
 *
 * @author jack
 */
public class JUnitTest {
// strategy design patterns
    @Test
    public void test() {
        try {
            Dbconnection conn = Dbconnection.getDbConnectionSingleton();
            assertNotNull(conn.connection());
        } catch (Exception ex) {
            System.out.println("Ex ::::: " + ex + "");
        }                           
        try {
            urunDAO urun = new urunDAO();
            assertTrue(urun.read().size() > 0);
        } catch (Exception ex) {
            System.out.println("Ex ::::: " + ex + "");
        }
        try {
            urunDAO urun = new urunDAO();
            assertTrue(urun.read(3).size() > 0);
        } catch (Exception ex) {
            System.out.println("Ex ::::: " + ex + "");
        }
        
        try {
            INotification notification = new AddNotification();
            AddNotification tm = new AddNotification();
            assertEquals(tm.getNotificaionState() , notification.getNotificaionState());
        } catch (Exception e) {
        }
        
        try {
            INotification notification = new AddNotification();
            assertTrue(notification.getNotificaionState().length() > 0);
        } catch (Exception e) {
        }
        
        try {
            INotification notification = new AddNotification();
            String expected = "Urun Başarıyla Eklendi.";
            String actual = notification.getNotificaionState();
            assertEquals(expected, actual);
        } catch (Exception e) {
        }
    }
        
}
