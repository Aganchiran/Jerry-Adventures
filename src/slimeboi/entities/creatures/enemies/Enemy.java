/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures.enemies;

import slimeboi.Game;
import slimeboi.entities.creatures.Creature;
import slimeboi.graphics.Assets;
import slimeboi.graphics.AssetsJerry;

/**
 *
 * @author Javier Pastor Pérez
 */
public abstract class Enemy extends Creature{

    public Enemy(double xPos, double yPos, double width, double height, double xOffset, double yOffset, double speed, int health, Assets assets, Game game) {
        super(xPos, yPos, width, height, xOffset, yOffset, speed, health, assets, game);
    }
    
    protected boolean isEated(){
        return game.jerry.getBiteBounds().contains(this.getCollisionBounds(0, 0)) && (game.jerry.currentAnimation == AssetsJerry.biteLeft || game.jerry.currentAnimation == AssetsJerry.biteRight);
    }
}
