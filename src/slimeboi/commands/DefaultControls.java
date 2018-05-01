/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.commands;

import slimeboi.Game;
import slimeboi.entities.creatures.jerry.Jerry;


/**
 *
 * @author Salahodin
 */
public class DefaultControls {
    public static ControlLoader configuration;
    
    
    public static void LoadControlsA(Game game){
        configuration = new ControlLoader();
        
        Jerry jerry;
        jerry = game.jerry;
        
        RightMovement RMaction = new RightMovement(jerry);
        configuration.setCommand(0, RMaction);
        
        LeftMovement LMaction = new LeftMovement(jerry);
        configuration.setCommand(1, LMaction);
        
        Jump Jaction = new Jump(jerry);
        configuration.setCommand(2, Jaction);
        
        Eat Eaction = new Eat(jerry);
        configuration.setCommand(3, Eaction);
    }
    
    public static void LoadControlsB(Game game){
        configuration = new ControlLoader();
        
        Jerry jerry;
        jerry = game.jerry;
        
        RightMovement RMaction = new RightMovement(jerry);
        configuration.setCommand(0, RMaction);
        
        LeftMovement LMaction = new LeftMovement(jerry);
        configuration.setCommand(1, LMaction);
        
        Eat Eaction = new Eat(jerry);
        configuration.setCommand(2, Eaction);
        
        Jump Jaction = new Jump(jerry);
        configuration.setCommand(3, Jaction);
    }
    
}
