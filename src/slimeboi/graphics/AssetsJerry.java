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
    protected static final String JERRY_URL = "slimeboi/resources/JerrySpriteSheet.png";
    
    
    
    //public static final CustomAnimation idleRight = new CustomAnimation(JERRY_URL, 26, 0, 0, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 16);
    //public static final CustomAnimation idleLeft = new CustomAnimation(JERRY_URL, 26, 0, 3, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 16);
    //public static final CustomAnimation right = new CustomAnimation(JERRY_URL, 26, 0, 6, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 16);
    //public static final CustomAnimation left = new CustomAnimation(JERRY_URL, 26, 0, 9, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 16);
    public CustomAnimation endJumpRight = new CustomAnimation(JERRY_URL, 13, 0, 12, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 30, false);
    public CustomAnimation endJumpLeft = new CustomAnimation(JERRY_URL, 13, 0, 14, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 30, false);
    //public static final CustomAnimation onAirRight = new CustomAnimation(JERRY_URL, 1, 0, 26, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 60);
    //public static final CustomAnimation onAirLeft = new CustomAnimation(JERRY_URL, 1, 0, 27, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 60);
    public CustomAnimation biteRight = new CustomAnimation(JERRY_URL, 10, 0, 16, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 30, false);
    public CustomAnimation biteLeft = new CustomAnimation(JERRY_URL, 10, 0, 18, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 30, false);
    public CustomAnimation endBiteRight = new CustomAnimation(JERRY_URL, 8, 0, 17, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 20, false);
    public CustomAnimation endBiteLeft = new CustomAnimation(JERRY_URL, 8, 0, 19, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 20, false);
    //public static final CustomAnimation fatIdleRight = new CustomAnimation(JERRY_URL, 16, 0, 20, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 12);
    //public static final CustomAnimation fatIdleLeft = new CustomAnimation(JERRY_URL, 16, 0, 22, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 12);
    //public static final CustomAnimation fatRight = new CustomAnimation(JERRY_URL, 10, 0, 24, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 6);
    //public static final CustomAnimation fatLeft = new CustomAnimation(JERRY_URL, 10, 0, 25, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 6);
    public CustomAnimation hurtRight = new CustomAnimation(JERRY_URL, 1, 6, 26, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 15, true);
    public CustomAnimation hurtLeft = new CustomAnimation(JERRY_URL, 1, 6, 27, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 15, true);
    public CustomAnimation spitRight = new CustomAnimation(JERRY_URL, 8, 0, 28, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 24, false);
    public CustomAnimation spitLeft = new CustomAnimation(JERRY_URL, 8, 0, 29, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 24, false);
    public CustomAnimation noEatRight = new CustomAnimation(JERRY_URL, 4, 4, 28, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 16, false);
    public CustomAnimation noEatLeft = new CustomAnimation(JERRY_URL, 4, 4, 29, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 16, false);


    public static final CustomAnimation emptyAnimation =  new CustomAnimation(JERRY_URL, 1, 9, 2, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 60, false);

    public AssetsJerry() {
        super.idleRight = new CustomAnimation(JERRY_URL, 26, 0, 0, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 16, true);
        super.idleLeft = new CustomAnimation(JERRY_URL, 26, 0, 3, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 16, true);
        super.right = new CustomAnimation(JERRY_URL, 26, 0, 6, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 16, true);
        super.left = new CustomAnimation(JERRY_URL, 26, 0, 9, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 16, true);
        super.onAirRight = new CustomAnimation(JERRY_URL, 1, 0, 26, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 15, true);
        super.onAirLeft = new CustomAnimation(JERRY_URL, 1, 0, 27, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 15, true);
        super.dieRight = new CustomAnimation(JERRY_URL, 1, 0, 26, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 4, false);
        super.dieLeft = new CustomAnimation(JERRY_URL, 1, 0, 27, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 4, false);
    }
}
