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
public class AssetsPinchita extends Assets{
    public static final CustomAnimation pinchitaColgadita = new CustomAnimation("slimeboi/resources/EnemiesSpriteSheet.png", 1, 0, 11, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 15, true);
    public static final CustomAnimation pinchitaDescolgadita = new CustomAnimation("slimeboi/resources/EnemiesSpriteSheet.png", 1, 1, 11, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 15, true);
    public static final CustomAnimation pinchitaPinchadita = new CustomAnimation("slimeboi/resources/EnemiesSpriteSheet.png", 1, 2, 11, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 15, true);
    
    public AssetsPinchita(){
        super.idleRight = pinchitaPinchadita;
        super.idleLeft = pinchitaPinchadita;
        super.right = pinchitaPinchadita;
        super.left = pinchitaPinchadita;
        super.onAirRight = pinchitaDescolgadita;
        super.onAirLeft = pinchitaDescolgadita;
        super.dieRight = pinchitaPinchadita;
        super.dieLeft = pinchitaPinchadita;
    }
}
