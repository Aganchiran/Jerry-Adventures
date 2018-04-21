/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures;

import javafx.scene.input.KeyCode;
import slimeboi.graphics.Assets;
import slimeboi.input.KeyManager;

/**
 *
 * @author Javier Pastor Pérez
 */
public class Jerry extends Creature{
    
    
    
    
    
    private String orientation = "right";
    
    
    public Jerry(double xPos, double yPos, double width, double height){
        super(xPos, yPos, width, height);
        
        currentAnimation = Assets.idleRight;
    }
    
    @Override
    public void updateState(){
        if(KeyManager.checkKey(KeyCode.RIGHT.getName())){
            currentAnimation = Assets.right;
            orientation = "right";
            speed = 1;
        }else if(KeyManager.checkKey(KeyCode.LEFT.getName())){
            currentAnimation = Assets.left;
            orientation = "left";
            speed = -1;
        }else{
            if(orientation.equals("right")){
                currentAnimation = Assets.idleRight;
            }else{
                currentAnimation = Assets.idleLeft;
            }
            speed = 0;
        }
    }
    
}
