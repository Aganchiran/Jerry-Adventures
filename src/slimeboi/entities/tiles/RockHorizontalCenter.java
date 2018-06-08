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
public class RockHorizontalCenter extends Tile{
    
    public RockHorizontalCenter() {
        super.texture = AssetsViejo.RockHorizontalCenter;
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
