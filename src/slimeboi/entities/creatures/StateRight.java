/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures;

/**
 *
 * @author Javier Pastor Pérez
 */
public class StateRight extends CreatureState{

    public StateRight(Creature creature) {
        super(creature);
    }
    

    @Override
    public void idle() {
        creature.assets.idleRight.setCurrentAnimationFrame(creature.currentAnimation.getCurrentAnimationFrame());
        creature.currentAnimation = creature.assets.idleRight;
        creature.xIncrement = 0;
    }

    @Override
    public void onAir() {
        creature.currentAnimation = creature.assets.onAirRight;
        
        
    }

    @Override
    public void move() {
        creature.assets.right.setCurrentAnimationFrame(creature.currentAnimation.getCurrentAnimationFrame());
        creature.currentAnimation = creature.assets.right;

        creature.xIncrement = 1;
    }

    @Override
    public void die() {

    }
    
}
