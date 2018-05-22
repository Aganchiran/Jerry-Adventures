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
 * @author Javier Pastor Pérez
 */
public class NoAmmo extends Ammo{
    
    public NoAmmo(Game game) {
        super(AssetsViejo.emptyAnimation,new ThunderShot( -200, -200, game) , game);
    }
    
    @Override
    public void fire(){};

}
