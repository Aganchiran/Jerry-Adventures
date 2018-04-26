/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.tiles;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import slimeboi.Game;
import slimeboi.entities.Entity;

/**
 *
 * @author Javier Pastor Pérez
 */
public abstract class Tile extends Entity{
    protected Image texture;
    private static final double DEFAULT_WIDTH = 32;
    private static final double DEFAULT_HEIGHT = 32;
    
    public Tile(double xPos, double yPos, Game game){
        super(xPos, yPos, DEFAULT_WIDTH, DEFAULT_HEIGHT, 0, 0, game);
        
    }
    public abstract boolean isSolid();
    

    @Override
    public void render(GraphicsContext gc){
        gc.drawImage(texture, xPos, yPos);
    }
}
