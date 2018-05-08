/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.HUD;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import slimeboi.Game;

/**
 *
 * @author Javier Pastor Pérez
 */
public class LifeGauge {
    
    private final Game game;
    
    public LifeGauge(Game game){
        this.game = game;
    }
    
    public void render(GraphicsContext gc){
        int health = game.jerry.getHealth();
        for(int i = 0; i < health ; i++){
            gc.drawImage(game.jerry.assets.onAirRight.nextFrame(), i * 32, 0);
        }
        
        
    }
}
