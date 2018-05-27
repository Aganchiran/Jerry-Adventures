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
import slimeboi.entities.creatures.jerry.ammo.SieteRayitos;
import slimeboi.entities.creatures.jerry.ammo.ThunderAmmo;
import slimeboi.graphics.AssetsBlancanubes;

/**
 *
 * @author Javier Pastor Pérez
 */
public class Blancanubes extends Enemy{
    
    private long count = 0;
    private final int distance;
    private boolean screaming = false;
    private boolean charging = false;
    private Timeline thunderLoop;
    
    private final SieteRayitos sieteRayitos = new SieteRayitos(xPos, yPos + hitBox.getMaxY() - 5, game);

    public Blancanubes(double xPos, double yPos, int distance, long thunderLoopTime, Game game) {
        super(xPos, yPos, 32, 23, 16, 20, 0.5, 1, new AssetsBlancanubes(),new ThunderAmmo(game), game);
        this.distance = distance;
        thunderAtack();
        /*
        Timeline chargeLoop = new Timeline(new KeyFrame(Duration.millis(5200), ae -> {
            assets.right.setCurrentAnimationFrame(0);
            assets.left.setCurrentAnimationFrame(0);
        }));
        
        chargeLoop.setCycleCount(Animation.INDEFINITE);
        chargeLoop.play();*/
        
        thunderLoop = new Timeline(new KeyFrame(Duration.millis(thunderLoopTime), ea -> {
            
            
            thunderAtack();
            
        }));
        
        thunderLoop.setCycleCount(Animation.INDEFINITE);
        thunderLoop.play();
        
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
        
        if(!screaming){
            if(state == STATE_RIGHT){
                count++;
                if(count == distance) state = STATE_LEFT;
            }else{
                count--;
                if(count == 0) state = STATE_RIGHT;
            }
            if(!charging){
                assets.right.setCurrentAnimationFrame(13);
                assets.left.setCurrentAnimationFrame(13);
            }
            state.move();
        }else{
            state.idle();
        }
    }
    
    @Override
    public boolean colidesY(){
        return true;
    }
    
    private void thunderAtack(){
        charging = true;
        assets.right.setCurrentAnimationFrame(0);
        assets.left.setCurrentAnimationFrame(0);
        
        new Timeline(new KeyFrame(Duration.millis(assets.right.getDurationInMilis()), ae -> {
            charging = false;
            if(game.getWorld().isAlive(this)){
                screaming = true;
                sieteRayitos.setXPos(xPos);
                game.getWorld().addEntityAtFront(sieteRayitos);

                new Timeline(new KeyFrame(Duration.millis(assets.idleRight.getDurationInMilis()), ea -> {

                    screaming = false;
                    sieteRayitos.kill();
                })).play();
            }
        })).play();
    }

    
    @Override
    public void kill(){
        game.getWorld().killEntity(this);
        
        thunderLoop.stop();
    }
}
