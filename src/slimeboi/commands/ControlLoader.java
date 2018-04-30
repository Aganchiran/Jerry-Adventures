/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.commands;

/**
 *
 * @author Salahodin
 */
public class ControlLoader {
    public static JerryCommand[] actions;
    
    public ControlLoader(){
        actions = new JerryCommand[7];
        
        JerryCommand none = new NoAction();
        for(int i = 0; i<7; i++) actions[i] = none;
            
    }
    
    public static void setCommand(int slot, JerryCommand action){
        actions[slot] = action;
    }
    
   
    
    public static void doAction(int slot){
        actions[slot].execute();
    }
    
}
