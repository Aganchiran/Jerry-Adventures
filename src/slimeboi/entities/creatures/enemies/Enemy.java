/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures.enemies;

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
}
