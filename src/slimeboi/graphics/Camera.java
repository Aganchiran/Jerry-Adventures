/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.graphics;

import slimeboi.Game;
import slimeboi.entities.Entity;

/**
 *
 * @author Javier Pastor Pérez
 */
public class Camera {
    private int xPos = 0;
    private int yPos = 0;
    private final Game game;
    
    public Camera(Game game){
        this.game = game;
    }
    
    public void centerOnEntity(Entity e){
        xPos = (int) (e.getXPos() - (game.getCanvas().getWidth() / 2) + (e.getHitBox().getWidth()/2));
        yPos = (int) (e.getYPos() - (game.getCanvas().getHeight()/ 2) + (e.getHitBox().getHeight()/2));
        notShowOutsideMap();
    }
    
    private void notShowOutsideMap(){
        double rightSideOfScreen = game.getCanvas().getWidth();
        double rightSideOfMap = game.getWorld().getWidthInPixels();
        double bottomOfScreen = game.getCanvas().getHeight();
        double bottomOfMap = game.getWorld().getHeightInPixels();
        
        if(xPos < 0) xPos = 0;
        else if(xPos + rightSideOfScreen > rightSideOfMap) xPos = (int) (rightSideOfMap - rightSideOfScreen);
        
        if(yPos < 0) yPos = 0;
        else if(yPos + bottomOfScreen > bottomOfMap) yPos = (int) (bottomOfMap - bottomOfScreen);
    }
    
    public double getXPos(){
        return xPos;
    }
    
    public double getYPos(){
        return yPos;
    }
}
