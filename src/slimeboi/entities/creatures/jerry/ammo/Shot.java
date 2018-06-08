/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures.jerry.ammo;

import slimeboi.Game;
import slimeboi.entities.Entity;
import slimeboi.graphics.CustomAnimation;

/**
 *
 * @author Javier Pastor Pérez
 */
public abstract class Shot extends Entity{
    protected CustomAnimation animation;
    public Shot(double xPos, double yPos, double width, double height, double xOffset, double yOffset, CustomAnimation animation, Game game) {
        super(xPos, yPos, width, height, xOffset, yOffset, game);
        this.animation = animation;
    }

    @Override
    public void updateState() {
        updateSpecificState();
        game.getCanvas().getGraphicsContext2D().drawImage(animation.nextFrame(), xPos - game.getCamera().getXPos(), yPos - game.getCamera().getYPos());
    }
    
    protected abstract void updateSpecificState();
    
}
