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
public class StateRightOnAir extends CreatureState{

    public StateRightOnAir(Creature creature) {
        super(creature);
    }

    @Override
    public void idle() {
        creature.currentAnimation = creature.assets.onAirRight;
        creature.xIncrement = 0;
    }

    @Override
    public void jump() {}

    @Override
    public void move() {
        creature.currentAnimation = creature.assets.onAirRight;

        creature.xIncrement = 1;
    }

    @Override
    public void die() {

    }
    
}
