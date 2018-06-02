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
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import slimeboi.Game;
import slimeboi.graphics.AssetsMikeleton;
import slimeboi.graphics.CustomAnimation;

/**
 *
 * @author Javier Pastor Pérez
 */
public class JackboneFive extends Shot{
    private double xIncrement;
    private double yIncrement = (Math.random() - 1) * 2;
    private final Image bone;
    private final ImageView imageRotation;
    private final SnapshotParameters params;

    private int rotation = 0;
    
    public JackboneFive(double xPos, double yPos, double xIncrement, CustomAnimation animation, Game game) {
        super(xPos, yPos, 11, 11, 26, 27, animation, game);
        this.xIncrement = xIncrement;
        
        imageRotation = new ImageView(animation.getFrame(0));

        params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        
        /*int randomJackbone = (int) (Math.random() * 5);
        for(int i = 0; i < randomJackbone ; i++){
            animation.nextFrame();
        }*/
        
        this.bone = animation.getFrame(0);
        
        
    }

    @Override
    protected void updateSpecificState() {
        
        new Timeline(new KeyFrame(Duration.millis(3000), ea -> {
            kill();
        })).play();
        
        
        if(hitsJerry()){
            game.jerry.hurt();
        }
        
        //game.getCanvas().getGraphicsContext2D().setFill(Paint.valueOf("black"));
        //game.getCanvas().getGraphicsContext2D().fillRect(getCollisionBounds(0, 0).getMinX() - game.getCamera().getXPos(), getCollisionBounds(0, 0).getMinY() - game.getCamera().getYPos(), getCollisionBounds(0, 0).getWidth(), getCollisionBounds(0, 0).getHeight());
        
        
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
    
    private boolean hitsJerry(){
        return game.jerry.getCollisionBounds(0, 0).intersects(this.getCollisionBounds(0, 0));
    }
    
    @Override
    public void updateState(){
        updateSpecificState();
    }
    
    public void setXIncrement(double increment){
        xIncrement = increment;
    }
    
    public void setYIncrement(double increment){
        yIncrement = increment;
    }
}
