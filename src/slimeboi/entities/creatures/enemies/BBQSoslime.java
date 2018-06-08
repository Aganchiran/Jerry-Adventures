/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures.enemies;

import slimeboi.Game;
import slimeboi.entities.creatures.ammo.ShuriAmmo;
import slimeboi.graphics.AssetsBBQ;

/**
 *
 * @author Salahodin
 */
public class BBQSoslime extends Enemy {
    
    private long count = 0;
    private long secondcount = 0;
    private boolean shuriken = false;
    
    public BBQSoslime(double xPos, double yPos, double width, double height, double xOffset, double yOffset, Game game){
        super(xPos, yPos, width, height, xOffset, yOffset, 0, 1, new AssetsBBQ(),new ShuriAmmo(game), game);
        
    }

    @Override
    public void updateCreatureStateSpecific(){
        if(isEated() && !shuriken){
            
            game.jerry.setAmmo(ammo);
            game.jerry.hasAmmo = true;
            kill();
        }
        
        if(health == 0){
            kill();
        }
        
        if(!game.jerry.isBiting() && hitsJerry()){
            game.jerry.hurt();
        }
        
        if(game.jerry.getXPos() > this.getXPos() && !shuriken){
            state = STATE_RIGHT;
        } 
        else if(game.jerry.getXPos() <= this.getXPos() && !shuriken){
             state = STATE_LEFT;
        }
           
        
        if(!shuriken){
            if(count!=84)
                count++;
            
            state.idle(); 
            if(count == 84) {
                secondcount++;
                if(secondcount == 85){
                    shuriken = true;
                    secondcount = 0;
                }
       
            }
        } else {
            state.move();
            count--;
             
            if(count == 0){
             shuriken = false;
             
            }
        }
        
             
           
        
        
    }
    
    
}
