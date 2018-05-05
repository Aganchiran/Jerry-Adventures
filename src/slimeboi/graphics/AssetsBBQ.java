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
    
    //public static final CustomAnimation NeedlesOut = new CustomAnimation(URL, 15, 0, 0, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 24, false);
    //public static final CustomAnimation NeedlesIn = new CustomAnimation(URL, 5, 3, 3, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 24, false);
    
    public AssetsBBQ(){
        super.idleRight = new CustomAnimation(URL, 1, 0, 0, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 60, false);
        super.idleLeft = new CustomAnimation(URL, 1, 0, 5, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 60, false);
        super.right = super.idleRight;
        super.left = super.idleLeft;
        super.onAirRight = super.idleRight;
        super.onAirLeft = super.idleLeft;
        super.dieRight = super.idleRight;
        super.dieLeft = super.idleLeft;
        
    }
}
