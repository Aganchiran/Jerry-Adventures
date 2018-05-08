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
 * @author Javier Pastor Pérez
 */
public class AssetsJerryBlink extends AssetsJerry{
    private static final String JERRY_URL = "slimeboi/resources/JerrySpriteSheet.png";
    
    
    
    //public static final CustomAnimation idleRight = new CustomAnimation(JERRY_URL, 26, 0, 0, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 16);
    //public static final CustomAnimation idleLeft = new CustomAnimation(JERRY_URL, 26, 0, 3, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 16);
    //public static final CustomAnimation right = new CustomAnimation(JERRY_URL, 26, 0, 6, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 16);
    //public static final CustomAnimation left = new CustomAnimation(JERRY_URL, 26, 0, 9, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 16);
    //public static final CustomAnimation endJumpRight = new CustomAnimation(JERRY_URL, 13, 0, 12, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 30, false);
    //public static final CustomAnimation endJumpLeft = new CustomAnimation(JERRY_URL, 13, 0, 14, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 30, false);
    //public static final CustomAnimation onAirRight = new CustomAnimation(JERRY_URL, 1, 0, 26, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 60);
    //public static final CustomAnimation onAirLeft = new CustomAnimation(JERRY_URL, 1, 0, 27, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 60);
    //public static final CustomAnimation biteRight = new CustomAnimation(JERRY_URL, 10, 0, 16, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 30, false);
    //public static final CustomAnimation biteLeft = new CustomAnimation(JERRY_URL, 10, 0, 18, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 30, false);
    //public static final CustomAnimation endBiteRight = new CustomAnimation(JERRY_URL, 8, 0, 17, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 20, false);
    //public static final CustomAnimation endBiteLeft = new CustomAnimation(JERRY_URL, 8, 0, 19, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 20, false);
    //public static final CustomAnimation fatIdleRight = new CustomAnimation(JERRY_URL, 16, 0, 20, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 12);
    //public static final CustomAnimation fatIdleLeft = new CustomAnimation(JERRY_URL, 16, 0, 22, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 12);
    //public static final CustomAnimation fatRight = new CustomAnimation(JERRY_URL, 10, 0, 24, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 6);
    //public static final CustomAnimation fatLeft = new CustomAnimation(JERRY_URL, 10, 0, 25, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 6);
    

    public AssetsJerryBlink() {
        Image SpriteSheet = new Image(JERRY_URL);//"slimeboi/resources/JerrySpriteSheet.png"
        PixelReader reader = SpriteSheet.getPixelReader();
        WritableImage emptyFrame = new WritableImage(reader, 9 * DEFAULT_ANIMATION_WIDTH, 2 * DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT);
        
        int[] pos = {0,1,7,8,13,14,20,21};
        super.idleRight.setFrameInPositions(emptyFrame, pos);
        super.idleLeft.setFrameInPositions(emptyFrame, pos);
        super.right.setFrameInPositions(emptyFrame, pos);
        super.left.setFrameInPositions(emptyFrame, pos);
        
        Image[] frames = {super.onAirRight.nextFrame(), super.onAirRight.nextFrame(), super.onAirRight.nextFrame(),emptyFrame};
        super.onAirRight.addFrames(frames);
        Image[] froms = {super.onAirLeft.nextFrame(), super.onAirLeft.nextFrame(), super.onAirLeft.nextFrame(),emptyFrame};
        super.onAirLeft.addFrames(froms);
        
        
        //super.dieRight.addFrames(frames);
        //super.dieLeft.addFrames(frames);
        int[] pos2 = {0,1,7,8};
        super.endJumpRight.setFrameInPositions(emptyFrame, pos2); //13
        super.endJumpLeft.setFrameInPositions(emptyFrame, pos2);
        super.biteRight.setFrameInPositions(emptyFrame, pos2); //10
        super.biteLeft.setFrameInPositions(emptyFrame, pos2);
        int[] pos3 = {0,1};
        super.endBiteRight.setFrameInPositions(emptyFrame, pos3); //8
        super.endBiteLeft.setFrameInPositions(emptyFrame, pos3);
    }
}
