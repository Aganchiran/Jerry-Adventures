/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures;

import javafx.scene.canvas.GraphicsContext;
import static jdk.nashorn.internal.objects.Global.Infinity;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import slimeboi.Game;
import static org.junit.Assert.*;
import slimeboi.commands.ControlLoader;
import slimeboi.commands.DefaultControls;
import slimeboi.commands.LeftMovement;
import slimeboi.graphics.Assets;
import slimeboi.graphics.AssetsViejo;
import slimeboi.worlds.TutoriaLands;
import slimeboi.worlds.TestWorld;
import slimeboi.worlds.World;

/**
 *
 * @author Javier Pastor Pérez
 */
public class CreatureTest {
    public Game game;
    private CreatureImpl imp;

    
    public CreatureTest() {
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
        imp = new CreatureImpl(500,550);

    }
    
    @After
    public void tearDown() {
    }

    

    /**
     * Test of colidesX method, of class Creature.
     */
    @Test
    public void testColidesX() {
        System.out.println("colidesX");
        Creature instance = imp;
        boolean expResult = true;
        boolean result = instance.colidesX(); 
        
        assertEquals(expResult, result);
        
        imp.changeWorld(new TestWorld(false, game));
        expResult = false;
        result = instance.colidesX(); 
        assertEquals(expResult, result);
    }

    /**
     * Test of colidesY method, of class Creature.
     */
    @Test
    public void testColidesY() {
        System.out.println("colidesY");
        Creature instance = imp;
        boolean expResult = true;
        boolean result = instance.colidesY(); 
        
        assertEquals(expResult, result);
        
        imp.changeWorld(new TestWorld(false, game));
        expResult = false;
        result = instance.colidesY(); 
        assertEquals(expResult, result);
    }



    /**
     * Test of getHealth method, of class Creature.
     */
    @Test
    public void testGetHealth() {
        System.out.println("getHealth");
        Creature instance = imp;
        int expResult = 3;

        int result = instance.getHealth();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSpeed method, of class Creature.
     */
    @Test
    public void testGetSpeed() {
        System.out.println("getSpeed");
        Creature instance = imp;
        double expResult = 1;
        double result = instance.getSpeed();
        assertEquals(expResult, result, Infinity);
    }

    /**
     * Test of getXIncrement method, of class Creature.
     */
    @Test
    public void testGetXIncrement() {
        System.out.println("getXIncrement");
        Creature instance = imp;
        double expResult = 0;
        double result = instance.getXIncrement();
        assertEquals(expResult, result, Infinity);
        
        expResult = -1;
        imp.setSpeed(-1);
        result = instance.getXIncrement();
        assertEquals(expResult, result, Infinity);
        
        expResult = 1;
        imp.setSpeed(1);
        result = instance.getXIncrement();
        assertEquals(expResult, result, Infinity);
    }

    /**
     * Test of getYIncrement method, of class Creature.
     */
    @Test
    public void testGetYIncrement() {
        System.out.println("getYIncrement");
        Creature instance = imp;
        double expResult = 0;
        double result = instance.getYIncrement();
        assertEquals(expResult, result, Infinity);
        
        expResult = -1;
        imp.setSpeed(-1);
        result = instance.getYIncrement();
        assertEquals(expResult, result, Infinity);
        
        expResult = 1;
        imp.setSpeed(1);
        result = instance.getYIncrement();
        assertEquals(expResult, result, Infinity);
    }

    /**
     * Test of isOnAir method, of class Creature.
     */
    @Test
    public void testIsOnAir() {
        System.out.println("isOnAir");
        Creature instance = imp;
        boolean expResult = false;
        boolean result = instance.isOnAir();
        assertEquals(expResult, result);
        
        imp.changeWorld(new TestWorld(false, game));
        imp.updateCreatureStateGeneric();
        expResult = true;
        result = instance.isOnAir();
        assertEquals(expResult, result);
    }



    /**
     * Test of isFreezed method, of class Creature.
     */
    @Test
    public void testIsFreezed() {
        System.out.println("isFreezed");
        Creature instance = imp;
        boolean expResult = false;
        boolean result = instance.isFreezed();
        assertEquals(expResult, result);
        
        DefaultControls.LoadControlsA(game);
        imp.freeze(200);
        expResult = true;
        result = instance.isFreezed();
        assertEquals(expResult, result);
    }

    /**
     * Test of setXIncrement method, of class Creature.
     */
    @Test
    public void testSetXIncrement() {
        System.out.println("setXIncrement");
        double newIncrement = 0.0;
        Creature instance = imp;
        instance.setXIncrement(newIncrement);
        assertEquals(newIncrement,instance.getXIncrement(), Infinity);
    }

    /**
     * Test of setYIncrement method, of class Creature.
     */
    @Test
    public void testSetYIncrement() {
        System.out.println("setYIncrement");
        double newIncrement = 0.0;
        Creature instance = imp;
        instance.setYIncrement(newIncrement);
        assertEquals(newIncrement, instance.getYIncrement(), Infinity);
    }

    /**
     * Test of setHealth method, of class Creature.
     */
    @Test
    public void testSetHealth() {
        System.out.println("setHealth");
        int newHealth = 0;
        Creature instance = imp;
        instance.setHealth(newHealth);
        assertEquals(newHealth,instance.getHealth());
    }

    /**
     * Test of setSpeed method, of class Creature.
     */
    @Test
    public void testSetSpeed() {
        System.out.println("setSpeed");
        double newSpeed = 0.0;
        Creature instance = imp;
        instance.setSpeed(newSpeed);
        assertEquals(newSpeed, instance.getSpeed(), Infinity);
    }
    
    /**
     * Test of hurt method, of class Creature.
     */
    @Test
    public void testHurt() {
        System.out.println("hurt");
        Creature instance = imp;
        int expResult = imp.getHealth();
        instance.hurt();
        int result = imp.getHealth();
        assertEquals(expResult,result + 1);
    }
    
    public class CreatureImpl extends Creature {

        public CreatureImpl(double xPos, double yPos){
            super(xPos, yPos, 23, 16, 21, 30, 1, 3, new Assets() {}, null);
            super.game = new Game();
            game.setWorld(new TestWorld(true, game));
        }
        public void changeWorld(World world){
            game.setWorld(world);
        }
        @Override
        public void updateCreatureStateSpecific() {
        }
    }




    
}
