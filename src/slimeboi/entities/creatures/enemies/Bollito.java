/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures.enemies;

import slimeboi.Game;
import slimeboi.entities.creatures.jerry.ammo.NoAmmo;
import slimeboi.graphics.AssetsBollito;

/**
 *
 * @author Javier Pastor Pérez
 */
public class Bollito extends Enemy{

    public Bollito(double xPos, double yPos, Game game) {
        super(xPos, yPos, 237, 145, 142, 55, 0, 10, new AssetsBollito(), new NoAmmo(game), game);
    }

    @Override
    public void updateCreatureStateSpecific() {
    }
    
}
