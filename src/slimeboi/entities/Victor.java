/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities;

import slimeboi.Game;

/**
 *
 * @author Javier Pastor Pérez
 */
public class Victor extends Entity{

    public Victor(double xPos, double yPos, double width, double height, Game game) {
        super(xPos, yPos, width, height, 0, 0, game);
    }

    @Override
    public void updateState() {
        if(game.jerry.getCollisionBounds(0, 0).intersects(getCollisionBounds(0, 0))){
            game.nextWorld();
        }
    }
    
}
