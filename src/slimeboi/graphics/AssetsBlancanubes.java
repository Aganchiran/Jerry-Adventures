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
public class AssetsBlancanubes extends Assets{
    private static final String URL = "slimeboi/resources/EnemiesSpriteSheet.png";
    
    public final CustomAnimation chargeRight = new CustomAnimation(URL, 14, 0, 0, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 30, false);
    public final CustomAnimation chargeLeft = new CustomAnimation(URL, 14, 0, 4, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 30, false);
    
    public static final CustomAnimation sieteRayitos = new CustomAnimation("slimeboi/resources/EnemyShots.png", 7, 0, 0, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT * 2, 10, true);
    
    public AssetsBlancanubes() {
        super.idleRight = new CustomAnimation(URL, 24, 4, 1, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 15, true);
        super.idleLeft = new CustomAnimation(URL, 24, 4, 5, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 15, true);
        super.right = new CustomAnimation(URL, 14, 0, 0, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 30, false);/*new CustomAnimation(URL, 1, 0, 0, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 15, false);*/
        super.left = new CustomAnimation(URL, 14, 0, 4, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 30, false);/*new CustomAnimation(URL, 1, 0, 4, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 15, false);*/
        super.onAirRight = super.right;
        super.onAirLeft = super.left;
        super.dieRight = super.right;
        super.dieLeft = super.left;
    }
}
