/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures.enemies;

import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import slimeboi.Game;
import slimeboi.entities.creatures.jerry.ammo.JackboneFive;
import slimeboi.entities.creatures.jerry.ammo.NoAmmo;
import slimeboi.graphics.AssetsMikeleton;

/**
 *
 * @author Javier Pastor Pérez
 */
public class Mikeleton extends Enemy{
    
    private long count = 0;
    private final int distance;
    private boolean dancing = false;
    private Timeline boneLoop;
    private boolean lastBoneWentRight = true;
    
    

    public Mikeleton(double xPos, double yPos, int distance, long boneLoopTime, Game game) {
        super(xPos, yPos, 15, 56, 24, 4, 0.5, 1, new AssetsMikeleton(),new NoAmmo(game), game);
        this.distance = distance;
        //boneAtack();
        /*
        Timeline chargeLoop = new Timeline(new KeyFrame(Duration.millis(5200), ae -> {
            assets.right.setCurrentAnimationFrame(0);
            assets.left.setCurrentAnimationFrame(0);
        }));
        
        chargeLoop.setCycleCount(Animation.INDEFINITE);
        chargeLoop.play();*/
        
        boneLoop = new Timeline(new KeyFrame(Duration.millis(boneLoopTime), ea -> {
            
            
            boneAtack();
            
        }));
        
        boneLoop.setCycleCount(Animation.INDEFINITE);
        boneLoop.play();
        
        /*Timer timer = new Timer();
        try {
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Hola");
                    thunderAtack();

                }
            };

            timer.scheduleAtFixedRate(task, 10, 3000);
        } finally {
            //timer.cancel();
        }*/
    }

    @Override
    public void updateCreatureStateSpecific() {
        
        
        if(isEated()){
            game.jerry.setAmmo(ammo);
            game.jerry.hasAmmo = true;
            kill();
        }
        
        if(!game.jerry.isBiting() && hitsJerry()){
            game.jerry.hurt();
        }
        
        if(isHurt()){
            kill();
        }
        
        if(!dancing){
            if(state == STATE_RIGHT){
                count++;
                if(count == distance) state = STATE_LEFT;
            }else{
                count--;
                if(count == 0) state = STATE_RIGHT;
            }
            
            state.move();
        }else{
            state.idle();
            
            if(currentAnimation.getCurrentAnimationFrame() == 1 && lastBoneWentRight){
                JackboneFive jackbone = new JackboneFive(xPos - 10, yPos, -3, game);
                game.getWorld().addEntityAtFront(jackbone);
                lastBoneWentRight = false;
            }else if(currentAnimation.getCurrentAnimationFrame() == 3 && !lastBoneWentRight){
                JackboneFive jackbone = new JackboneFive(xPos + 10, yPos, 3, game);
                game.getWorld().addEntityAtFront(jackbone);
                lastBoneWentRight = true;
            }
        }
    }
    
    
    private void boneAtack(){
        dancing = true;
        
        new Timeline(new KeyFrame(Duration.millis(2000), ae -> {
            assets.idleRight.setCurrentAnimationFrame(0);
            assets.idleLeft.setCurrentAnimationFrame(0);
            lastBoneWentRight = true;
            dancing = false;

        })).play();
    }

    
    @Override
    public void kill(){
        game.getWorld().killEntity(this);
        boneLoop.stop();
    }
}
