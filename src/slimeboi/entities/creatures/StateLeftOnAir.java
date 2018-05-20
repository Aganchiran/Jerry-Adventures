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
public class StateLeftOnAir extends CreatureState{

    public StateLeftOnAir(Creature creature) {
        super(creature);
    }

    @Override
    public void idle() {
        creature.currentAnimation = creature.assets.onAirLeft;
        creature.xIncrement = 0;
    }

    @Override
    public void jump() {}

    @Override
    public void move() {
        creature.currentAnimation = creature.assets.onAirLeft;

        creature.xIncrement = -creature.speed;
    }

    @Override
    public void die() {

    }
    
}
