/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.graphics;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

/**
 *
 * @author sabehas
 */
public class CustomAnimation {
    
    private WritableImage[] sequence;
    private int frameRate;
    private int numFrames;
    private int frameAdjustement;
    private int currentAnimationFrame = 0;
    
    public CustomAnimation(String url, int numFrames, int x, int y, int width, int height, int frameRate){
        
        sequence = new WritableImage[numFrames];
        this.frameRate = frameRate;
        this.numFrames = numFrames;
        frameAdjustement = 60/frameRate;
        
        Image SpriteSheet = new Image(url);//"slimeboi/resources/JerrySpriteSheet.png"
        PixelReader reader = SpriteSheet.getPixelReader();
        
        for(int i = x ; i < numFrames + x ; i++){
            WritableImage frame = new WritableImage(reader, ((i % 10) * width), (y * height) + ((i / 10) * height), width, height);
            sequence[i - x] = frame;
        }
        
    }
    
    public Image nextFrame(){
        
        if(frameAdjustement != 0){
            frameAdjustement--;
        }else{
            frameAdjustement = 60/frameRate;
            currentAnimationFrame = (currentAnimationFrame + 1) % numFrames;
        }
        
        return sequence[currentAnimationFrame];
    }
    
}
