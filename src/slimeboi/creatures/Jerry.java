/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.creatures;

import javafx.scene.canvas.GraphicsContext;
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
    
    private CustomAnimation currentAnimation;
    
    private CustomAnimation idleRight = new CustomAnimation(url, 26, 0, 0, frameWidth, frameHeight, 16);
    private CustomAnimation idleLeft = new CustomAnimation(url, 26, 0, 3, frameWidth, frameHeight, 16);
    private CustomAnimation right = new CustomAnimation(url, 26, 0, 6, frameWidth, frameHeight, 16);
    private CustomAnimation left = new CustomAnimation(url, 26, 0, 9, frameWidth, frameHeight, 16);
    private CustomAnimation endJumpRight = new CustomAnimation(url, 11, 0, 12, frameWidth, frameHeight, 30);
    private CustomAnimation endJumpLeft = new CustomAnimation(url, 11, 0, 14, frameWidth, frameHeight, 30);
    private CustomAnimation onAirRight = new CustomAnimation(url, 1, 0, 26, frameWidth, frameHeight, 60);
    private CustomAnimation onAirLeft = new CustomAnimation(url, 1, 0, 27, frameWidth, frameHeight, 60);
    
    private CustomAnimation biteRight = new CustomAnimation(url, 18, 0, 16, frameWidth, frameHeight, 30);
    private CustomAnimation biteLeft = new CustomAnimation(url, 18, 0, 18, frameWidth, frameHeight, 30);
    private CustomAnimation fatIdleRight = new CustomAnimation(url, 16, 0, 20, frameWidth, frameHeight, 12);
    private CustomAnimation fatIdleLeft = new CustomAnimation(url, 16, 0, 22, frameWidth, frameHeight, 12);
    private CustomAnimation fatRight = new CustomAnimation(url, 10, 0, 24, frameWidth, frameHeight, 6);
    private CustomAnimation fatLeft = new CustomAnimation(url, 10, 0, 25, frameWidth, frameHeight, 6);
    
    
    
    
    public Jerry(float xPos, float yPos){
        super(xPos, yPos);
        
        currentAnimation = idleRight;
    }
    
    public void render(GraphicsContext gc){
        if(KeyManager.checkKey()) currentAnimation = right;
        else currentAnimation = idleRight;
        
        gc.drawImage(currentAnimation.nextFrame(), xPos, yPos);
        
    }
    
}
