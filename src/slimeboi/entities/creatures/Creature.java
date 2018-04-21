/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures;

import javafx.scene.canvas.GraphicsContext;
import slimeboi.entities.Entity;
import slimeboi.graphics.CustomAnimation;

/**
 *
 * @author Javier Pastor Pérez
 */
public abstract class Creature extends Entity{
    protected int health;
    protected double speed;
    protected CustomAnimation currentAnimation;
    
    public static final int DEFAULT_HEALTH = 3;
    public static final double DEFAULT_SPEED = 10;
    
    public Creature(double xPos, double yPos, double width, double height){
        super(xPos, yPos, width, height);
        this.health = DEFAULT_HEALTH;
        this.speed = DEFAULT_SPEED;
    }
    
    public void render(GraphicsContext gc){
        updateState();
        move();
        gc.drawImage(currentAnimation.nextFrame(), xPos, yPos);
    }
    
    public void move(){
        xPos += speed;
    }
    
    public abstract void updateState();
    
   
    
    public int getHealth(){
        return health;
    }
    
    public double getSpeed(){
        return speed;
    }
        
    public void setHealth(int newHealth){
        health = newHealth;
    }
    
    public void setSpeed(double newSpeed){
        speed = newSpeed;
    }
 
}
