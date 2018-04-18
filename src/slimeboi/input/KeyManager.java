/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.input;

import java.util.HashMap;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Javier Pastor Pérez
 */
public class KeyManager {
    public static final int RIGHT = 0;
    public static final int LEFT = 1;
 
    private static final HashMap keyMap = new HashMap(110);
    
    public static boolean checkKey(String id){
        
        return (boolean) keyMap.getOrDefault(id, false);
    }
    
    public static void pressingKey(KeyEvent e){
        
        keyMap.put(e.getCode().getName(), true);
        
    }
    
    public static void releasingKey(KeyEvent e){
        
        keyMap.put(e.getCode().getName(), false);
    }
    
}
