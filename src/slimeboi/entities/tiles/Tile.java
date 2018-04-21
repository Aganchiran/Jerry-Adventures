/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.tiles;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import slimeboi.entities.Entity;

/**
 *
 * @author Javier Pastor Pérez
 */
public abstract class Tile extends Entity{
    protected Image texture;
    private static final double DEFAULT_SIZE = 64;
    
    public Tile(double xPos, double yPos){
        super(xPos, yPos, DEFAULT_SIZE, DEFAULT_SIZE);
        
    }
    public abstract boolean isSolid();
    

    public void render(GraphicsContext gc){
        gc.drawImage(texture, xPos, yPos);
    }
}
