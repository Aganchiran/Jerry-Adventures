/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.tiles;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 *
 * @author Javier Pastor Pérez
 */
public abstract class Tile{
    protected Image texture;
    public static final double DEFAULT_WIDTH = 32;
    public static final double DEFAULT_HEIGHT = 32;
    
    
    public abstract boolean isSolid();

    public void render(GraphicsContext gc, double xPos, double yPos){
        gc.drawImage(texture, xPos, yPos);
    }
}
