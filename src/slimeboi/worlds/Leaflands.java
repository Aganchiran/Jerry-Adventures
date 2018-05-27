/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.worlds;

import slimeboi.Game;
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
public class Leaflands extends World{
    
    public Leaflands(String music, String mapURL, int width, int height, Game game) {
        super(music, mapURL, width, height, game);
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
        
        initializeWorld();
    }

    @Override
    public void initializeWorld() {
        entities.add(new Blancanubes(480, 75, 150, 6000, game));
        //entities.add(new BBQSoslime(800, 100, 36, 16, 14, 48, game));
        entities.add(new Blancanubes(350, 460, 450, 5000,game));
        //entities.add(new BBQSoslime(600, 500, 36, 16, 14, 48, game));
        entities.add(new Mikeleton(900, 100, 300, 5000, game));
    }
    
}
