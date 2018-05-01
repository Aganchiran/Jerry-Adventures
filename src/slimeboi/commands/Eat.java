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
public class Eat implements JerryCommand {
    Creature creature;
    
    public Eat(Creature creature){
        this.creature = creature;
    }
    
    @Override
    public void execute() {
        //por implementar
    }    
    
}
