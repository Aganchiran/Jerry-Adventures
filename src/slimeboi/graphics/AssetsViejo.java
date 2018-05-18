/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.graphics;

import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

/**
 *
 * @author Javier Pastor Pérez
 */
public class AssetsViejo {
    
    //////////////
    //ANIMATIONS//
    //////////////
    
    private static final int DEFAULT_ANIMATION_WIDTH = 64;
    private static final int DEFAULT_ANIMATION_HEIGHT = 64;
    
    public static final CustomAnimation onAirRight = new CustomAnimation("slimeboi/resources/JerrySpriteSheet.png", 1, 0, 26, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 15, true);
    public static final CustomAnimation hurtRight = new CustomAnimation("slimeboi/resources/JerrySpriteSheet.png", 4, 6, 26, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 15, true);
    //Jerry//
    /*private static final String JERRY_URL = "slimeboi/resources/JerrySpriteSheet.png";
  
    public static final CustomAnimation idleRight = new CustomAnimation(JERRY_URL, 26, 0, 0, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 16, true);
    public static final CustomAnimation idleLeft = new CustomAnimation(JERRY_URL, 26, 0, 3, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 16, true);
    public static final CustomAnimation right = new CustomAnimation(JERRY_URL, 26, 0, 6, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 16, true);
    public static final CustomAnimation left = new CustomAnimation(JERRY_URL, 26, 0, 9, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 16, true);
    public static final CustomAnimation endJumpRight = new CustomAnimation(JERRY_URL, 11, 0, 12, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 30, true);
    public static final CustomAnimation endJumpLeft = new CustomAnimation(JERRY_URL, 11, 0, 14, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 30, true);
    public static final CustomAnimation onAirRight = new CustomAnimation(JERRY_URL, 1, 0, 26, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 60, true);
    public static final CustomAnimation onAirLeft = new CustomAnimation(JERRY_URL, 1, 0, 27, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 60, true);
    public static final CustomAnimation biteRight = new CustomAnimation(JERRY_URL, 18, 0, 16, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 30, true);
    public static final CustomAnimation biteLeft = new CustomAnimation(JERRY_URL, 18, 0, 18, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 30, true);
    public static final CustomAnimation fatIdleRight = new CustomAnimation(JERRY_URL, 16, 0, 20, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 12, true);
    public static final CustomAnimation fatIdleLeft = new CustomAnimation(JERRY_URL, 16, 0, 22, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 12, true);
    public static final CustomAnimation fatRight = new CustomAnimation(JERRY_URL, 10, 0, 24, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 6, true);
    public static final CustomAnimation fatLeft = new CustomAnimation(JERRY_URL, 10, 0, 25, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 6, true);*/
    
    //Ammo//emptyAnimation
    public static final CustomAnimation thunderAmmo = new CustomAnimation("slimeboi/resources/AmmoIcons.png", 7, 0, 0, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 16, true);
    public static final CustomAnimation emptyAnimation = new CustomAnimation("slimeboi/resources/JerrySpriteSheet.png", 1, 9, 2, DEFAULT_ANIMATION_WIDTH, DEFAULT_ANIMATION_HEIGHT, 1, true); 

    
    /////////
    //TILES//
    /////////
    
    private static final int DEFAULT_TILE_WIDTH = 32;
    private static final int DEFAULT_TILE_HEIGHT = 32;
    
    private static final String TILES_URL = "slimeboi/resources/Tileset.png";
    private static final Image tileSet = new Image(TILES_URL);
    private static final PixelReader reader = tileSet.getPixelReader();
    
