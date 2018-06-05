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
 * @author Shion
 */
public class PincheAmmo extends Ammo {

    public PincheAmmo(Game game) {
        super(AssetsViejo.pincheAmmo, new PincheShot(0, 0, 0, game), game);

    }

    @Override
    public void fire() {
        game.getWorld().killEntity(shot);
        ((PincheShot) shot).resetHurteableEntities();
        if(game.jerry.facingRight()){
            ((PincheShot)shot).setXIncrement(5);
        }else{
            ((PincheShot)shot).setXIncrement(-5);
        }
        shot.setXPos(game.jerry.getXPos());
        shot.setYPos(game.jerry.getYPos());
        
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
