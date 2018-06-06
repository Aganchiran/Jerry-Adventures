/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures.enemies;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Paths;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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
    private boolean previousOnAir = true;
    
    private final AudioClip stomp;
    
    private final Pinchita[] pinchitas = new Pinchita[10];
    
    public Bollito(double xPos, double yPos, int earthquakeLoopTime, Game game) {
        super(xPos, yPos, 237, 145, 142, 55, 0, 10, new AssetsBollito(), new NoAmmo(game), game);
        state = STATE_RIGHT_ON_AIR;
        for(int i = 0 ; i < pinchitas.length ; i++){
            pinchitas[i] = new Pinchita(0, 0, 0, false, game);
        }
        

        stomp = new AudioClip(Paths.get("src/slimeboi/resources/Stomp.mp3").toUri().toString());
        stomp.setVolume(0.6);
        
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
        
        if(previousOnAir && state == STATE_RIGHT){
            previousOnAir = false;
            currentAnimation = AssetsBollito.hitGround;
            currentAnimation.setCurrentAnimationFrame(6);
            
            stomp.play();
            game.getCamera().shake();
            game.jerry.jumpForce = game.jerry.DEFAULT_JUMP_FORCE/2;
            game.jerry.state.jump();
            game.jerry.jumpForce = game.jerry.DEFAULT_JUMP_FORCE;
            
            new Timeline(new KeyFrame(Duration.millis(currentAnimation.getDurationInMilisFromFrameToFrame(6, 11)), ae -> {
                AssetsBollito.hitGround.setCurrentAnimationFrame(0);
                currentAnimation = assets.idleRight;
                currentAnimation.setCurrentAnimationFrame(2);
            })).play();
        }
        
        if(hitReady && currentAnimation.getCurrentAnimationFrame() == 0){
            hitReady = false;
            currentAnimation = AssetsBollito.hitGround;

            new Timeline(new KeyFrame(Duration.millis(currentAnimation.getDurationInMilisFromFrameToFrame(0, 7)), ae -> {
                
                stomp.play();
                game.getCamera().shake();
                game.jerry.jumpForce = game.jerry.DEFAULT_JUMP_FORCE/2;
                game.jerry.state.jump();
                game.jerry.jumpForce = game.jerry.DEFAULT_JUMP_FORCE;
                
                for (Pinchita pinchita : pinchitas) {
                    if (!game.getWorld().isAlive(pinchita)) {
                        pinchita.heal(1);
                        pinchita.setXPos((int) (800 * Math.random()) + 60);
                        pinchita.setYPos(-100 + (int)(100 * Math.random()));
                        game.getWorld().addEntityAtFront(pinchita);
                    }else if (pinchita.getYIncrement() == 0) {
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
    }
    
}
