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
public class AssetsBollito extends Assets{
    public final CustomAnimation hitGround = new CustomAnimation("slimeboi/resources/BollitoSprite.png", 11, 0, 2, 512, 256, 15, true);
    public AssetsBollito(){
        super.idleRight = new CustomAnimation("slimeboi/resources/BollitoSprite.png", 16, 0, 0, 512, 256, 15, true);
        super.idleLeft = new CustomAnimation("slimeboi/resources/BollitoSprite.png", 16, 0, 0, 512, 256, 15, true);
        super.right = idleRight;
        super.left = idleRight;
        super.onAirRight = idleRight;
        super.onAirLeft = idleRight;
        super.dieRight = idleRight;
        super.dieLeft = idleRight;
    }
    
}
