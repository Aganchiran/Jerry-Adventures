/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import slimeboi.commands.DefaultControls;
import slimeboi.entities.creatures.jerry.Jerry;
import slimeboi.input.KeyManager;
import slimeboi.worlds.Leaflands;
import slimeboi.worlds.World;

/**
 * FXML Controller class
 *
 * @author sabehas
 */
public class Game implements Initializable {

    @FXML
    private Canvas canvas;
    public World world;
    public static Jerry jerry;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        GraphicsContext gc = canvas.getGraphicsContext2D();
        jerry = new Jerry(35, 550, 23, 16, 21, 30, this);
        
        world = new Leaflands("music", "src/slimeboi/resources/GrassLands.txt", 40, 21);
        world.loadWorld();
        DefaultControls.LoadDefaultControls();
        
        //GAME LOOP//
        new AnimationTimer()
        {
            @Override
            public void handle(long currentNanoTime)
            {
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

                world.render(gc);
                jerry.render(gc);
            }
        }.start();
        
    }    
    
    public void listenKeys(){
        canvas.getScene().addEventFilter(KeyEvent.KEY_PRESSED, KeyEvent -> {
            KeyManager.pressingKey(KeyEvent);
        });
        
        canvas.getScene().addEventFilter(KeyEvent.KEY_RELEASED, KeyEvent -> {
            KeyManager.releasingKey(KeyEvent);
        });
    }
}
