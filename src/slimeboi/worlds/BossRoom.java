/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.worlds;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import slimeboi.Game;
import slimeboi.entities.creatures.enemies.Bollito;
import slimeboi.entities.tiles.CaveTile;
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

/**
 *
 * @author Javier Pastor Pérez
 */
public class BossRoom extends World{
    private Bollito bollito;
    public BossRoom(Game game) {
        super("NONE", "src/slimeboi/resources/BossRoom.txt", 34, 25, game);
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
        game.getCamera().leftOffset = 32;
        game.getCamera().rightOffset = 32;
        game.getCamera().downOffset = 64;
        
        new Timeline(new KeyFrame(Duration.millis(3000), ae -> {
            bollito = new Bollito(300, -200, 2000, game);
            bollito.setYIncrement(10);
            entities.add(bollito);
            
            new Timeline(new KeyFrame(Duration.millis(2000), ea -> {
                game.getCamera().setFollowJerry(false);
                game.getCamera().zoom(2);
                game.getCamera().setYPos(((int) game.getCamera().getYPos()) + 150);
                
                
                new Timeline(new KeyFrame(Duration.millis(30), eae -> {
                    game.paused = true;
                })).play();
                
                new Timeline(new KeyFrame(Duration.millis(2000), aea -> {
                    game.getCamera().setFollowJerry(true);
                    game.getCamera().zoom(1);
                    game.paused = false;
                })).play();
            })).play();
        })).play();
        
        
    }
    
}
