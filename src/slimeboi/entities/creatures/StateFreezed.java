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
public class StateFreezed extends CreatureState{

    public StateFreezed(Creature creature) {
        super(creature);
    }

    @Override
    public void idle(){}

    @Override
    public void jump(){}

    @Override
    public void move(){}

    @Override
    public void die(){}
    
}
