/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures.jerry;

import javafx.scene.input.KeyCode;
import slimeboi.Game;
import static slimeboi.commands.DefaultControls.configuration;
import slimeboi.entities.creatures.Creature;
import slimeboi.graphics.AssetsJerry;
import slimeboi.graphics.AssetsViejo;
import slimeboi.input.KeyManager;

/**
 *
 * @author Javier Pastor Pérez
 */
public class Jerry extends Creature{
    
    public Jerry(double xPos, double yPos, double width, double height, double xOffset, double yOffset, Game game){
        super(xPos, yPos, width, height, xOffset, yOffset, new AssetsJerry(), game);
        
        currentAnimation = AssetsViejo.idleRight;
        state = STATE_RIGHT;
    }
    
    @Override
    public void updateState(){
        if(isOnAir){
            state.onAir();
        }else if(KeyManager.checkKey(KeyCode.SPACE.getName())){
            //yIncrement = -4;
            configuration.doAction(2); //2 es Espacio
        }else if(KeyManager.checkKey(KeyCode.RIGHT.getName())){
            /*state = STATE_RIGHT;
            state.move();*/
            configuration.doAction(0); // 0 es Derecha
        }else if(KeyManager.checkKey(KeyCode.LEFT.getName())){           
           /* state = STATE_LEFT;
            state.move();*/
            configuration.doAction(1); // 1 es Izquierda
        }else {
            state.idle();
        }
    }
    
    
} 
