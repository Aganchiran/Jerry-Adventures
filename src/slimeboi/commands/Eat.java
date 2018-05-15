/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.commands;

import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import slimeboi.entities.creatures.Creature;
import slimeboi.graphics.AssetsJerry;

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
        if (!creature.hasAmmo) {
            if (!creature.isFreezed()) {
                if (creature.facingRight()) {
                    creature.currentAnimation = ((AssetsJerry) creature.assets).biteRight;
                } else {
                    creature.currentAnimation = ((AssetsJerry) creature.assets).biteLeft;
                }

                creature.currentAnimation.setCurrentAnimationFrame(0);

                creature.state = creature.STATE_FREEZED;

                if (creature.notFreezedState == creature.STATE_LEFT) {
                    creature.notFreezedState = creature.STATE_LEFT_ON_AIR;
                } else if (creature.notFreezedState == creature.STATE_RIGHT) {
                    creature.notFreezedState = creature.STATE_RIGHT_ON_AIR;
                }

                ControlLoader.disableControls();
                creature.setYIncrement(-2.7);
                if (creature.facingRight()) {
                    creature.setXIncrement(1);
                } else {
                    creature.setXIncrement(-1);
                }
                
                
                
                Timer timer = new Timer();
                try {
                    TimerTask task = new TimerTask() {
                        @Override
                        public void run() {
                            while (creature.isOnAir());

                            creature.state = creature.notFreezedState;
                            ControlLoader.enableControls();
                        }
                    };

                    timer.schedule(task, 10);
                } finally {
                    timer.cancel();
                }
            }
        } else {
            creature.currentAnimation = ((AssetsJerry) creature.assets).endBiteLeft;

            creature.currentAnimation.setCurrentAnimationFrame(0);

            creature.state = creature.STATE_FREEZED;

            

            ControlLoader.disableControls();
            
            new Timeline(new KeyFrame(Duration.millis(3000), ae -> {
                creature.hasAmmo = false;
                creature.state = creature.notFreezedState;
                ControlLoader.enableControls();;
            })).play();
            
          
            //hacer cozas
       
        }
    }

}
