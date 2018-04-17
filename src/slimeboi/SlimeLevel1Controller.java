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
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyEvent;
import slimeboi.creatures.Jerry;
import slimeboi.graphics.CustomAnimation;
import slimeboi.input.KeyManager;

/**
 * FXML Controller class
 *
 * @author sabehas
 */
public class SlimeLevel1Controller implements Initializable {

    @FXML
    private Canvas canvas;
    
    private double x = 10;
    private double y = 10;
    private int xInc = 5;
    private int yInc = 5;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Jerry jerry = new Jerry(0,0);
        
        
        
        //GAME LOOP//
        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                gc.clearRect(0, 0, 600, 400);
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
