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
    private static JerryCommand[] previousActions;
    private static boolean controlsDisabled = false;
    public static JerryCommand[] actions;
    
    public ControlLoader(){
        actions = new JerryCommand[7];
        previousActions = new JerryCommand[7];
        
        JerryCommand none = new NoAction();
        for(int i = 0; i<7; i++){
            actions[i] = none;
            previousActions[i] = none;
        } 
            
    }
    
    public static void setCommand(int slot, JerryCommand action){
        actions[slot] = action;
        previousActions[slot] = action;
    }
    
   
    
    public static void doAction(int slot){
        actions[slot].execute();
    }
    
    public static void disableControls(){
        
        if(!controlsDisabled){
            for(int i = 0; i<7; i++) {
                previousActions[i] = actions[i];
                actions[i] = new NoAction();
            }
            controlsDisabled = true;
        }
    }
    
    public static void enableControls(){
        //System.out.println(actions[0]);
        for(int i = 0; i<7; i++) {
            actions[i] = previousActions[i];
        }
        //System.out.println(actions[0]);
        controlsDisabled = false;
    }
    
    public static void printControls(){
        System.out.println("{" + actions[0].toString() + "," + actions[1].toString() + "," + actions[2].toString() + "," + actions[3].toString() + "," + actions[4].toString() + "," + actions[5].toString() + "}");
    }
    
}
