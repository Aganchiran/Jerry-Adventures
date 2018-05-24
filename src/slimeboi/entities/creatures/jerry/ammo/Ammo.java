/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures.jerry.ammo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.util.Duration;
import slimeboi.Game;
import slimeboi.commands.ControlLoader;
import slimeboi.entities.creatures.jerry.Jerry;
import slimeboi.graphics.CustomAnimation;

/**
 *
 * @author Javier Pastor Pérez
 */
public abstract class Ammo {
    private final CustomAnimation animation;
    protected final Game game;
    protected final Shot shot;
    private int correctXPos = 2;
    
    public Ammo(CustomAnimation animation, Shot shot, Game game){
        this.animation = animation;
        this.game = game;
        this.shot = shot;
    }
    
    public void render(GraphicsContext gc){
        if(game.jerry.facingRight())correctXPos = 0;
        else correctXPos = 2;
        
        if(!game.jerry.isFreezed()){
            gc.drawImage(animation.nextFrame(), game.jerry.getXPos() - game.getCamera().getXPos() - correctXPos, game.jerry.getYPos() - game.getCamera().getYPos());
        }
    }
    
    public void fire(){
        new Timeline(new KeyFrame(Duration.millis(game.jerry.currentAnimation.getDurationInMilis()), ae -> {
            game.jerry.currentAnimation.setCurrentAnimationFrame(0);
            game.jerry.hasAmmo = false;
            game.jerry.state = game.jerry.notFreezedState;
            ControlLoader.enableControls();
            ((Jerry) game.jerry).setAmmo(new NoAmmo(game.jerry.getGame()));
        })).play();
    };
    
    public Shot getShot(){
        return shot;
    }
}
