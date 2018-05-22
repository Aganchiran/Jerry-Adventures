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
public class AssetsFat extends AssetsJerry{
    
    public AssetsFat(){
        super.idleRight = new CustomAnimation(JERRY_URL, 10, 0, 20, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 12, true);
        super.idleLeft = new CustomAnimation(JERRY_URL, 10, 0, 22, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 12, true);
        super.right = new CustomAnimation(JERRY_URL, 10, 0, 24, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 6, true);
        super.left = new CustomAnimation(JERRY_URL, 10, 0, 25, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 6, true);
        super.endJumpRight = super.endBiteRight;
        super.endJumpLeft = super.endBiteLeft;
    }
}
