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
public class Assets {
    private static final int defaultAnimationWidth = 64;
    private static final int defaultAnimationHeight = 64;
    private static final int defaultTileWidth = 32;
    private static final int defaultTileHeight = 32;
    
    
    //Jerry Animations//
    private static final String jerryUrl = "slimeboi/resources/JerrySpriteSheet.png";
  
    public static final CustomAnimation idleRight = new CustomAnimation(jerryUrl, 26, 0, 0, defaultAnimationWidth, defaultAnimationHeight, 16);
    public static final CustomAnimation idleLeft = new CustomAnimation(jerryUrl, 26, 0, 3, defaultAnimationWidth, defaultAnimationHeight, 16);
    public static final CustomAnimation right = new CustomAnimation(jerryUrl, 26, 0, 6, defaultAnimationWidth, defaultAnimationHeight, 16);
    public static final CustomAnimation left = new CustomAnimation(jerryUrl, 26, 0, 9, defaultAnimationWidth, defaultAnimationHeight, 16);
    public static final CustomAnimation endJumpRight = new CustomAnimation(jerryUrl, 11, 0, 12, defaultAnimationWidth, defaultAnimationHeight, 30);
    public static final CustomAnimation endJumpLeft = new CustomAnimation(jerryUrl, 11, 0, 14, defaultAnimationWidth, defaultAnimationHeight, 30);
    public static final CustomAnimation onAirRight = new CustomAnimation(jerryUrl, 1, 0, 26, defaultAnimationWidth, defaultAnimationHeight, 60);
    public static final CustomAnimation onAirLeft = new CustomAnimation(jerryUrl, 1, 0, 27, defaultAnimationWidth, defaultAnimationHeight, 60);
    public static final CustomAnimation biteRight = new CustomAnimation(jerryUrl, 18, 0, 16, defaultAnimationWidth, defaultAnimationHeight, 30);
    public static final CustomAnimation biteLeft = new CustomAnimation(jerryUrl, 18, 0, 18, defaultAnimationWidth, defaultAnimationHeight, 30);
    public static final CustomAnimation fatIdleRight = new CustomAnimation(jerryUrl, 16, 0, 20, defaultAnimationWidth, defaultAnimationHeight, 12);
    public static final CustomAnimation fatIdleLeft = new CustomAnimation(jerryUrl, 16, 0, 22, defaultAnimationWidth, defaultAnimationHeight, 12);
    public static final CustomAnimation fatRight = new CustomAnimation(jerryUrl, 10, 0, 24, defaultAnimationWidth, defaultAnimationHeight, 6);
    public static final CustomAnimation fatLeft = new CustomAnimation(jerryUrl, 10, 0, 25, defaultAnimationWidth, defaultAnimationHeight, 6);
    
    //Earth Tiles//
    private static final String earthTilesUrl = "slimeboi/resources/TilesetTierra.png";
    private static final Image EarthTileSet = new Image(earthTilesUrl);
    private static final PixelReader reader = EarthTileSet.getPixelReader();
    
    public static final WritableImage EarthUC = new WritableImage(reader,64,32,defaultTileWidth,defaultTileHeight);
    public static final WritableImage EarthCC = new WritableImage(reader,64,64,defaultTileWidth,defaultTileHeight);
    
}
