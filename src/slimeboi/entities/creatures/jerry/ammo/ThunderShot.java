/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures.jerry.ammo;

import javafx.scene.paint.Paint;
import slimeboi.Game;
import slimeboi.graphics.AssetsViejo;

/**
 *
 * @author Javier Pastor Pérez
 */
public class ThunderShot extends Shot{
    
    public ThunderShot(double xPos, double yPos, Game game) {
        super(xPos, yPos, 95, 40, 5, 12, AssetsViejo.thunderShotR, game);
    }

    @Override
    protected void updateSpecificState() {
        //game.getCanvas().getGraphicsContext2D().setFill(Paint.valueOf("black"));
        //game.getCanvas().getGraphicsContext2D().fillRect(getCollisionBounds(0, 0).getMinX() - game.getCamera().getXPos(), getCollisionBounds(0, 0).getMinY() - game.getCamera().getYPos(), getCollisionBounds(0, 0).getWidth(), getCollisionBounds(0, 0).getHeight());
        if(game.jerry.facingRight()){
            animation = AssetsViejo.thunderShotR;
            xPos = game.jerry.getXPos() + 32;
        }else{
            animation = AssetsViejo.thunderShotL;
            xPos = game.jerry.getXPos() - 2 - this.getHitBox().getWidth();
        }
        
        yPos = game.jerry.getYPos();
        if(game.jerry.hasAmmo){
            game.jerry.currentAnimation.setCurrentAnimationFrame(1);
        }else{
            game.getWorld().killEntity(this);
        }
    }
    
    
}
