/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities;

import javafx.geometry.BoundingBox;
import javafx.scene.canvas.GraphicsContext;
import slimeboi.Game;

/**
 *
 * @author Javier Pastor Pérez
 */
public abstract class Entity {
    protected double xPos;
    protected double yPos;

    protected BoundingBox hitBox;
    protected Game game;
    
    
    public Entity(double xPos, double yPos, double width, double height, double xOffset, double yOffset, Game game){
        this.xPos = xPos;
        this.yPos = yPos;
        
        this.hitBox = new BoundingBox(xOffset, yOffset, width, height);
        this.game = game;
    }
    
    public BoundingBox getCollisionBounds(double xIncrement, double yIncrement){
        return new BoundingBox(xPos + hitBox.getMinX() + xIncrement, yPos + hitBox.getMinY() + yIncrement, hitBox.getWidth(), hitBox.getHeight());
    }
    
    public abstract void updateState();
    
    public double getXPos(){
        return xPos;
    }
    
    public double getYPos(){
        return yPos;
    }
    
    public BoundingBox getHitBox(){
        return hitBox;
    }
    
    public void setXPos(double newXPos){
        xPos = newXPos;
    }
    
    public void setYPos(double newYPos){
        yPos = newYPos;
    }
    
    
}
