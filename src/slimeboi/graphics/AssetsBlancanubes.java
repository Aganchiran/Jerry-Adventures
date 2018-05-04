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
    
    public static final CustomAnimation screamRight = new CustomAnimation(URL, 38, 0, 0, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 30, false);
    
    public AssetsBlancanubes() {
        super.idleRight = new CustomAnimation(URL, 1, 0, 0, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 60, false);
        super.idleLeft = new CustomAnimation(URL, 1, 0, 4, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 60, false);
        super.right = super.idleRight;
        super.left = super.idleLeft;
        super.onAirRight = super.idleRight;
        super.onAirLeft = super.idleLeft;
        super.dieRight = super.idleRight;
        super.dieLeft = super.idleLeft;
    }
}
