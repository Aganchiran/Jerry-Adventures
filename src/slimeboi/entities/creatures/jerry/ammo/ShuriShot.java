/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures.jerry.ammo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import slimeboi.Game;
import slimeboi.graphics.AssetsViejo;

/**
 *
 * @author Javier Pastor Pérez
 */
public class ShuriShot extends Shot{
    public final double xIncrement;
    
    public ShuriShot(double xPos, double yPos, double xIncrement, Game game) {
        super(xPos, yPos, 64, 64, 0, 0, AssetsViejo.shuriShotthree, game);
        this.xIncrement = xIncrement;
    }

    @Override
    protected void updateSpecificState() {
        game.getCanvas().getGraphicsContext2D().setFill(Paint.valueOf("black"));
        game.getCanvas().getGraphicsContext2D().fillRect(getCollisionBounds(0, 0).getMinX() - game.getCamera().getXPos(), getCollisionBounds(0, 0).getMinY() - game.getCamera().getYPos(), getCollisionBounds(0, 0).getWidth(), getCollisionBounds(0, 0).getHeight());
        
        animation = AssetsViejo.shuriShotto;
        if(game.jerry.facingRight()){
           
            xPos += xIncrement;
        }else{
            
            xPos += - xIncrement;
        }
        
        yPos = game.jerry.getYPos();
       new Timeline(new KeyFrame(Duration.millis(2000), ea -> { 
           game.getWorld().killEntity(this);
       })).play();
        
    }
    
    
}
