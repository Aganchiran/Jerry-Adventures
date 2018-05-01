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
    protected CustomAnimation currentAnimation;
    public CreatureState state;
    protected boolean isOnAir = false;
    
    public final StateRight STATE_RIGHT = new StateRight(this);
    public final StateLeft STATE_LEFT = new StateLeft(this);
    public final StateLeftOnAir STATE_LEFT_ON_AIR = new StateLeftOnAir(this);
    public final StateRightOnAir STATE_RIGHT_ON_AIR = new StateRightOnAir(this);

    
    public final Assets assets;
    public static final int DEFAULT_HEALTH = 3;
    public static final double DEFAULT_SPEED = 10;
    
    
    public Creature(double xPos, double yPos, double width, double height, double xOffset, double yOffset, Assets assets, Game game){
        super(xPos, yPos, width, height, xOffset, yOffset, game);
        this.health = DEFAULT_HEALTH;
        this.xIncrement = 0;
        this.assets = assets;
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
            moveY();
        } else {
            yIncrement = 0;
        }

        
        
        //Descomentar para visualizar hitbox//
        //gc.setFill(Paint.valueOf("black"));
        //gc.fillRect(getCollisionBounds(0, 0).getMinX(), getCollisionBounds(0, 0).getMinY(), getCollisionBounds(0, 0).getWidthInPixels(), getCollisionBounds(0, 0).getHeightInPixels());

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
                    if(yIncrement > 0){
                        yPos = tileHitBox.getMinY() - this.hitBox.getMinY() - this.hitBox.getHeight() - 0.1;
                        isOnAir = false;
                        if(state == STATE_LEFT_ON_AIR)state = STATE_LEFT;
                        else if(state == STATE_RIGHT_ON_AIR) state = STATE_RIGHT;
                    }
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public BoundingBox getCollisionBounds(double xIncrement, double yIncrement){
        return new BoundingBox(xPos + hitBox.getMinX() + xIncrement, yPos + hitBox.getMinY() + yIncrement, hitBox.getWidth(), hitBox.getHeight());
    }
    
    public abstract void updateState();
    
   
    
    public int getHealth(){
        return health;
    }
    
    public double getSpeed(){
        return xIncrement;
    }
    
    public double getYIncrement(){
        return yIncrement;
    }
    
    public boolean isOnAir(){
        return state == STATE_LEFT_ON_AIR || state == STATE_RIGHT_ON_AIR;
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
