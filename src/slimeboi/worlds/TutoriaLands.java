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
import slimeboi.tiles.EarthCenterCenter;
import slimeboi.tiles.EarthCenterLeft;
import slimeboi.tiles.EarthCenterRight;
import slimeboi.tiles.EarthDownCenter;
import slimeboi.tiles.EarthDownLeft;
import slimeboi.tiles.EarthDownRight;
import slimeboi.tiles.EarthHorizontalCenter;
import slimeboi.tiles.EarthHorizontalLeft;
import slimeboi.tiles.EarthHorizontalRight;
import slimeboi.tiles.EarthSingleBlock;
import slimeboi.tiles.EarthUpCenter;
import slimeboi.tiles.EarthUpLeft;
import slimeboi.tiles.EarthUpRight;
import slimeboi.tiles.EarthVerticalCenter;
import slimeboi.tiles.EarthVerticalDown;
import slimeboi.tiles.EarthVerticalUp;
import slimeboi.tiles.SkyTile;

/**
 *
 * @author Javier Pastor Pérez
 */
public class TutoriaLands extends World{
    
    public TutoriaLands(Game game) {
        super("src/slimeboi/resources/TemmieVillage.mp3", "src/slimeboi/resources/TutoriaLands.txt", 78, 28, game);
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
        entities.add(new Victor(77 * 32, 4 * 32, 64, 64, game));
    }
    
}
