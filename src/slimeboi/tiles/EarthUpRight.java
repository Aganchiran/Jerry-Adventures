/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.tiles;

import slimeboi.graphics.AssetsViejo;

/**
 *
 * @author Javier Pastor Pérez
 */
public class EarthUpRight extends Tile{
    
    public EarthUpRight() {
        super.texture = AssetsViejo.EarthUpRight;
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
