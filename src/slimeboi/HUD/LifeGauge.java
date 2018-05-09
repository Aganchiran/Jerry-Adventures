/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.HUD;


import javafx.scene.canvas.GraphicsContext;
import slimeboi.Game;
import slimeboi.graphics.AssetsJerry;
import slimeboi.graphics.AssetsViejo;

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
            gc.drawImage(AssetsViejo.onAirRight.nextFrame(), i * 32, 0);
        }
        if(game.jerry.currentAnimation == ((AssetsJerry) game.jerry.assets).hurtRight ||
           game.jerry.currentAnimation == ((AssetsJerry) game.jerry.assets).hurtLeft){
            gc.drawImage(AssetsViejo.hurtRight.nextFrame(), health * 32, 0);
        }else{
            AssetsViejo.hurtRight.setCurrentAnimationFrame(0);
        }
        
    }
}
