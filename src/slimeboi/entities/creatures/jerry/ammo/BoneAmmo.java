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
    private int remainingBones = 5;
    private final BoneShot[] bones = new BoneShot[5];
    public BoneAmmo(Game game) {
        super(AssetsMikeleton.jermaine, new BoneShot(game.jerry.getXPos(), game.jerry.getYPos(), 2, AssetsMikeleton.jermaine, game), game);
        bones[0] = new BoneShot(game.jerry.getXPos(), game.jerry.getYPos(), 2, AssetsMikeleton.jackie, game);
        bones[1] = new BoneShot(game.jerry.getXPos(), game.jerry.getYPos(), 2, AssetsMikeleton.jermaine, game);
        bones[2] = new BoneShot(game.jerry.getXPos(), game.jerry.getYPos(), 2, AssetsMikeleton.marlon, game);
        bones[3] = new BoneShot(game.jerry.getXPos(), game.jerry.getYPos(), 2, AssetsMikeleton.randy, game);
        bones[4] = new BoneShot(game.jerry.getXPos(), game.jerry.getYPos(), 2, AssetsMikeleton.tito, game);
        super.yOffset = 3;
    }
    
    @Override
    public void fire(){
        remainingBones--;
        if(game.jerry.facingRight()){
            ((BoneShot)bones[remainingBones]).setIncrement(2);
        }else{
            ((BoneShot)bones[remainingBones]).setIncrement(-2);
        }
        
        bones[remainingBones].setXPos(game.jerry.getXPos());
        bones[remainingBones].setYPos(game.jerry.getYPos());
        game.getWorld().addEntityAtFront(bones[remainingBones]);
        
        if(remainingBones == 0){
            new Timeline(new KeyFrame(Duration.millis(game.jerry.currentAnimation.getDurationInMilis()), ae -> {
                game.jerry.state = game.jerry.notFreezedState;
                ControlLoader.enableControls();
                game.jerry.currentAnimation.setCurrentAnimationFrame(0);


                game.jerry.hasAmmo = false;
                ((Jerry) game.jerry).setAmmo(new NoAmmo(game.jerry.getGame()));

            })).play();
        }else{
            new Timeline(new KeyFrame(Duration.millis(100), ae -> {
                game.jerry.state = game.jerry.notFreezedState;
                ControlLoader.enableControls();
                game.jerry.currentAnimation.setCurrentAnimationFrame(0);

            })).play();
        }
    }
}
