/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities;

import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author Javier Pastor Pérez
 */
public abstract class Entity {
    protected double xPos;
    protected double yPos;
    protected double width;
    protected double height;
    
    public Entity(double xPos, double yPos, double width, double height){
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
    }
    
    public abstract void render(GraphicsContext gc);
    
    public double getXPos(){
        return xPos;
    }
    
    public double getYPos(){
        return yPos;
    }
    
    public void setXPos(double newXPos){
        xPos = newXPos;
    }
    
    public void setYPos(double newYPos){
        yPos = newYPos;
    }
}
