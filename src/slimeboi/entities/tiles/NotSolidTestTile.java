/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.tiles;

/**
 *
 * @author Javier Pastor Pérez
 */
public class NotSolidTestTile extends Tile{

    @Override
    public boolean isSolid() {
        return false;
    }
    
}
