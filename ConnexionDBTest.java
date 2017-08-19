/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dietrich
 */
public class ConnexionDBTest {
    
    public ConnexionDBTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of connectDB method, of class ConnexionDB.
     */
  @Test
    public void testConnectDB() {
        System.out.println("connectDB");
        ConnexionDB instance = new ConnexionDB();
        instance.connectDB();
        
    }

    /**
     * Test of AfficherM method, of class ConnexionDB.
     */
   /* @Test
    public void testAfficherM() {
        System.out.println("AfficherM");
        ConnexionDB instance = new ConnexionDB();
        instance.AfficherM();
       
    }*/

    /**
     * Test of afficherT method, of class ConnexionDB.
     */
    /*@Test
    public void testAfficherT() {
        System.out.println("afficherT");
        ConnexionDB instance = new ConnexionDB();
        instance.afficherT();
      
    }**/
    
}
