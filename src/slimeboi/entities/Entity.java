/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities;

import javafx.geometry.BoundingBox;
import javafx.scene.canvas.GraphicsContext;
import slimeboi.Game;

/**
 *
 * @author Javier Pastor Pérez
 */
public abstract class Entity {


    protected BoundingBox hitBox;
    protected Game game;
    
    
    public Entity(double width, double height, double xOffset, double yOffset, Game game){

        this.hitBox = new BoundingBox(xOffset, yOffset, width, height);
        this.game = game;
    }
    
    public abstract void render(GraphicsContext gc);
    
}
