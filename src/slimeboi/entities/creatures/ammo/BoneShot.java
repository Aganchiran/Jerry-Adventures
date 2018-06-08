/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures.ammo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import slimeboi.Game;
import slimeboi.entities.Entity;
import slimeboi.graphics.AssetsMikeleton;
import slimeboi.graphics.CustomAnimation;

/**
 *
 * @author Javier Pastor Pérez
 */
public class BoneShot extends Shot{
    private double xIncrement;
    private double yIncrement = -2;
    
    private final ImageView imageRotation;
    private final SnapshotParameters params;
    
    private int rotation = 0;
    
    public BoneShot(double xPos, double yPos, double xIncrement, CustomAnimation bone, Game game) {
        super(xPos, yPos, 11, 11, 26, 27, bone, game);
        this.xIncrement = xIncrement;
        
        imageRotation = new ImageView(bone.getFrame(0));

        params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        
        
    }

    @Override
    protected void updateSpecificState() {
        new Timeline(new KeyFrame(Duration.millis(10000), ea -> {
            kill();
        })).play();
        
        
        imageRotation.setRotate(rotation = (rotation + 5) % 360);
        double sin = Math.sin(Math.toRadians(rotation));
        double cos = Math.cos(Math.toRadians(rotation));
        double correction = Math.abs(sin) * Math.abs(cos) * 27;
        WritableImage rotatedImage = imageRotation.snapshot(params, null);
        
        
        game.getCanvas().getGraphicsContext2D().drawImage(rotatedImage, xPos - game.getCamera().getXPos() - correction, yPos - game.getCamera().getYPos() - correction);
        
        yIncrement += 0.05;
        
        xPos += xIncrement;
        yPos += yIncrement;
        
        Entity entityAuxiliar;
        for(int i = 0 ; i < game.getWorld().getEntities().size() ; i++){
            entityAuxiliar = game.getWorld().getEntities().get(i);
            if(entityAuxiliar != game.jerry && entityAuxiliar != this && this.getCollisionBounds(0, 0).intersects(entityAuxiliar.getCollisionBounds(0, 0))){
                entityAuxiliar.kill();
            }
        }
    }
    
    @Override
    public void updateState(){
        updateSpecificState();
    }
    
    public void setIncrement(double increment){
        xIncrement = increment;
    }
}
