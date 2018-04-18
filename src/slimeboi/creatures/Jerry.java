/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.creatures;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import slimeboi.graphics.CustomAnimation;
import slimeboi.input.KeyManager;

/**
 *
 * @author Javier Pastor Pérez
 */
public class Jerry extends Creature{
    
    private final String url = "slimeboi/resources/JerrySpriteSheet.png";
    private final int frameWidth = 64;
    private final int frameHeight = 64;

    
    private final CustomAnimation idleRight = new CustomAnimation(url, 26, 0, 0, frameWidth, frameHeight, 16);
    private final CustomAnimation idleLeft = new CustomAnimation(url, 26, 0, 3, frameWidth, frameHeight, 16);
    private final CustomAnimation right = new CustomAnimation(url, 26, 0, 6, frameWidth, frameHeight, 16);
    private final CustomAnimation left = new CustomAnimation(url, 26, 0, 9, frameWidth, frameHeight, 16);
    private final CustomAnimation endJumpRight = new CustomAnimation(url, 11, 0, 12, frameWidth, frameHeight, 30);
    private final CustomAnimation endJumpLeft = new CustomAnimation(url, 11, 0, 14, frameWidth, frameHeight, 30);
    private final CustomAnimation onAirRight = new CustomAnimation(url, 1, 0, 26, frameWidth, frameHeight, 60);
    private final CustomAnimation onAirLeft = new CustomAnimation(url, 1, 0, 27, frameWidth, frameHeight, 60);
    private final CustomAnimation biteRight = new CustomAnimation(url, 18, 0, 16, frameWidth, frameHeight, 30);
    private final CustomAnimation biteLeft = new CustomAnimation(url, 18, 0, 18, frameWidth, frameHeight, 30);
    private final CustomAnimation fatIdleRight = new CustomAnimation(url, 16, 0, 20, frameWidth, frameHeight, 12);
    private final CustomAnimation fatIdleLeft = new CustomAnimation(url, 16, 0, 22, frameWidth, frameHeight, 12);
    private final CustomAnimation fatRight = new CustomAnimation(url, 10, 0, 24, frameWidth, frameHeight, 6);
    private final CustomAnimation fatLeft = new CustomAnimation(url, 10, 0, 25, frameWidth, frameHeight, 6);
    
    
    
    private String orientation = "right";
    
    
    public Jerry(float xPos, float yPos){
        super(xPos, yPos);
        
        currentAnimation = idleRight;
    }
    
    @Override
    public void updateState(){
        if(KeyManager.checkKey(KeyCode.RIGHT.getName())){
            currentAnimation = right;
            orientation = "right";
            speed = 1;
        }else if(KeyManager.checkKey(KeyCode.LEFT.getName())){
            currentAnimation = left;
            orientation = "left";
            speed = -1;
        }else{
            if(orientation.equals("right")){
                currentAnimation = idleRight;
            }else{
                currentAnimation = idleLeft;
            }
            speed = 0;
        }
    }
    
}
