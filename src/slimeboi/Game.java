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
import slimeboi.entities.creatures.Jerry;
import slimeboi.entities.tiles.EarthTile;
import slimeboi.graphics.Assets;
import slimeboi.input.KeyManager;

/**
 * FXML Controller class
 *
 * @author sabehas
 */
public class Game implements Initializable {

    @FXML
    private Canvas canvas;
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Jerry jerry = new Jerry(0,550,64,64);
        EarthTile[] ets = new EarthTile[200];
        for(int i = 0 ; i < 100 ; i++){
            ets[i] = new EarthTile((i * 32), 597,Assets.EarthUC);
            ets[i + 100] = new EarthTile((i * 32), 629,Assets.EarthCC);
        }
        
        
        
        //GAME LOOP//
        new AnimationTimer()
        {
            @Override
            public void handle(long currentNanoTime)
            {
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                jerry.render(gc);
                
                for(int i = 0 ; i < 200 ; i++){
                    ets[i].render(gc);
                }
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
