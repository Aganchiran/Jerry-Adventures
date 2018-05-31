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
import slimeboi.entities.tiles.RockCenterCenter;
import slimeboi.entities.tiles.RockCenterLeft;
import slimeboi.entities.tiles.RockCenterRight;
import slimeboi.entities.tiles.RockDownCenter;
import slimeboi.entities.tiles.RockDownLeft;
import slimeboi.entities.tiles.RockDownRight;
import slimeboi.entities.tiles.RockHorizontalCenter;
import slimeboi.entities.tiles.RockHorizontalLeft;
import slimeboi.entities.tiles.RockHorizontalRight;
import slimeboi.entities.tiles.RockSingleBlock;
import slimeboi.entities.tiles.RockUpCenter;
import slimeboi.entities.tiles.RockUpLeft;
import slimeboi.entities.tiles.RockUpRight;
import slimeboi.entities.tiles.RockVerticalCenter;
import slimeboi.entities.tiles.RockVerticalDown;
import slimeboi.entities.tiles.RockVerticalUp;
import slimeboi.entities.tiles.CaveTile;


/**
 *
 * @author Javier Pastor Pérez
 */
public class Cave extends World{
    
    public Cave(String music, String mapURL, int width, int height, Game game) {
        super(music, mapURL, width, height, game);
        tileSet.add(new CaveTile());//00
        tileSet.add(new RockUpLeft());//01
        tileSet.add(new RockUpCenter());//02
        tileSet.add(new RockUpRight());//03
        tileSet.add(new RockCenterLeft());//04
        tileSet.add(new RockCenterCenter());//05
        tileSet.add(new RockCenterRight());//06
        tileSet.add(new RockDownLeft());//07
        tileSet.add(new RockDownCenter());//08
        tileSet.add(new RockDownRight());//09
        tileSet.add(new RockVerticalUp());//10
        tileSet.add(new RockVerticalCenter());//11
        tileSet.add(new RockVerticalDown());//12
        tileSet.add(new RockHorizontalLeft());//13
        tileSet.add(new RockHorizontalCenter());//14
        tileSet.add(new RockHorizontalRight());//15
        tileSet.add(new RockSingleBlock());//16
        
        initializeWorld();
    }

    @Override
    public void initializeWorld() {
        entities.add(new Blancanubes(480, 75, 150, 6000, game));
        //entities.add(new BBQSoslime(800, 100, 36, 16, 14, 48, game));
        entities.add(new Blancanubes(350, 460, 450, 5000,game));
        //entities.add(new BBQSoslime(600, 500, 36, 16, 14, 48, game));
        
        //entities.add(new BBQSoslime(300, 500, 36, 16, 14, 48, game));
        entities.add(new Mikeleton(900, 100, 300, 5000, game));
        entities.add(new Mikeleton(10, 500, 100, 5000, game));
        entities.add(new Mikeleton(120, 500, 290, 5000, game));
    }
    
}
