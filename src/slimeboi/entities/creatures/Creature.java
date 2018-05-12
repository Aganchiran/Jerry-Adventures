/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures;

import javafx.geometry.BoundingBox;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import slimeboi.Game;
import slimeboi.entities.Entity;
import slimeboi.entities.creatures.jerry.Jerry;
import slimeboi.entities.tiles.Tile;
import slimeboi.graphics.Assets;
import slimeboi.graphics.CustomAnimation;

/**
 *
 * @author Javier Pastor Pérez
 */
public abstract class Creature extends Entity{
    
    protected int health;
    protected double xIncrement;
    protected double yIncrement;
    public CustomAnimation currentAnimation;
    public CreatureState state;
    public CreatureState notFreezedState;
    protected boolean isOnAir = false;
    
    public final StateRight STATE_RIGHT = new StateRight(this);
    public final StateLeft STATE_LEFT = new StateLeft(this);
    public final StateLeftOnAir STATE_LEFT_ON_AIR = new StateLeftOnAir(this);
    public final StateRightOnAir STATE_RIGHT_ON_AIR = new StateRightOnAir(this);
    public final StateFreezed STATE_FREEZED = new StateFreezed(this);

    
    public Assets assets;
    public final int MAX_HEALTH;
    public final double DEFAULT_SPEED;
    public boolean hasAmmo;
    
    
    public Creature(double xPos, double yPos, double width, double height, double xOffset, double yOffset, double speed, int health, Assets assets, Game game){
        super(xPos, yPos, width, height, xOffset, yOffset, game);
        MAX_HEALTH = health;
        DEFAULT_SPEED = speed;
        this.hasAmmo = false;
        this.health = health;
        this.xIncrement = 0;
        this.assets = assets;
         

        currentAnimation = assets.idleRight;
        state = STATE_RIGHT;
        notFreezedState = STATE_RIGHT;
    }
    
    @Override
    public void render(GraphicsContext gc){
        updateState();
        gc.drawImage(currentAnimation.nextFrame(), xPos  - game.getCamera().getXPos(), yPos - game.getCamera().getYPos());
        yIncrement += 0.1;
        
        if(!colidesX()){
            moveX();
        }
        
        if(!colidesY()){
            isOnAir = true;
            if(state == STATE_LEFT){
                state = STATE_LEFT_ON_AIR;
                notFreezedState = STATE_LEFT_ON_AIR;
            }else if(state == STATE_RIGHT){
                state = STATE_RIGHT_ON_AIR;
                notFreezedState = STATE_RIGHT_ON_AIR;
            }
            moveY();
        } else {
            yIncrement = 0;
        }

        
        
        //Descomentar para visualizar hitbox//
        //gc.setFill(Paint.valueOf("black"));
        //gc.fillRect(getCollisionBounds(0, 0).getMinX() - game.getCamera().getXPos(), getCollisionBounds(0, 0).getMinY() - game.getCamera().getYPos(), getCollisionBounds(0, 0).getWidth(), getCollisionBounds(0, 0).getHeight());
        //gc.setFill(Paint.valueOf("red"));
        //if(this instanceof Jerry) gc.fillRect(((Jerry)this).getBiteBounds().getMinX() - game.getCamera().getXPos(), ((Jerry)this).getBiteBounds().getMinY() - game.getCamera().getYPos(), ((Jerry)this).getBiteBounds().getWidth(), ((Jerry)this).getBiteBounds().getHeight());
    }
    
    private void moveX(){
            xPos += xIncrement;
    }
    
    private void moveY(){
            yPos += yIncrement;
    }
    
    public boolean colidesX(){
        BoundingBox tileHitBox;
        
        for(int i = 0 ; i < 100 ; i++){
            for(int j = 0 ; j < 21 ; j++){
                tileHitBox = new BoundingBox(Tile.DEFAULT_WIDTH * i, Tile.DEFAULT_HEIGHT * j, Tile.DEFAULT_WIDTH, Tile.DEFAULT_HEIGHT);
                
                if(tileHitBox.intersects(this.getCollisionBounds(xIncrement, 0)) && game.getWorld().getTileset().get(game.getWorld().getMap()[i][j]).isSolid()){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean colidesY(){
        BoundingBox tileHitBox;
        
        for(int i = 0 ; i < 100 ; i++){
            for(int j = 0 ; j < 21 ; j++){
                tileHitBox = new BoundingBox(Tile.DEFAULT_WIDTH * i, Tile.DEFAULT_HEIGHT * j, Tile.DEFAULT_WIDTH, Tile.DEFAULT_HEIGHT);
                
                if(tileHitBox.intersects(this.getCollisionBounds(0, yIncrement)) && game.getWorld().getTileset().get(game.getWorld().getMap()[i][j]).isSolid()){
                    if(yIncrement > 0.1){
                        yPos = tileHitBox.getMinY() - this.hitBox.getMinY() - this.hitBox.getHeight() - 0.1;
                        isOnAir = false;
                        
                        if(state == STATE_LEFT_ON_AIR){
                            state = STATE_LEFT;
                        }else if(state == STATE_RIGHT_ON_AIR){
                            state = STATE_RIGHT;
                        }
                        
                        if(notFreezedState == STATE_LEFT_ON_AIR){
                            notFreezedState = STATE_LEFT;
                        }else if(notFreezedState == STATE_RIGHT_ON_AIR){
                            notFreezedState = STATE_RIGHT;
                        }
                    }
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public abstract void updateState();
    
   
    
    public int getHealth(){
        return health;
    }
    
    public double getSpeed(){
        return xIncrement;
    }
    
    
    
    public double getXIncrement(){
        return xIncrement;
    }
    
    public double getYIncrement(){
        return yIncrement;
    }
    
    public boolean isOnAir(){
        return notFreezedState == STATE_LEFT_ON_AIR || notFreezedState == STATE_RIGHT_ON_AIR;
    }
    
    public boolean facingRight(){
        return notFreezedState == STATE_RIGHT || notFreezedState == STATE_RIGHT_ON_AIR;
    }
    
    public boolean isFreezed(){
        return state == STATE_FREEZED;
    }
    
    public void setXIncrement(double newIncrement){
        xIncrement = newIncrement;
    }
    
    public void setYIncrement(double newIncrement){
        yIncrement = newIncrement;
    }
    
    public void setHealth(int newHealth){
        health = newHealth;
    }
    
    public void setSpeed(double newSpeed){
        xIncrement = newSpeed;
    }
}
