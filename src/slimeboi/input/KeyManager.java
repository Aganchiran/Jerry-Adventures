/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.input;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Javier Pastor Pérez
 */
public class KeyManager {
    private static boolean key;
    
    public static boolean checkKey(){
        
        return key;
    }
    
    public static void pressingKey(KeyEvent e){
        key = e.getCode() == KeyCode.D;
        System.out.println(key);
    }
    
    public static void releasingKey(KeyEvent e){
        key = !(e.getCode() == KeyCode.D);
        System.out.println(key);
    }
    
}
