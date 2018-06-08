/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures.jerry;

import javafx.geometry.BoundingBox;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import slimeboi.Game;
import slimeboi.entities.creatures.ammo.Ammo;

/**
 *
 * @author sabehas
 */
public class JerryTest {
    
    private Jerry jerry;
    private Game game;
        
    public JerryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        game = new Game();
        jerry = new Jerry(0, 0, game);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of updateCreatureStateSpecific method, of class Jerry.
     */
    @Test
    public void testUpdateState() {
        System.out.println("updateState");
        Jerry instance = jerry;
        instance.updateCreatureStateSpecific();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of freeze method, of class Jerry.
     */
    @Test
    public void testFreeze() {
        System.out.println("freeze");
        int timeFreezed = 0;
        Jerry instance = null;
        instance.freeze(timeFreezed);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBiteBounds method, of class Jerry.
     */
    @Test
    public void testGetBiteBounds() {
        System.out.println("getBiteBounds");
        Jerry instance = null;
        BoundingBox expResult = null;
        BoundingBox result = instance.getBiteBounds();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isBiting method, of class Jerry.
     */
    @Test
    public void testIsBiting() {
        System.out.println("isBiting");
        Jerry instance = null;
        boolean expResult = false;
        boolean result = instance.isBiting();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hurt method, of class Jerry.
     */
    @Test
    public void testHurt() {
        System.out.println("hurt");
        Jerry instance = null;
        instance.hurt();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeInvulnerable method, of class Jerry.
     */
    @Test
    public void testMakeInvulnerable() {
        System.out.println("makeInvulnerable");
        Jerry instance = null;
        instance.makeInvulnerable();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAmmo method, of class Jerry.
     */
    @Test
    public void testSetAmmo() {
        System.out.println("setAmmo");
        Ammo newAmmo = null;
        Jerry instance = null;
        instance.setAmmo(newAmmo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
