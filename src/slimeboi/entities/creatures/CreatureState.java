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
public abstract class CreatureState {
    protected Creature creature;
    
    public CreatureState(Creature creature){
        this.creature = creature;
    }
    
    
    
    public abstract void idle();
    public abstract void jump();
    public abstract void move();
    public abstract void die();
}
