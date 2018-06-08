/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.graphics;

/**
 *
 * @author Salahodin
 */
public class AssetsBBQ extends Assets {
    private static final String URL = "slimeboi/resources/BBQSprite.png";
    
    public static final CustomAnimation NeedlesOutR = new CustomAnimation(URL, 42, 0, 0, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 24, true);
    public static final CustomAnimation NeedlesInR = new CustomAnimation(URL, 21, 0, 2, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 24, false);
    
    public static final CustomAnimation NeedlesOutL = new CustomAnimation(URL, 42, 0, 5, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 24, true);
    public static final CustomAnimation NeedlesInL = new CustomAnimation(URL, 21, 0, 7, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 24, false);
    
    public AssetsBBQ(){
        super.idleRight = new CustomAnimation(URL, 1, 0, 0, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 60, false);
        super.idleLeft = new CustomAnimation(URL, 1, 0, 5, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 60, false);
        super.right = new CustomAnimation(URL, 42, 0, 0, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 24, true);
        super.left = new CustomAnimation(URL, 42, 0, 5, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 24, true);
        super.onAirRight = super.idleRight;
        super.onAirLeft = super.idleLeft;
        super.dieRight = super.idleRight;
        super.dieLeft = super.idleLeft;
        
    }
}
