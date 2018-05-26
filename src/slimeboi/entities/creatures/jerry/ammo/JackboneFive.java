/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures.jerry.ammo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import slimeboi.Game;
import slimeboi.graphics.AssetsMikeleton;

/**
 *
 * @author Javier Pastor Pérez
 */
public class JackboneFive extends Shot{
    private final double xIncrement;
    private double yIncrement = (Math.random() - 1) * 2;
    private final Image bone;
    
    //private int rotationSpeed = (int)((Math.random()) * 10);
    private int rotation = 0;
    
    public JackboneFive(double xPos, double yPos, double xIncrement, Game game) {
        super(xPos, yPos, 11, 11, 26, 27, AssetsMikeleton.jackie, game);
        this.xIncrement = xIncrement;
        
        /*int randomJackbone = (int) (Math.random() * 5);
        for(int i = 0; i < randomJackbone ; i++){
            animation.nextFrame();
        }*/
        
        this.bone = animation.getFrame(0);
        
        new Timeline(new KeyFrame(Duration.millis(10000), ea -> {
            kill();
        })).play();
    }

    @Override
    protected void updateSpecificState() {
        if(hitsJerry()){
            game.jerry.hurt();
        }
        
        ImageView imageTest = new ImageView(AssetsMikeleton.jackieV2.getFrame(0));
        imageTest.setRotate(rotation = (rotation + 1) % 360);
        System.out.println(rotation);


        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);

        WritableImage rotatedImage = imageTest.snapshot(params, null);
        
        animation.setFrameInPositions(rotatedImage, new int[]{0});
        
        if(rotation % 90 < 45 ){
            xPos -=0.3;
            yPos -=0.3;
        }else{
            xPos +=0.3;
            yPos +=0.3;
        }
        yIncrement += 0.05;
        
        xPos += xIncrement;
        yPos += yIncrement;
    }
    
    private boolean hitsJerry(){
        return game.jerry.getCollisionBounds(0, 0).intersects(this.getCollisionBounds(0, 0));
    }
    
    
}
