/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures.enemies;

import slimeboi.Game;
import slimeboi.entities.creatures.jerry.ammo.NoAmmo;
import slimeboi.entities.creatures.jerry.ammo.PincheAmmo;
import slimeboi.graphics.AssetsPinchita;

/**
 *
 * @author Javier Pastor Pérez
 */
public class Pinchita extends Enemy{
    private boolean colgadita = true;
    
    public Pinchita(double xPos, double yPos, Game game) {
        super(xPos, yPos, 18, 30, 24, 17, 0, 1, new AssetsPinchita(), new PincheAmmo(game), game);
    }

    @Override
    public void updateCreatureStateSpecific() {
        if(colgadita){
            currentAnimation = AssetsPinchita.pinchitaColgadita;
            if(game.jerry.getXPos() == xPos){
                colgadita = false;
                yPos = yPos + 3;
            }
        }else if(isOnAir()){
            currentAnimation = assets.onAirRight;
        }else{
            currentAnimation = assets.idleRight;
        }
        
        if(isEated()){
            
            game.jerry.setAmmo(ammo);
            game.jerry.hasAmmo = true;
            kill();
        }
        
        if(health == 0){
            kill();
        }
        
        if(!game.jerry.isBiting() && hitsJerry()){
            game.jerry.hurt();
        }
        
    }
    
}
