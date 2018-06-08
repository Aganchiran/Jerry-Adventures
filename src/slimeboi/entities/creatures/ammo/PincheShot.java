/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures.ammo;

import java.util.ArrayList;
import slimeboi.Game;
import slimeboi.entities.Entity;
import slimeboi.graphics.AssetsViejo;

/**
 *
 * @author Shion
 */
public class PincheShot extends Shot {
    private double xIncrement;
    private ArrayList<Entity> notHurtEntities = new ArrayList();
    
    public PincheShot(double xPos, double yPos, double xIncrement, Game game){
        super(xPos, yPos, 40, 18, 6, 22, AssetsViejo.pincheShotR, game);
        this.xIncrement = xIncrement;
        
        notHurtEntities.add(game.jerry);
    }

    @Override
    protected void updateSpecificState() {
        if(xIncrement < 0){
            animation = AssetsViejo.pincheShotL;
        }else{
            animation = AssetsViejo.pincheShotR;
        }
        
        xPos += xIncrement;
        
        Entity entityAuxiliar;
        for(int i = 0 ; i < game.getWorld().getEntities().size() ; i++){
            entityAuxiliar = game.getWorld().getEntities().get(i);
            if(!notHurtEntities.contains(entityAuxiliar) && entityAuxiliar != this && this.getCollisionBounds(0, 0).intersects(entityAuxiliar.getCollisionBounds(0, 0))){
                entityAuxiliar.hurt();
                notHurtEntities.add(entityAuxiliar);
            }
        }
    }
    
    public void setXIncrement(double increment){
        xIncrement = increment;
    }
    
    public void resetHurteableEntities(){
        notHurtEntities.removeAll(notHurtEntities);
        notHurtEntities.add(game.jerry);
    }
    
}
