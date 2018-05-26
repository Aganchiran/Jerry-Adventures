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
public class AssetsMikeleton extends Assets{
    private static final String URL = "slimeboi/resources/EnemiesSpriteSheet.png";
    
    public static final CustomAnimation jackie = new CustomAnimation("slimeboi/resources/EnemyShots.png", 1, 0, 2, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 10, true);
    public static final CustomAnimation tito = new CustomAnimation("slimeboi/resources/EnemyShots.png", 1, 0, 2, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 10, true);
    public static final CustomAnimation jermaine = new CustomAnimation("slimeboi/resources/EnemyShots.png", 1, 0, 2, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 10, true);
    public static final CustomAnimation marlon = new CustomAnimation("slimeboi/resources/EnemyShots.png", 1, 0, 2, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 10, true);
    public static final CustomAnimation randy = new CustomAnimation("slimeboi/resources/EnemyShots.png", 1, 0, 2, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 10, true);
    
    //public static final CustomAnimation[] jackboneFive = {jackie, tito, jermaine, marlon, randy};
    public static final CustomAnimation jackieV2 = new CustomAnimation("slimeboi/resources/EnemyShots.png", 1, 0, 2, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 10, true);
    
    
    
    public AssetsMikeleton() {
        super.idleRight = new CustomAnimation(URL, 4, 0, 10, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 5, true);
        super.idleLeft = new CustomAnimation(URL, 4, 0, 10, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 5, true);
        super.right = new CustomAnimation(URL, 8, 0, 8, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 10, true);/*new CustomAnimation(URL, 1, 0, 0, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 15, false);*/
        super.left = new CustomAnimation(URL, 8, 0, 9, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 10, true);/*new CustomAnimation(URL, 1, 0, 4, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 15, false);*/
        super.onAirRight = super.right;
        super.onAirLeft = super.left;
        super.dieRight = super.right;
        super.dieLeft = super.left;
    }
}
