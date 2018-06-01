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
import slimeboi.graphics.AssetsMikeleton;

/**
 *
 * @author Javier Pastor Pérez
 */
public class BoneAmmo extends Ammo{
    
    private final BoneShot[] bones = new BoneShot[1];
    public BoneAmmo(Game game) {
        super(AssetsMikeleton.jackbone, new BoneShot(game.jerry.getXPos(), game.jerry.getYPos(), game), game);
        bones[0] = new BoneShot(game.jerry.getXPos(), game.jerry.getYPos(), game);
    }
    
    @Override
    public void fire(){
        bones[0].setXPos(game.jerry.getXPos());
        bones[0].setYPos(game.jerry.getYPos());
        game.getWorld().addEntityAtFront(bones[0]);
        
        new Timeline(new KeyFrame(Duration.millis(game.jerry.currentAnimation.getDurationInMilis()), ae -> {
            game.jerry.currentAnimation.setCurrentAnimationFrame(0);
            game.jerry.hasAmmo = false;
            game.jerry.state = game.jerry.notFreezedState;
            ControlLoader.enableControls();
            ((Jerry) game.jerry).setAmmo(new NoAmmo(game.jerry.getGame()));
        })).play();
    }
}
