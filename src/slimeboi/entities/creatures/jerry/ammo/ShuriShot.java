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
import slimeboi.graphics.AssetsViejo;

/**
 *
 * @author Javier Pastor Pérez
 */
public class ShuriShot extends Shot{
    public final double xIncrement;
    public boolean shuriR = false;
    public boolean shuriL = false;
    
    private final Image shuri;
    private final ImageView imageRotation;
    private final SnapshotParameters params;
    
    private int rotation = 0;
    
    public ShuriShot(double xPos, double yPos, double xIncrement, Game game) {
        super(xPos, yPos, 32, 32, 8, 8, AssetsViejo.shuriShotthree, game);
        this.xIncrement = xIncrement;
        
        imageRotation = new ImageView(AssetsViejo.shuriShotthree.getFrame(0));

        params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        
        this.shuri = animation.getFrame(0);
    }

    @Override
    protected void updateSpecificState() {
       game.getCanvas().getGraphicsContext2D().setFill(Paint.valueOf("black"));
       game.getCanvas().getGraphicsContext2D().fillRect(getCollisionBounds(0, 0).getMinX() - game.getCamera().getXPos(), getCollisionBounds(0, 0).getMinY() - game.getCamera().getYPos(), getCollisionBounds(0, 0).getWidth(), getCollisionBounds(0, 0).getHeight());
        
        
        if(game.jerry.facingRight() && !shuriR && !shuriL){
            yPos = game.jerry.getYPos()  ;
            xPos = 10 + game.jerry.getXPos();  
           shuriR = true;  
        }else if(!game.jerry.facingRight() && !shuriR && !shuriL){
            yPos = game.jerry.getYPos();
            xPos =  game.jerry.getXPos()  -10;
            shuriL = true;
        }
        
        imageRotation.setRotate(rotation = (rotation + 5) % 360);
        double sin = Math.sin(Math.toRadians(rotation));
        double cos = Math.cos(Math.toRadians(rotation));
        double correction = Math.abs(sin) * Math.abs(cos) * 27;
        WritableImage rotatedImage = imageRotation.snapshot(params, null);
        
        
        game.getCanvas().getGraphicsContext2D().drawImage(rotatedImage, xPos - game.getCamera().getXPos() - correction, yPos - game.getCamera().getYPos());
        
        
        if(shuriR) xPos += xIncrement;
        if(shuriL) xPos += - xIncrement;
       
       new Timeline(new KeyFrame(Duration.millis(2000), ea -> { 
           game.getWorld().killEntity(this);
           shuriR = false;
           shuriL = false;
       })).play();
        
    }
    
    
}
