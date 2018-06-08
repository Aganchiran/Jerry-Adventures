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
import slimeboi.entities.creatures.enemies.Pinchita;
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
    
    public Cave(Game game) {
        super("src/slimeboi/resources/Bonetrousle.mp3", "src/slimeboi/resources/Cave.txt", 101, 27, game);
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
        
        //initializeWorld();
    }

    @Override
    public void initializeWorld() {
        bgMusic.play();
        entities.add(new Mikeleton(50, 300, 400, 7000, game));
        entities.add(new Pinchita(10 * 32 - 16, 8 * 32 + 13, 60, true, game));
        entities.add(new Mikeleton(400, 300, 300, 5000, game));
        entities.add(new Pinchita(30 * 32 - 16, 8 * 32 + 13, 16, true, game));
        
        entities.add(new Pinchita(46 * 32 - 16, 8 * 32 + 13, 16, true, game));
        entities.add(new Pinchita(47 * 32 - 16, 8 * 32 + 13, 16, true, game));
        entities.add(new Pinchita(48 * 32 - 16, 8 * 32 + 13, 16, true, game));
        entities.add(new Pinchita(49 * 32 - 16, 8 * 32 + 13, 16, true, game));
        entities.add(new Pinchita(50 * 32 - 16, 8 * 32 + 13, 16, true, game));
        entities.add(new Pinchita(51 * 32 - 16, 8 * 32 + 13, 16, true, game));
        entities.add(new Pinchita(52 * 32 - 16, 8 * 32 + 13, 16, true, game));
        entities.add(new Pinchita(53 * 32 - 16, 8 * 32 + 13, 16, true, game));
        entities.add(new Pinchita(54 * 32 - 16, 8 * 32 + 13, 16, true, game));
        entities.add(new Pinchita(55 * 32 - 16, 8 * 32 + 13, 16, true, game));
        entities.add(new Pinchita(56 * 32 - 16, 8 * 32 + 13, 16, true, game));
        entities.add(new Pinchita(57 * 32 - 16, 8 * 32 + 13, 16, true, game));
        entities.add(new Pinchita(58 * 32 - 16, 8 * 32 + 13, 16, true, game));
        entities.add(new Pinchita(59 * 32 - 16, 8 * 32 + 13, 16, true, game));
        entities.add(new Pinchita(60 * 32 - 16, 8 * 32 + 13, 16, true, game));
        entities.add(new Pinchita(61 * 32 - 16, 8 * 32 + 13, 16, true, game));
        entities.add(new Pinchita(62 * 32 - 16, 8 * 32 + 13, 16, true, game));
        
        entities.add(new Mikeleton(76 * 32, 17 * 32, 160, 5000, game));
        
        entities.add(new Pinchita(91 * 32 - 16, 1 * 32 + 13, -10, true, game));        
    }
    
}