    //Rock//
    public static final WritableImage RockUpLeft = new WritableImage(reader, 1 * DEFAULT_TILE_WIDTH, 1 * DEFAULT_TILE_HEIGHT,DEFAULT_TILE_WIDTH,DEFAULT_TILE_HEIGHT);
    public static final WritableImage RockUpCenter = new WritableImage(reader, 2 * DEFAULT_TILE_WIDTH, 1 * DEFAULT_TILE_HEIGHT,DEFAULT_TILE_WIDTH,DEFAULT_TILE_HEIGHT);
    public static final WritableImage RockUpRight = new WritableImage(reader, 3 * DEFAULT_TILE_WIDTH, 1 * DEFAULT_TILE_HEIGHT,DEFAULT_TILE_WIDTH,DEFAULT_TILE_HEIGHT);
    public static final WritableImage RockCenterLeft = new WritableImage(reader, 1 * DEFAULT_TILE_WIDTH, 2 * DEFAULT_TILE_HEIGHT,DEFAULT_TILE_WIDTH,DEFAULT_TILE_HEIGHT);
    public static final WritableImage RockCenterCenter = new WritableImage(reader, 2 * DEFAULT_TILE_WIDTH, 2 * DEFAULT_TILE_HEIGHT,DEFAULT_TILE_WIDTH,DEFAULT_TILE_HEIGHT);
    public static final WritableImage RockCenterRight = new WritableImage(reader, 3 * DEFAULT_TILE_WIDTH, 2 * DEFAULT_TILE_HEIGHT,DEFAULT_TILE_WIDTH,DEFAULT_TILE_HEIGHT);
    public static final WritableImage RockDownLeft = new WritableImage(reader, 1 * DEFAULT_TILE_WIDTH, 3 * DEFAULT_TILE_HEIGHT,DEFAULT_TILE_WIDTH,DEFAULT_TILE_HEIGHT);
    public static final WritableImage RockDownCenter = new WritableImage(reader, 2 * DEFAULT_TILE_WIDTH, 3 * DEFAULT_TILE_HEIGHT,DEFAULT_TILE_WIDTH,DEFAULT_TILE_HEIGHT);
    public static final WritableImage RockDownRight = new WritableImage(reader, 3 * DEFAULT_TILE_WIDTH, 3 * DEFAULT_TILE_HEIGHT,DEFAULT_TILE_WIDTH,DEFAULT_TILE_HEIGHT);
    
    public static final WritableImage RockVerticalUp = new WritableImage(reader, 5 * DEFAULT_TILE_WIDTH, 1 * DEFAULT_TILE_HEIGHT,DEFAULT_TILE_WIDTH,DEFAULT_TILE_HEIGHT);
    public static final WritableImage RockVerticalCenter = new WritableImage(reader, 5 * DEFAULT_TILE_WIDTH, 2 * DEFAULT_TILE_HEIGHT,DEFAULT_TILE_WIDTH,DEFAULT_TILE_HEIGHT);
    public static final WritableImage RockVerticalDown = new WritableImage(reader, 5 * DEFAULT_TILE_WIDTH, 3 * DEFAULT_TILE_HEIGHT,DEFAULT_TILE_WIDTH,DEFAULT_TILE_HEIGHT);
    
    public static final WritableImage RockHorizontalRight = new WritableImage(reader, 1 * DEFAULT_TILE_WIDTH, 5 * DEFAULT_TILE_HEIGHT,DEFAULT_TILE_WIDTH,DEFAULT_TILE_HEIGHT);
    public static final WritableImage RockHorizontalCenter = new WritableImage(reader, 2 * DEFAULT_TILE_WIDTH, 5 * DEFAULT_TILE_HEIGHT,DEFAULT_TILE_WIDTH,DEFAULT_TILE_HEIGHT);
    public static final WritableImage RockHorizontalLeft = new WritableImage(reader, 3 * DEFAULT_TILE_WIDTH, 5 * DEFAULT_TILE_HEIGHT,DEFAULT_TILE_WIDTH,DEFAULT_TILE_HEIGHT);
    
    public static final WritableImage RockSingleBlock = new WritableImage(reader, 5 * DEFAULT_TILE_WIDTH, 5 * DEFAULT_TILE_HEIGHT,DEFAULT_TILE_WIDTH,DEFAULT_TILE_HEIGHT);
    
    public static final WritableImage Cave = new WritableImage(reader, 7 * DEFAULT_TILE_WIDTH, 1 * DEFAULT_TILE_HEIGHT,DEFAULT_TILE_WIDTH,DEFAULT_TILE_HEIGHT);
    
    //Earth//
    
