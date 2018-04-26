/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures;

import javafx.scene.input.KeyCode;
import slimeboi.Game;
import slimeboi.graphics.Assets;
import slimeboi.input.KeyManager;

/**
 *
 * @author Javier Pastor Pérez
 */
public class Jerry extends Creature{
    

    private String orientation = "right";

    
    
    public Jerry(double xPos, double yPos, double width, double height, double xOffset, double yOffset, Game game){
        super(xPos, yPos, width, height, xOffset, yOffset, game);
        
        currentAnimation = Assets.idleRight;
    }
    
    @Override
    public void updateState(){
        if(KeyManager.checkKey(KeyCode.RIGHT.getName())){
            Assets.right.setCurrentAnimationFrame(currentAnimation.getCurrentAnimationFrame());
            currentAnimation = Assets.right;
            
            orientation = "right";
            xIncrement = 1;
        }else if(KeyManager.checkKey(KeyCode.LEFT.getName())){
            Assets.left.setCurrentAnimationFrame(currentAnimation.getCurrentAnimationFrame());
            currentAnimation = Assets.left;
            
            orientation = "left";
            xIncrement = -1;
        }else{
            if(orientation.equals("right")){
                Assets.idleRight.setCurrentAnimationFrame(currentAnimation.getCurrentAnimationFrame());
                currentAnimation = Assets.idleRight;
            }else{
                Assets.idleLeft.setCurrentAnimationFrame(currentAnimation.getCurrentAnimationFrame());
                currentAnimation = Assets.idleLeft;
            }
            xIncrement = 0;
        }
    }
    
}
