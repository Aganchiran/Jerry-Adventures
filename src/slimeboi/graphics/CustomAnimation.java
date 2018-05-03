/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.graphics;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

/**
 *
 * @author sabehas
 */
public class CustomAnimation {
    
    private final WritableImage[] sequence;
    private final int frameRate;
    private final int numFrames;
    private final boolean loop;
    private int frameAdjustement;
    private int currentAnimationFrame = 0;

    
    public CustomAnimation(String url, int numFrames, int x, int y, int width, int height, int frameRate, boolean loop){
        
        sequence = new WritableImage[numFrames];
        this.frameRate = frameRate;
        this.numFrames = numFrames;
        this.loop = loop;
        frameAdjustement = 60/frameRate - 1;
        
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
            frameAdjustement = 60/frameRate - 1;
            if(!loop && currentAnimationFrame == numFrames - 1) currentAnimationFrame = numFrames - 1;
            else currentAnimationFrame = (currentAnimationFrame + 1) % numFrames;
        }
        
        return sequence[currentAnimationFrame];
    }
    
    public int getCurrentAnimationFrame(){
        return currentAnimationFrame;
    }
    public void setCurrentAnimationFrame(int x){
        currentAnimationFrame = x;
    }
    
    public int getDurationInMilis(){
        System.out.println(16 * ((numFrames - 1) * 60/frameRate));
        return 16 * ((numFrames - 1) * 60/frameRate);
    }
    
}
