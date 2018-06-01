/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures.jerry.ammo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import slimeboi.Game;
import slimeboi.commands.ControlLoader;
import slimeboi.entities.creatures.jerry.Jerry;
import slimeboi.graphics.AssetsViejo;

/**
 *
 * @author Javier Pastor Pérez
 */
public class ShuriAmmo extends Ammo{
    
    public ShuriAmmo(Game game) {
        super(AssetsViejo.shuriAmmo, new ShuriShot(  game.jerry.getXPos(),  game.jerry.getYPos() , 5, game), game);
    }
    
    @Override
    public void fire(){
        game.getWorld().addEntityAtFront(shot);
        
        
            
        game.jerry.hasAmmo = false;

        ((Jerry) game.jerry).setAmmo(new NoAmmo(game.jerry.getGame()));

        new Timeline(new KeyFrame(Duration.millis(game.jerry.currentAnimation.getDurationInMilis() - 75), ea -> {
            game.jerry.currentAnimation.setCurrentAnimationFrame(0);
            game.jerry.state = game.jerry.notFreezedState;
            ControlLoader.enableControls();
        })).play();
       
    }
}
