/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.creatures;

/**
 *
 * @author Javier Pastor Pérez
 */
public abstract class Creature {
    protected double xPos,yPos;
    protected int health;
    protected double speed;
    
    public static final int DEFAULT_HEALTH = 3;
    public static final double DEFAULT_SPEED = 10;
    
    public Creature(double xPos, double yPos){
        this.xPos = xPos;
        this.yPos = yPos;
        this.health = DEFAULT_HEALTH;
        this.speed = DEFAULT_SPEED;
    }
    
    
    public double getXPos(){
        return xPos;
    }
    
    public double getYPos(){
        return yPos;
    }
    
    public int getHealth(){
        return health;
    }
    
    public double getSpeed(){
        return speed;
    }
    
    public void setXPos(double newXPos){
        xPos = newXPos;
    }
    
    public void setYPos(double newYPos){
        yPos = newYPos;
    }
    
    public void setHealth(int newHealth){
        health = newHealth;
    }
    
    public void setSpeed(double newSpeed){
        speed = newSpeed;
    }
 
}
