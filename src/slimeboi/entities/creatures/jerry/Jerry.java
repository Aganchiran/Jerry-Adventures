/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures.jerry;

import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.input.KeyCode;
import slimeboi.Game;
import slimeboi.commands.ControlLoader;
import static slimeboi.commands.DefaultControls.configuration;
import slimeboi.entities.creatures.Creature;
import slimeboi.graphics.AssetsJerry;
import slimeboi.input.KeyManager;

/**
 *
 * @author Javier Pastor Pérez
 */
public class Jerry extends Creature{
    
    private boolean lastStateOnAir = true;
    private double lastYIncrement = 0;
    
    public Jerry(double xPos, double yPos, double width, double height, double xOffset, double yOffset, Game game){
        super(xPos, yPos, width, height, xOffset, yOffset, new AssetsJerry(), game);
        
        currentAnimation = assets.idleRight;
        state = STATE_RIGHT;
        notFreezedState = STATE_RIGHT;
    }
    
    @Override
    public void updateState(){
        if(lastYIncrement > 2.5 && lastStateOnAir && !isOnAir()) land();
        
        if(KeyManager.checkKey(KeyCode.SPACE.getName())){

            configuration.doAction(2); //2 es Espacio
        }
        if(KeyManager.checkKey(KeyCode.Z.getName())){
            
            configuration.doAction(3); //3 es Z (o la que acabe siendo)
        }else if(KeyManager.checkKey(KeyCode.RIGHT.getName())){

            configuration.doAction(0); // 0 es Derecha
        }else if(KeyManager.checkKey(KeyCode.LEFT.getName())){           

            configuration.doAction(1); // 1 es Izquierda
        }else {
            state.idle();
        }
        
        lastStateOnAir = isOnAir();
        lastYIncrement = yIncrement;
    }
    
    private void land(){
        
        if(state == STATE_LEFT) currentAnimation = ((AssetsJerry) assets).endJumpLeft;
        else currentAnimation = ((AssetsJerry) assets).endJumpRight;
        
        //currentAnimation.setCurrentAnimationFrame(0);
        

        state = STATE_FREEZED;
        ControlLoader.unableControls();
        
        Timer timer = new Timer();
        
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                currentAnimation.setCurrentAnimationFrame(0);
                state = notFreezedState;
                ControlLoader.enableControls();
                timer.cancel();
            }
        };
        
        timer.schedule(task, 380);
    }
} 
