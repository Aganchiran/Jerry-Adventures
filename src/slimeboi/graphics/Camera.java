/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.graphics;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
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
    private final Timeline shake;
    private double changeShakeSign = 1;
    private boolean followJerry = true;
    
    public int rightOffset = 0;
    public int leftOffset = 0;
    public int upOffset = 0;
    public int downOffset = 0;
    
    public Camera(Game game){
        this.game = game;
        
        shake = new Timeline(new KeyFrame(Duration.millis(50), ae -> {
            changeShakeSign *= -1;
            xPos += Math.random() * 5 * changeShakeSign; 
        }));
        shake.setCycleCount(10);
    }
    
    public void centerOnEntity(Entity e){
        if(shake.getStatus() == Animation.Status.STOPPED && followJerry){
            xPos = (int) (e.getXPos() + e.getHitBox().getMinX() - (game.getCanvas().getWidth() / 2) + (e.getHitBox().getWidth()/2));
            yPos = (int) (e.getYPos() + e.getHitBox().getMinY() - (game.getCanvas().getHeight()/ 2) + (e.getHitBox().getHeight()/2));
            notShowOutsideMap();
        }
    }
    
    private void notShowOutsideMap(){
        double rightSideOfScreen = game.getCanvas().getWidth();
        double rightSideOfMap = game.getWorld().getWidthInPixels();
        double bottomOfScreen = game.getCanvas().getHeight();
        double bottomOfMap = game.getWorld().getHeightInPixels();
        
        if(xPos < leftOffset) xPos = leftOffset;
        else if(xPos + rightSideOfScreen > rightSideOfMap - rightOffset) xPos = (int) (rightSideOfMap - rightOffset - rightSideOfScreen);
        
        if(yPos < upOffset) yPos = upOffset;
        else if(yPos + bottomOfScreen > bottomOfMap - downOffset) yPos = (int) (bottomOfMap - downOffset - bottomOfScreen);
    }
    
    public double getXPos(){
        return xPos;
    }
    
    public double getYPos(){
        return yPos;
    }
    
    public void setXPos(int value){
        xPos = value;
    }
    
    public void setYPos(int value){
        yPos = value;
    }
    
    public void shake(){
        shake.play();
    }
    
    public void zoom(double multiplier){
        game.getCanvas().setScaleX(multiplier);
        game.getCanvas().setScaleY(multiplier);
    }
    
    public void setFollowJerry(boolean value){
        followJerry = value;
    }
}
