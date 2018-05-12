/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures.enemies;

import slimeboi.Game;
import slimeboi.entities.creatures.jerry.ammo.ThunderAmmo;
import slimeboi.graphics.AssetsBlancanubes;

/**
 *
 * @author Javier Pastor Pérez
 */
public class Blancanubes extends Enemy{
    
    private long count = 0;

    public Blancanubes(double xPos, double yPos, double width, double height, double xOffset, double yOffset, Game game) {
        super(xPos, yPos, width, height, xOffset, yOffset, 0.5, 1, new AssetsBlancanubes(),new ThunderAmmo(game), game);
    }

    @Override
    public void updateState() {

        if(isEated()){
            game.jerry.setAmmo(ammo);
            game.getWorld().killCreature(this);
        }
        
        if(!game.jerry.isBiting() && hitsJerry()){
            game.jerry.hurt();
        }
        
        if(state == STATE_RIGHT){
            count++;
            if(count == 200) state = STATE_LEFT;
        }else{
            count--;
            if(count == 0) state = STATE_RIGHT;
        }
        state.move();
    }
    
    @Override
    public boolean colidesY(){
        return true;
    }

}
