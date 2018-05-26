/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.graphics;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

/**
 *
 * @author sabehas
 */
public class CustomAnimation {
    
    //private final WritableImage[] sequence;
    private final ArrayList<Image> sequence;
    private final int frameRate;
    private int numFrames;
    private final boolean loop;
    private int frameAdjustement;
    private int currentAnimationFrame = 0;

    
    public CustomAnimation(String url, int numFrames, int x, int y, int width, int height, int frameRate, boolean loop){
        
        //sequence = new WritableImage[numFrames];
        sequence = new ArrayList<>();
        this.frameRate = frameRate;
        this.numFrames = numFrames;
        this.loop = loop;
        frameAdjustement = 60/frameRate - 1;
        
        Image SpriteSheet = new Image(url);//"slimeboi/resources/JerrySpriteSheet.png"
        PixelReader reader = SpriteSheet.getPixelReader();
        
        int imageWidth = ((int) SpriteSheet.getWidth() / width);

        for(int i = x ; i < numFrames + x ; i++){
            WritableImage frame = new WritableImage(reader, ((i % imageWidth) * width), (y * height) + ((i / imageWidth) * height), width, height);
            //sequence[i - x] = frame;
            sequence.add(frame);
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
        
        //return sequence[currentAnimationFrame];
        return sequence.get(currentAnimationFrame);
    }
    
    public int getCurrentAnimationFrame(){
        return currentAnimationFrame;
    }
    public void setCurrentAnimationFrame(int x){
        currentAnimationFrame = x;
    }
    
    public int getDurationInMilis(){
        return 16 * ((numFrames - 1) * 60/frameRate);
    }
    
    public void setFrameInPositions(WritableImage frame, int[] pos){
        for(int i = 0 ; i < pos.length ; i++){
            sequence.set(pos[i], frame);
        }
        
    }
    
    public void addFrames(Image[] frames){
        
        for(int i = 0 ; i < frames.length ; i++){
            sequence.add(frames[i]);
            numFrames++;
        }
        
    }
    
    public Image getFrame(int i){
        return sequence.get(i);
    }
}
