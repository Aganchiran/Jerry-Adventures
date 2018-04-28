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
public class StateLeft extends CreatureState{

    public StateLeft(Creature creature) {
        super(creature);
    }

    @Override
    public void idle() {
        creature.assets.idleLeft.setCurrentAnimationFrame(creature.currentAnimation.getCurrentAnimationFrame());
        creature.currentAnimation = creature.assets.idleLeft;
        creature.xIncrement = 0;
    }

    @Override
    public void onAir() {
        creature.currentAnimation = creature.assets.onAirLeft;
    }

    @Override
    public void move() {
        creature.assets.left.setCurrentAnimationFrame(creature.currentAnimation.getCurrentAnimationFrame());
        creature.currentAnimation = creature.assets.left;

        creature.xIncrement = -1;
    }

    @Override
    public void die() {

    }
    
}
