/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.worlds;

import slimeboi.Game;
import slimeboi.entities.tiles.NotSolidTestTile;
import slimeboi.entities.tiles.SolidTestTile;

/**
 *
 * @author Javier Pastor Pérez
 */
public class TestWorld extends World{
    
    public TestWorld(boolean solid, Game game) {
        super("NONE", "src/slimeboi/resources/GrassLands.txt", 40, 21, game);
        if(solid){
            tileSet.add(new SolidTestTile());//00
            tileSet.add(new SolidTestTile());//01
            tileSet.add(new SolidTestTile());//02
            tileSet.add(new SolidTestTile());//03
            tileSet.add(new SolidTestTile());//04
            tileSet.add(new SolidTestTile());//05
            tileSet.add(new SolidTestTile());//06
            tileSet.add(new SolidTestTile());//07
            tileSet.add(new SolidTestTile());//08
            tileSet.add(new SolidTestTile());//09
            tileSet.add(new SolidTestTile());//10
            tileSet.add(new SolidTestTile());//11
            tileSet.add(new SolidTestTile());//12
            tileSet.add(new SolidTestTile());//13
            tileSet.add(new SolidTestTile());//14
            tileSet.add(new SolidTestTile());//15
            tileSet.add(new SolidTestTile());//16
        }else{
            tileSet.add(new NotSolidTestTile());//00
            tileSet.add(new NotSolidTestTile());//01
            tileSet.add(new NotSolidTestTile());//02
            tileSet.add(new NotSolidTestTile());//03
            tileSet.add(new NotSolidTestTile());//04
            tileSet.add(new NotSolidTestTile());//05
            tileSet.add(new NotSolidTestTile());//06
            tileSet.add(new NotSolidTestTile());//07
            tileSet.add(new NotSolidTestTile());//08
            tileSet.add(new NotSolidTestTile());//09
            tileSet.add(new NotSolidTestTile());//10
            tileSet.add(new NotSolidTestTile());//11
            tileSet.add(new NotSolidTestTile());//12
            tileSet.add(new NotSolidTestTile());//13
            tileSet.add(new NotSolidTestTile());//14
            tileSet.add(new NotSolidTestTile());//15
            tileSet.add(new NotSolidTestTile());//16
        }
        

    }

    @Override
    public void initializeWorld() {
    }
    
}
