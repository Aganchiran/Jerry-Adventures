/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures.enemies;

import slimeboi.Game;
import slimeboi.entities.creatures.jerry.ammo.NoAmmo;
import slimeboi.graphics.AssetsBBQ;

/**
 *
 * @author Salahodin
 */
public class BBQSoslime extends Enemy {
    
    
    
    public BBQSoslime(double xPos, double yPos, double width, double height, double xOffset, double yOffset, Game game){
        super(xPos, yPos, width, height, xOffset, yOffset, 0, 1, new AssetsBBQ(),new NoAmmo(game), game);
        
    }

    @Override
    public void updateCreatureStateSpecific(){
        if(isEated()){
            kill();
            game.jerry.setAmmo(ammo);
            game.jerry.hasAmmo = true;
        }
        
        if(isHurt()){
            kill();
        }
        
        if(!game.jerry.isBiting() && hitsJerry()){
            game.jerry.hurt();
        }
        
        if(game.jerry.getXPos() > this.getXPos())
            state = STATE_RIGHT;
        else if(game.jerry.getXPos() <= this.getXPos())
            state = STATE_LEFT;
           
        
        state.move();
    }
    
    
}
