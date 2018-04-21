/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.tiles;

import javafx.scene.image.Image;

/**
 *
 * @author Javier Pastor Pérez
 */
public class EarthTile extends Tile{

    public EarthTile(double xPos, double yPos, Image texture) {
        super(xPos, yPos);
        super.texture = texture;
    }

    @Override
    public boolean isSolid() {
        return true;
    }

}
