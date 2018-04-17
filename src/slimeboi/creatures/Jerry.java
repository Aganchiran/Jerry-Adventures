/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.creatures;

import javafx.scene.canvas.GraphicsContext;
import slimeboi.graphics.CustomAnimation;

/**
 *
 * @author Javier Pastor Pérez
 */
public class Jerry extends Creature{
    
    private CustomAnimation idle = new CustomAnimation("slimeboi/resources/JerrySpriteSheet.png", 26, 0, 0, 64, 64);
    
    public Jerry(float xPos, float yPos){
        super(xPos, yPos);
        
    }
    
    public void render(GraphicsContext gc, int i){
        
        gc.drawImage(idle.sequence[i], xPos, yPos);
        
    }
    
}
