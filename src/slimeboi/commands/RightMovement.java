/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.commands;

import slimeboi.entities.creatures.Creature;

/**
 *
 * @author Salahodin
 */
public class RightMovement  implements JerryCommand {

    Creature creature;
    
    public RightMovement(Creature creature){
        this.creature = creature;
    }
    
    @Override
    public void execute() {
        if(!creature.isFreezed()){
            if(creature.isOnAir()) {
                creature.state = creature.STATE_RIGHT_ON_AIR;
                creature.notFreezedState = creature.STATE_RIGHT_ON_AIR;
            }else{
                creature.state = creature.STATE_RIGHT;
                creature.notFreezedState = creature.STATE_RIGHT;
            }
        }
        creature.state.move();

    }
    
}
