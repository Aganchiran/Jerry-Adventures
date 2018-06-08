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
import slimeboi.entities.creatures.jerry.Jerry;
import slimeboi.entities.creatures.ammo.NoAmmo;
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
                ((Jerry)creature).biting = true;
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
                
                /*
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

                    timer.schedule(task, 1);
                } finally {
                    timer.cancel();
                }*/
                
            }
        } else {
            if(!creature.isFreezed() && !creature.isOnAir()){
                if (creature.facingRight()) {
                    creature.currentAnimation = ((AssetsJerry) creature.assets).spitRight;
                } else {
                    creature.currentAnimation = ((AssetsJerry) creature.assets).spitLeft;
                }

                creature.currentAnimation.setCurrentAnimationFrame(0);

                creature.state = creature.STATE_FREEZED;

               



                ControlLoader.disableControls();
                creature.setXIncrement(0);
                new Timeline(new KeyFrame(Duration.millis(75), ea -> {
                    ((Jerry) creature).getAmmo().fire();
                })).play();
                
                


                //hacer cozas
            }
        }
    }

}
