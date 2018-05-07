/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.HUD;

import javafx.scene.canvas.GraphicsContext;
import slimeboi.Game;

/**
 *
 * @author Javier Pastor Pérez
 */
public class HUD {
    
    private final Game game;
    private LifeGauge lifeGauge;
    
    public HUD(Game game){
        this.game = game;
        lifeGauge = new LifeGauge(game);
    }
    
    public void render(GraphicsContext gc){
        lifeGauge.render(gc);
    }
}
