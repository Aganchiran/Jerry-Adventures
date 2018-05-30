/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.BoundingBox;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import slimeboi.Game;
import slimeboi.commands.ControlLoader;
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
    public final int DEFAULT_JUMP_FORCE = -4;
    public int jumpForce = -4;
    
    public Assets assets;
    public final int MAX_HEALTH;
    public double speed;
    public boolean hasAmmo;
    
    
    public Creature(double xPos, double yPos, double width, double height, double xOffset, double yOffset, double speed, int health, Assets assets, Game game){
        super(xPos, yPos, width, height, xOffset, yOffset, game);
        MAX_HEALTH = health;
        this.speed = speed;
        this.hasAmmo = false;
        this.health = health;
        this.xIncrement = 0;
        this.assets = assets;
         

        currentAnimation = assets.idleRight;
        state = STATE_RIGHT;
        notFreezedState = STATE_RIGHT;
    }
    

    @Override
    public void updateState(){
        //Descomentar para visualizar hitbox//
        //game.getCanvas().getGraphicsContext2D().setFill(Paint.valueOf("black"));
        //game.getCanvas().getGraphicsContext2D().fillRect(getCollisionBounds(0, 0).getMinX() - game.getCamera().getXPos(), getCollisionBounds(0, 0).getMinY() - game.getCamera().getYPos(), getCollisionBounds(0, 0).getWidth(), getCollisionBounds(0, 0).getHeight());
        //game.getCanvas().getGraphicsContext2D().setFill(Color.rgb(255, 0, 0, 0.5));
        // if(this instanceof Jerry) game.getCanvas().getGraphicsContext2D().fillRect(((Jerry)this).getBiteBounds().getMinX() - game.getCamera().getXPos(), ((Jerry)this).getBiteBounds().getMinY() - game.getCamera().getYPos(), ((Jerry)this).getBiteBounds().getWidth(), ((Jerry)this).getBiteBounds().getHeight());
        
        updateCreatureStateSpecific();
        render(game.getCanvas().getGraphicsContext2D());
        updateCreatureStateGeneric();

    }
    
    protected void moveX(){
            xPos += xIncrement;
    }
    
    protected void moveY(){
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
    
    public void freeze(int timeFreezed){
        
        state = STATE_FREEZED;        
        ControlLoader.disableControls();
        new Timeline(new KeyFrame(Duration.millis(timeFreezed), ae -> {
            currentAnimation.setCurrentAnimationFrame(0);
            state = notFreezedState;

            ControlLoader.enableControls();
        })).play();
                
        /*timer = new Timer();
        
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                currentAnimation.setCurrentAnimationFrame(0);
                state = notFreezedState;
                
                ControlLoader.enableControls();
                //timer.cancel();
            }
        };
        
        
        
        timer.schedule(task, timeFreezed);*/
    }
    
    public void render(GraphicsContext gc){
    gc.drawImage(currentAnimation.nextFrame(), xPos  - game.getCamera().getXPos(), yPos - game.getCamera().getYPos());
    }
    
    public void updateCreatureStateGeneric(){
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
    }
    public abstract void updateCreatureStateSpecific();
    
    public void hurt(){
        if(health > 0) health--;
    };
    
    public int getHealth(){
        return health;
    }
    
    public double getSpeed(){
        return speed;
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
        speed = newSpeed;
    }
}
