/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures.jerry.ammo;

import javafx.scene.SnapshotParameters;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import slimeboi.Game;
import slimeboi.graphics.AssetsMikeleton;

/**
 *
 * @author Javier Pastor Pérez
 */
public class JackboneFive extends Shot{
    private final double xIncrement;
    private double yIncrement = (Math.random() - 1) * 2;
    
    public JackboneFive(double xPos, double yPos, double xIncrement, Game game) {
        super(xPos, yPos, 11, 11, 26, 27, AssetsMikeleton.jackboneFive[4], game);
        this.xIncrement = xIncrement;
    }

    @Override
    protected void updateSpecificState() {
        if(hitsJerry()){
            game.jerry.hurt();
        }
        /*ImageView iv = new ImageView(animation.nextFrame());
        iv.setRotate(1);
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        
        //Image rotatedImage = iv.snapshot(params, null);
        int[] pos = {0};
        animation.setFrameInPositions(iv.snapshot(params, null), pos);*/
        
        yIncrement += 0.05;
        
        xPos += xIncrement;
        yPos += yIncrement;
    }
    
    private boolean hitsJerry(){
        return game.jerry.getCollisionBounds(0, 0).intersects(this.getCollisionBounds(0, 0));
    }
    
}
