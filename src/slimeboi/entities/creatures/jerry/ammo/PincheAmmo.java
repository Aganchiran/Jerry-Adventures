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
public class PincheAmmo extends Ammo {
    
    public PincheAmmo(Game game){
        super(AssetsViejo.emptyAnimation, new PincheShot(0,0,0,game), game);
        
    }
    
    @Override
    public void fire(){
    
    };
    
}
