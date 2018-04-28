/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.tiles;

import slimeboi.graphics.AssetsViejo;

/**
 *
 * @author Javier Pastor Pérez
 */
public class SkyTile extends Tile{

    public SkyTile() {
        super.texture = AssetsViejo.Sky;
    }

    @Override
    public boolean isSolid() {
        return false;
    }
    
}
