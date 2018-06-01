/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures.jerry.ammo;

import slimeboi.Game;
import slimeboi.graphics.AssetsViejo;

/**
 *
 * @author Shion
 */
public class PincheShot extends Shot {
    
    public PincheShot(double xPos, double yPos, double xIncrement, Game game){
        super(xPos, yPos, 0, 0, 0, 0, AssetsViejo.emptyAnimation, game);
    
    }

    @Override
    protected void updateSpecificState() {
        
    }
    
    @Override
    public void updateState(){
        updateSpecificState();
    }
    
}