    public static final WritableImage EarthUpLeft = new WritableImage(reader, 10 * DEFAULT_TILE_WIDTH, 1 * DEFAULT_TILE_HEIGHT,DEFAULT_TILE_WIDTH,DEFAULT_TILE_HEIGHT);
    public static final WritableImage EarthUpCenter = new WritableImage(reader, 11 * DEFAULT_TILE_WIDTH, 1 * DEFAULT_TILE_HEIGHT,DEFAULT_TILE_WIDTH,DEFAULT_TILE_HEIGHT);
    public static final WritableImage EarthUpRight = new WritableImage(reader, 12 * DEFAULT_TILE_WIDTH, 1 * DEFAULT_TILE_HEIGHT,DEFAULT_TILE_WIDTH,DEFAULT_TILE_HEIGHT);
    public static final WritableImage EarthCenterLeft = new WritableImage(reader, 10 * DEFAULT_TILE_WIDTH, 2 * DEFAULT_TILE_HEIGHT,DEFAULT_TILE_WIDTH,DEFAULT_TILE_HEIGHT);
    public static final WritableImage EarthCenterCenter = new WritableImage(reader, 11 * DEFAULT_TILE_WIDTH, 2 * DEFAULT_TILE_HEIGHT,DEFAULT_TILE_WIDTH,DEFAULT_TILE_HEIGHT);
    public static final WritableImage EarthCenterRight = new WritableImage(reader, 12 * DEFAULT_TILE_WIDTH, 2 * DEFAULT_TILE_HEIGHT,DEFAULT_TILE_WIDTH,DEFAULT_TILE_HEIGHT);
    public static final WritableImage EarthDownLeft = new WritableImage(reader, 10 * DEFAULT_TILE_WIDTH, 3 * DEFAULT_TILE_HEIGHT,DEFAULT_TILE_WIDTH,DEFAULT_TILE_HEIGHT);
    public static final WritableImage EarthDownCenter = new WritableImage(reader, 11 * DEFAULT_TILE_WIDTH, 3 * DEFAULT_TILE_HEIGHT,DEFAULT_TILE_WIDTH,DEFAULT_TILE_HEIGHT);
    public static final WritableImage EarthDownRight = new WritableImage(reader, 12 * DEFAULT_TILE_WIDTH, 3 * DEFAULT_TILE_HEIGHT,DEFAULT_TILE_WIDTH,DEFAULT_TILE_HEIGHT);
    
    public static final WritableImage EarthVerticalUp = new WritableImage(reader, 14 * DEFAULT_TILE_WIDTH, 1 * DEFAULT_TILE_HEIGHT,DEFAULT_TILE_WIDTH,DEFAULT_TILE_HEIGHT);
    public static final WritableImage EarthVerticalCenter = new WritableImage(reader, 14 * DEFAULT_TILE_WIDTH, 2 * DEFAULT_TILE_HEIGHT,DEFAULT_TILE_WIDTH,DEFAULT_TILE_HEIGHT);
    public static final WritableImage EarthVerticalDown = new WritableImage(reader, 14 * DEFAULT_TILE_WIDTH, 3 * DEFAULT_TILE_HEIGHT,DEFAULT_TILE_WIDTH,DEFAULT_TILE_HEIGHT);
    
    public static final WritableImage EarthHorizontalLeft = new WritableImage(reader, 10 * DEFAULT_TILE_WIDTH, 5 * DEFAULT_TILE_HEIGHT,DEFAULT_TILE_WIDTH,DEFAULT_TILE_HEIGHT);
    public static final WritableImage EarthHorizontalCenter = new WritableImage(reader, 11 * DEFAULT_TILE_WIDTH, 5 * DEFAULT_TILE_HEIGHT,DEFAULT_TILE_WIDTH,DEFAULT_TILE_HEIGHT);
    public static final WritableImage EarthHorizontalRight = new WritableImage(reader, 12 * DEFAULT_TILE_WIDTH, 5 * DEFAULT_TILE_HEIGHT,DEFAULT_TILE_WIDTH,DEFAULT_TILE_HEIGHT);
    
    public static final WritableImage EarthSingleBlock = new WritableImage(reader, 14 * DEFAULT_TILE_WIDTH, 5 * DEFAULT_TILE_HEIGHT,DEFAULT_TILE_WIDTH,DEFAULT_TILE_HEIGHT);
    
    public static final WritableImage Sky = new WritableImage(reader, 8 * DEFAULT_TILE_WIDTH, 5 * DEFAULT_TILE_HEIGHT,DEFAULT_TILE_WIDTH,DEFAULT_TILE_HEIGHT);
    
}
