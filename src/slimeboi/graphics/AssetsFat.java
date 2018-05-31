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
        super.idleRight = new CustomAnimation(JERRY_URL, 16, 0, 20, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 12, true);
        super.idleLeft = new CustomAnimation(JERRY_URL, 16, 0, 22, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 12, true);
        super.right = new CustomAnimation(JERRY_URL, 16, 0, 24, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 12, true);
        super.left = new CustomAnimation(JERRY_URL, 16, 0, 26, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 12, true);
        super.onAirRight = new CustomAnimation(JERRY_URL, 1, 1, 28, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 15, true);
        super.onAirLeft = new CustomAnimation(JERRY_URL, 1, 1, 29, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 15, true);
        super.endJumpRight = new CustomAnimation(JERRY_URL, 13, 0, 32, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 26, false);
        super.endJumpLeft = new CustomAnimation(JERRY_URL, 13, 0, 34, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 26, false);
    }
}
