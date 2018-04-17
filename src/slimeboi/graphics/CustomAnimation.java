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
    
    public WritableImage[] sequence;
    
    public CustomAnimation(String url, int numFrames, int x, int y, int width, int height){
        Image SpriteSheet = new Image(url);//"slimeboi/resources/JerrySpriteSheet.png"
        PixelReader reader = SpriteSheet.getPixelReader();
        
        for(int i = 0 ; i < numFrames ; i++){
            WritableImage frame = new WritableImage(reader, x + ((i % 10) * width), y + ((i / 10) * height), width, height);
            sequence[i] = frame;
        }
        
    }
    
    public void play(GraphicsContext gc){
        
    }
    
}
