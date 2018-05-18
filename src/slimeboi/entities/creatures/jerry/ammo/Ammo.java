/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures.jerry.ammo;

import javafx.scene.canvas.GraphicsContext;
import slimeboi.Game;
import slimeboi.graphics.CustomAnimation;

/**
 *
 * @author Javier Pastor Pérez
 */
public abstract class Ammo {
    private final CustomAnimation animation;
    private final Game game;
    public Ammo(CustomAnimation animation, Game game){
        this.animation = animation;
        this.game = game;
    }
    
    public void render(GraphicsContext gc){
        gc.drawImage(animation.nextFrame(), game.jerry.getXPos() - game.getCamera().getXPos(), game.jerry.getYPos() - game.getCamera().getYPos());
    }
    
    public abstract void fire();
}
