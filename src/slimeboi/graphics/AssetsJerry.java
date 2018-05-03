/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.graphics;

/**
 *
 * @author Javier Pastor Pérez
 */
public class AssetsJerry extends Assets{
    private static final String JERRY_URL = "slimeboi/resources/JerrySpriteSheet.png";
    
    
    
    //public static final CustomAnimation idleRight = new CustomAnimation(JERRY_URL, 26, 0, 0, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 16);
    //public static final CustomAnimation idleLeft = new CustomAnimation(JERRY_URL, 26, 0, 3, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 16);
    //public static final CustomAnimation right = new CustomAnimation(JERRY_URL, 26, 0, 6, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 16);
    //public static final CustomAnimation left = new CustomAnimation(JERRY_URL, 26, 0, 9, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 16);
    public static final CustomAnimation endJumpRight = new CustomAnimation(JERRY_URL, 13, 0, 12, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 30, false);
    public static final CustomAnimation endJumpLeft = new CustomAnimation(JERRY_URL, 13, 0, 14, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 30, false);
    //public static final CustomAnimation onAirRight = new CustomAnimation(JERRY_URL, 1, 0, 26, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 60);
    //public static final CustomAnimation onAirLeft = new CustomAnimation(JERRY_URL, 1, 0, 27, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 60);
    public static final CustomAnimation biteRight = new CustomAnimation(JERRY_URL, 10, 0, 16, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 30, false);
    public static final CustomAnimation biteLeft = new CustomAnimation(JERRY_URL, 10, 0, 18, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 30, false);
    public static final CustomAnimation endBiteRight = new CustomAnimation(JERRY_URL, 8, 0, 17, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 20, false);
    public static final CustomAnimation endBiteLeft = new CustomAnimation(JERRY_URL, 8, 0, 19, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 20, false);
    //public static final CustomAnimation fatIdleRight = new CustomAnimation(JERRY_URL, 16, 0, 20, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 12);
    //public static final CustomAnimation fatIdleLeft = new CustomAnimation(JERRY_URL, 16, 0, 22, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 12);
    //public static final CustomAnimation fatRight = new CustomAnimation(JERRY_URL, 10, 0, 24, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 6);
    //public static final CustomAnimation fatLeft = new CustomAnimation(JERRY_URL, 10, 0, 25, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 6);

    public AssetsJerry() {
        super.idleRight = new CustomAnimation(JERRY_URL, 26, 0, 0, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 16, true);
        super.idleLeft = new CustomAnimation(JERRY_URL, 26, 0, 3, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 16, true);
        super.right = new CustomAnimation(JERRY_URL, 26, 0, 6, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 16, true);
        super.left = new CustomAnimation(JERRY_URL, 26, 0, 9, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 16, true);
        super.onAirRight = new CustomAnimation(JERRY_URL, 1, 0, 26, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 60, true);
        super.onAirLeft = new CustomAnimation(JERRY_URL, 1, 0, 27, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 60, true);
        super.dieRight = new CustomAnimation(JERRY_URL, 1, 0, 26, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 60, false);
        super.dieLeft = new CustomAnimation(JERRY_URL, 1, 0, 27, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 60, false);
    }
}
