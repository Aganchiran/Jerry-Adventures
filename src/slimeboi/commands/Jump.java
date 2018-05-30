/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.commands;

import slimeboi.entities.creatures.Creature;
import slimeboi.entities.creatures.jerry.Jerry;

/**
 *
 * @author Salahodin
 */
public class Jump implements JerryCommand {

    Creature creature;

    public Jump(Creature creature) {
        this.creature = creature;
    }

    @Override
    public void execute() {
        if (creature.hasAmmo) {
            creature.jumpForce = (creature.DEFAULT_JUMP_FORCE * 3)/ 4;
        } else {
            creature.jumpForce = creature.DEFAULT_JUMP_FORCE;
        }
        creature.state.jump();
        if (!creature.isFreezed()) {
            if (creature.state == creature.STATE_LEFT) {
                creature.state = creature.STATE_LEFT_ON_AIR;
                creature.notFreezedState = creature.STATE_LEFT_ON_AIR;
            } else if (creature.state == creature.STATE_RIGHT) {
                creature.state = creature.STATE_RIGHT_ON_AIR;
                creature.notFreezedState = creature.STATE_RIGHT_ON_AIR;
            }
        }

    }
}
