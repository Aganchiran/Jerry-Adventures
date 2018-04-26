/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.tiles;

import javafx.scene.image.Image;
import slimeboi.Game;

/**
 *
 * @author Javier Pastor Pérez
 */
public class SkyTile extends Tile{

    public SkyTile(double xPos, double yPos, Image texture, Game game) {
        super(xPos, yPos, game);
        super.texture = texture;
    }

    @Override
    public boolean isSolid() {
        return false;
    }
    
}
