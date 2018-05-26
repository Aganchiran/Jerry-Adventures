/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures.jerry.ammo;

import slimeboi.Game;
import slimeboi.graphics.AssetsBlancanubes;

/**
 *
 * @author Javier Pastor Pérez
 */
public class SieteRayitos extends Shot{

    public SieteRayitos(double xPos, double yPos, Game game) {
        super(xPos, yPos, 35, 106, 13, 5, AssetsBlancanubes.sieteRayitos, game);
        
    }

    @Override
    protected void updateSpecificState() {
        if(hitsJerry()){
            game.jerry.hurt();
        }
    }
    
    protected boolean hitsJerry(){
        return game.jerry.getCollisionBounds(0, 0).intersects(this.getCollisionBounds(0, 0));
    }
    
    public void kill(){
        game.getWorld().killEntity(this);
    }
}
