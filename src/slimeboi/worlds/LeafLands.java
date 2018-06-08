/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.worlds;

import slimeboi.Game;
import slimeboi.entities.Victor;
import slimeboi.entities.creatures.enemies.BBQSoslime;
import slimeboi.entities.creatures.enemies.Blancanubes;
import slimeboi.entities.creatures.enemies.Mikeleton;
import slimeboi.entities.tiles.EarthCenterCenter;
import slimeboi.entities.tiles.EarthCenterLeft;
import slimeboi.entities.tiles.EarthCenterRight;
import slimeboi.entities.tiles.EarthDownCenter;
import slimeboi.entities.tiles.EarthDownLeft;
import slimeboi.entities.tiles.EarthDownRight;
import slimeboi.entities.tiles.EarthHorizontalCenter;
import slimeboi.entities.tiles.EarthHorizontalLeft;
import slimeboi.entities.tiles.EarthHorizontalRight;
import slimeboi.entities.tiles.EarthSingleBlock;
import slimeboi.entities.tiles.EarthUpCenter;
import slimeboi.entities.tiles.EarthUpLeft;
import slimeboi.entities.tiles.EarthUpRight;
import slimeboi.entities.tiles.EarthVerticalCenter;
import slimeboi.entities.tiles.EarthVerticalDown;
import slimeboi.entities.tiles.EarthVerticalUp;
import slimeboi.entities.tiles.SkyTile;

/**
 *
 * @author Javier Pastor Pérez
 */
public class LeafLands extends World{
    
    public LeafLands(Game game) {
        super("src/slimeboi/resources/TemmieVillage.mp3", "src/slimeboi/resources/LeafLands.txt", 116, 28, game);
        tileSet.add(new SkyTile());//00
        tileSet.add(new EarthUpLeft());//01
        tileSet.add(new EarthUpCenter());//02
        tileSet.add(new EarthUpRight());//03
        tileSet.add(new EarthCenterLeft());//04
        tileSet.add(new EarthCenterCenter());//05
        tileSet.add(new EarthCenterRight());//06
        tileSet.add(new EarthDownLeft());//07
        tileSet.add(new EarthDownCenter());//08
        tileSet.add(new EarthDownRight());//09
        tileSet.add(new EarthVerticalUp());//10
        tileSet.add(new EarthVerticalCenter());//11
        tileSet.add(new EarthVerticalDown());//12
        tileSet.add(new EarthHorizontalLeft());//13
        tileSet.add(new EarthHorizontalCenter());//14
        tileSet.add(new EarthHorizontalRight());//15
        tileSet.add(new EarthSingleBlock());//16
        
        //initializeWorld();
    }

    @Override
    public void initializeWorld() {
        bgMusic.play();
        //entities.add(new Blancanubes(480, 75, 150, 6000, game));
        //entities.add(new BBQSoslime(200, 100, 36, 16, 14, 48, game));
        //entities.add(new Blancanubes(350, 460, 450, 5000,game));
        //entities.add(new BBQSoslime(600, 500, 36, 16, 14, 48, game));
        //entities.add(new Mikeleton(900, 100, 300, 5000, game));
        
        entities.add(new BBQSoslime(35 * 32, 24 * 32, 36, 16, 14, 48, game));
        entities.add(new Victor(110 * 32, 29 * 32, 64, 64, game));
        
        entities.add(new BBQSoslime(89 * 32, 24 * 32, 36, 16, 14, 48, game));
        entities.add(new BBQSoslime(90 * 32, 24 * 32, 36, 16, 14, 48, game));
        entities.add(new BBQSoslime(91 * 32, 24 * 32, 36, 16, 14, 48, game));
        entities.add(new BBQSoslime(92 * 32, 24 * 32, 36, 16, 14, 48, game));
        entities.add(new BBQSoslime(93 * 32, 24 * 32, 36, 16, 14, 48, game));
        entities.add(new BBQSoslime(94 * 32, 24 * 32, 36, 16, 14, 48, game));
        entities.add(new BBQSoslime(95 * 32, 24 * 32, 36, 16, 14, 48, game));
        entities.add(new BBQSoslime(96 * 32, 24 * 32, 36, 16, 14, 48, game));
        entities.add(new BBQSoslime(97 * 32, 24 * 32, 36, 16, 14, 48, game));
        entities.add(new BBQSoslime(98 * 32, 24 * 32, 36, 16, 14, 48, game));
        entities.add(new BBQSoslime(99 * 32, 24 * 32, 36, 16, 14, 48, game));
        entities.add(new BBQSoslime(100 * 32, 24 * 32, 36, 16, 14, 48, game));
        entities.add(new BBQSoslime(101 * 32, 24 * 32, 36, 16, 14, 48, game));
        entities.add(new BBQSoslime(102 * 32, 24 * 32, 36, 16, 14, 48, game));
        entities.add(new BBQSoslime(103 * 32, 24 * 32, 36, 16, 14, 48, game));
        entities.add(new BBQSoslime(104 * 32, 24 * 32, 36, 16, 14, 48, game));
        entities.add(new BBQSoslime(105 * 32, 24 * 32, 36, 16, 14, 48, game));
        entities.add(new BBQSoslime(106 * 32, 24 * 32, 36, 16, 14, 48, game));
        entities.add(new BBQSoslime(107 * 32, 24 * 32, 36, 16, 14, 48, game));
        entities.add(new BBQSoslime(108 * 32, 24 * 32, 36, 16, 14, 48, game));

        entities.add(new Blancanubes( 78 * 32, 26 * 32 - 149, 7 * 32, 5000, game));
        
        game.jerry.setSpawn(3 * 32, 6 * 32);
    }
    
}
