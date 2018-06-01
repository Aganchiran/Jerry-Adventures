/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures.jerry.ammo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import slimeboi.Game;
import slimeboi.entities.creatures.enemies.Blancanubes;
import slimeboi.graphics.AssetsBlancanubes;

/**
 *
 * @author Javier Pastor Pérez
 */
public class SieteRayitos extends Shot{
    private final Blancanubes blancanubes;
    public SieteRayitos(double xPos, double yPos, Blancanubes blancanubes, Game game) {
        super(xPos, yPos, 35, 106, 13, 5, AssetsBlancanubes.sieteRayitos, game);
        this.blancanubes = blancanubes;
    }

    @Override
    protected void updateSpecificState() {
        if(hitsJerry()){
            game.jerry.hurt();
        }
        
        if(game.getWorld().isAlive(this) && !blancanubes.isScreaming()){
            kill();
        }
    }
    
    private boolean hitsJerry(){
        return game.jerry.getCollisionBounds(0, 0).intersects(this.getCollisionBounds(0, 0));
    }
    
}
