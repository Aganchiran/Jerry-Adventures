/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.worlds;

import slimeboi.entities.tiles.EarthUpCenter;
import slimeboi.entities.tiles.SkyTile;

/**
 *
 * @author Javier Pastor Pérez
 */
public class Leaflands extends World{
    
    public Leaflands(String music, String mapURL, int width, int height) {
        super(music, mapURL, width, height);
        tileSet.add(new SkyTile());
        tileSet.add(new EarthUpCenter());
    }
    
}
