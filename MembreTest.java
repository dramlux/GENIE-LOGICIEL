/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dietrich
 */
public class MembreTest {
    
    public MembreTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getidMembre method, of class Membre.
     */
    @Test
    public void testGetidMembre() {
        System.out.println("getidMembre");
        Membre instance = new Membre();
        int expResult = 0;
        int result = instance.getidMembre();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setID method, of class Membre.
     */
    @Test
    public void testSetID() {
        System.out.println("setID");
        int iD = 0;
        int idMembre = 0;
        Membre instance = new Membre();
        instance.setID(iD, idMembre);
        
    }

    /**
     * Test of getNom method, of class Membre.
     */
    @Test
    public void testGetNom() {
        System.out.println("getNom");
        Membre instance = new Membre();
        String expResult = "";
        String result = instance.getNom();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setNom method, of class Membre.
     */
    @Test
    public void testSetNom() {
        System.out.println("setNom");
        String nom = "";
        Membre instance = new Membre();
        instance.setNom(nom);
       
    }

    /**
     * Test of connectDB method, of class Membre.
     */
   /* @Test
    public void testConnectDB() {
        System.out.println("connectDB");
        Membre instance = new Membre();
        instance.connectDB();
       
    }*/

    /**
     * Test of modifier method, of class Membre.
     */
   /* @Test
    public void testModifier() {
        System.out.println("modifier");
        Membre instance = new Membre();
        instance.modifier();
        
    }*/

    /**
     * Test of supprimer method, of class Membre.
     */
  /*  @Test
    public void testSupprimer() {
        System.out.println("supprimer");
        Membre instance = new Membre();
        instance.supprimer();
        
    }*/

    /**
     * Test of ajouter method, of class Membre.
     */
    @Test
    public void testAjouter() {
        //System.out.println("ajouter");
        Membre instance = new Membre();
        //boolean expResult = true;
         instance.ajouter();
        
        
    }

    /**
     * Test of selectionner method, of class Membre.
     */
   /* @Test
    public void testSelectionner() {
        System.out.println("selectionner");
        Membre instance = new Membre();
        instance.selectionner();
        
    }*/

    /**
     * Test of afficherDB method, of class Membre.
     */
  /*  @Test
    public void testAfficherDB() {
        System.out.println("afficherDB");
        Membre instance = new Membre();
        instance.afficherDB();
       
    }*/
    
}
