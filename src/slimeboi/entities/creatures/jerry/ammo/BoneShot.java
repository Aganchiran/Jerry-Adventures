/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures.jerry.ammo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.SnapshotParameters;
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
public class BoneShot extends Shot{
    private final double xIncrement = 1;
    private double yIncrement = -2;
    
    private final ImageView imageRotation;
    private final SnapshotParameters params;
    
    private int rotation = 0;
    
    public BoneShot(double xPos, double yPos, Game game) {
        super(xPos, yPos, 11, 11, 26, 27, AssetsMikeleton.jackbone, game);
        
        
        imageRotation = new ImageView(AssetsMikeleton.jackbone.getFrame(0));

        params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        
        new Timeline(new KeyFrame(Duration.millis(10000), ea -> {
            kill();
        })).play();
    }

    @Override
    protected void updateSpecificState() {
        imageRotation.setRotate(rotation = (rotation + 5) % 360);
        double sin = Math.sin(Math.toRadians(rotation));
        double cos = Math.cos(Math.toRadians(rotation));
        double correction = Math.abs(sin) * Math.abs(cos) * 27;
        WritableImage rotatedImage = imageRotation.snapshot(params, null);
        
        
        game.getCanvas().getGraphicsContext2D().drawImage(rotatedImage, xPos - game.getCamera().getXPos() - correction, yPos - game.getCamera().getYPos() - correction);
        
        yIncrement += 0.05;
        
        xPos += xIncrement;
        yPos += yIncrement;
    }
    
    @Override
    public void updateState(){
        updateSpecificState();
    }
}
