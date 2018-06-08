/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures.enemies;

import javafx.scene.paint.Paint;
import slimeboi.Game;
import slimeboi.entities.creatures.Creature;
import slimeboi.entities.creatures.jerry.ammo.Ammo;
import slimeboi.graphics.Assets;

/**
 *
 * @author Javier Pastor Pérez
 */
public abstract class Enemy extends Creature{
    protected Ammo ammo;
    protected boolean hurt = false;
    
    
    public Enemy(double xPos, double yPos, double width, double height, double xOffset, double yOffset, double speed, int health, Assets assets, Ammo ammo, Game game) {
        super(xPos, yPos, width, height, xOffset, yOffset, speed, health, assets, game);
        this.ammo = ammo;
    }
    
    protected boolean isEated(){
        return game.jerry.getBiteBounds().contains(this.getCollisionBounds(0, 0)) && game.jerry.isBiting();
    }
    
    protected boolean hitsJerry(){
        return game.jerry.getCollisionBounds(0, 0).intersects(this.getCollisionBounds(0, 0));
    }
    
    /*
    protected boolean isHurt(){
        //game.getCanvas().getGraphicsContext2D().setFill(Paint.valueOf("black"));
        //game.getCanvas().getGraphicsContext2D().fillRect(getCollisionBounds(0, 0).getMinX() - game.getCamera().getXPos(), getCollisionBounds(0, 0).getMinY() - game.getCamera().getYPos(), getCollisionBounds(0, 0).getWidth(), getCollisionBounds(0, 0).getHeight());
        //game.getCanvas().getGraphicsContext2D().fillRect(game.jerry.getAmmo().getShot().getCollisionBounds(0, 0).getMinX() - game.getCamera().getXPos(), game.jerry.getAmmo().getShot().getCollisionBounds(0, 0).getMinY() - game.getCamera().getYPos(), game.jerry.getAmmo().getShot().getCollisionBounds(0, 0).getWidth(), game.jerry.getAmmo().getShot().getCollisionBounds(0, 0).getHeight());
        return game.jerry.getAmmo().getShot().getCollisionBounds(0, 0).intersects(this.getCollisionBounds(0, 0));
    }*/
    
    /*@Override
    public boolean colidesX(){
        return false;
    }
    
    @Override
    public boolean colidesY(){
        return true;
    }*/
    
}
