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
import slimeboi.entities.creatures.jerry.Jerry;
import slimeboi.entities.tiles.EarthTile;
import slimeboi.entities.tiles.SkyTile;
import slimeboi.entities.tiles.Tile;
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
    public Tile[][] tiles = new Tile[100][21];
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Jerry jerry = new Jerry(0, 550, 23, 16, 21, 30, this);

        for(int i = 0 ; i < 100 ; i++){
            for(int j = 0 ; j < 19 ; j++){
               tiles[i][j] = new SkyTile((i * 32), 597 - (32 * (j + 1)),Assets.Sky, this);
            }
            tiles[i][19] = new EarthTile((i * 32), 597,Assets.EarthUpCenter, this);
            tiles[i][20] = new EarthTile((i * 32), 629,Assets.EarthCenterCenter, this);
        }

        tiles[5][18] = new EarthTile((5 * 32), 565,Assets.EarthVerticalUp, this);
        tiles[5][19] = new EarthTile((5 * 32), 597,Assets.EarthCenterCenter, this);
        
        //GAME LOOP//
        new AnimationTimer()
        {
            @Override
            public void handle(long currentNanoTime)
            {
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

                for(int i = 0 ; i < 100 ; i++){
                    for(int j = 0 ; j < 21 ; j++){
                        tiles[i][j].render(gc);
                    }
                }
                
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
