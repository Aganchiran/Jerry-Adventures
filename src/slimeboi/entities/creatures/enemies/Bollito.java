/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures.enemies;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import slimeboi.Game;
import slimeboi.entities.creatures.jerry.ammo.NoAmmo;
import slimeboi.graphics.AssetsBollito;

/**
 *
 * @author Javier Pastor Pérez
 */
public class Bollito extends Enemy{

    private final Timeline earthquakeLoop;
    private boolean hitReady = false;
    
    private final Pinchita[] pinchitas = new Pinchita[10];
    
    public Bollito(double xPos, double yPos, int earthquakeLoopTime, Game game) {
        super(xPos, yPos, 237, 145, 142, 55, 0, 10, new AssetsBollito(), new NoAmmo(game), game);
        
        for(int i = 0 ; i < pinchitas.length ; i++){
            pinchitas[i] = new Pinchita(800 * Math.random() + 60, 400, 0, false, game);
        }
        
        earthquakeLoop = new Timeline(new KeyFrame(Duration.millis(earthquakeLoopTime), ea -> {
            
            
            earthquakeAtack();
            
        }));
        
        earthquakeLoop.setCycleCount(Animation.INDEFINITE);
        earthquakeLoop.play();
    }

    @Override
    public void updateCreatureStateSpecific() {
        if(health == 0){
            kill();
        }
        
        
        if(hitReady && currentAnimation.getCurrentAnimationFrame() == 0){
            hitReady = false;
            currentAnimation = AssetsBollito.hitGround;
            
            new Timeline(new KeyFrame(Duration.millis(currentAnimation.getDurationInMilisFromFrameToFrame(0, 7)), ae -> {
                
                for (Pinchita pinchita : pinchitas) {
                    if (!game.getWorld().isAlive(pinchita)) {
                        pinchita.heal(1);
                        pinchita.setXPos(800 * Math.random() + 60);
                        pinchita.setYPos(400 + 100 * Math.random());
                        game.getWorld().addEntityAtFront(pinchita);
                    }
                    if (pinchita.getYIncrement() == 0) {
                        pinchita.setYIncrement(Math.random() * -8 - 2);
                    }
                }
                
            })).play();
            
            
            new Timeline(new KeyFrame(Duration.millis(currentAnimation.getDurationInMilis()), ae -> {
                AssetsBollito.hitGround.setCurrentAnimationFrame(0);
                currentAnimation = assets.idleRight;
                currentAnimation.setCurrentAnimationFrame(2);
                
            })).play();
        }
    }

    private void earthquakeAtack() {
        hitReady = true;
        /*currentAnimation = AssetsBollito.hitGround;
        new Timeline(new KeyFrame(Duration.millis(currentAnimation.getDurationInMilis()), ae -> {
            AssetsBollito.hitGround.setCurrentAnimationFrame(0);
            currentAnimation = assets.idleRight;
            currentAnimation.setCurrentAnimationFrame(2);
        })).play();*/
    }
    
}
