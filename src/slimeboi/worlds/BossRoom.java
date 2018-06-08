/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.worlds;

import java.nio.file.Paths;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import slimeboi.Game;
import slimeboi.entities.creatures.enemies.Bollito;
import slimeboi.tiles.CaveTile;
import slimeboi.tiles.RockCenterCenter;
import slimeboi.tiles.RockCenterLeft;
import slimeboi.tiles.RockCenterRight;
import slimeboi.tiles.RockDownCenter;
import slimeboi.tiles.RockDownLeft;
import slimeboi.tiles.RockDownRight;
import slimeboi.tiles.RockHorizontalCenter;
import slimeboi.tiles.RockHorizontalLeft;
import slimeboi.tiles.RockHorizontalRight;
import slimeboi.tiles.RockSingleBlock;
import slimeboi.tiles.RockUpCenter;
import slimeboi.tiles.RockUpLeft;
import slimeboi.tiles.RockUpRight;
import slimeboi.tiles.RockVerticalCenter;
import slimeboi.tiles.RockVerticalDown;
import slimeboi.tiles.RockVerticalUp;
import slimeboi.graphics.AssetsViejo;

/**
 *
 * @author Javier Pastor Pérez
 */
public class BossRoom extends World{
    private boolean firstTime = true;
    private Bollito bollito;
    private WritableImage gameSnapshot;
    private WritableImage shakeSnapshot;
    
    private int ShakeXPos = 0;
    private final Timeline shake;
    private double changeShakeSign = 1;
    
    private final AudioClip stomp;
    
    private final Timeline TL0;
    private final Timeline TL1;
    private final Timeline TL2;
    private final Timeline TL3;
    private final Timeline TL4;
    private final Timeline TL5;
    private final Timeline TL6;
    private final Timeline TL7;
    private final Timeline bollitoTitle;
    private final Timeline end;
    
    public BossRoom(Game game) {
        super("src/slimeboi/resources/BossTheme.mp3", "src/slimeboi/resources/BossRoom.txt", 34, 25, game);
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
        
        shake = new Timeline(new KeyFrame(Duration.millis(20), ae -> {
            changeShakeSign *= -1;
            ShakeXPos += Math.random() * 8 * changeShakeSign;
            game.getCanvas().getGraphicsContext2D().drawImage(shakeSnapshot, ShakeXPos, 0);
        }));
        shake.setCycleCount(5);
        
        
        stomp = new AudioClip(Paths.get("src/slimeboi/resources/Stomp.mp3").toUri().toString());
        stomp.setVolume(0.4);
        
        
        
        bollitoTitle = new Timeline(new KeyFrame(Duration.millis(300), BOLLITO -> {
            hitLetter();
        })); 

        bollitoTitle.setCycleCount(7);
        
        TL0 = new Timeline(new KeyFrame(Duration.millis(3000), bollitoFall -> {
            bollito = new Bollito(300, -200, 2000, game);
            bollito.setYIncrement(10);
            entities.add(bollito);
        }));
        TL1 = new Timeline(new KeyFrame(Duration.millis(5000), Zoom -> {
            gameSnapshot = game.getCanvas().snapshot(new SnapshotParameters(), null);
            game.getCamera().setFollowJerry(false);
            game.getCamera().zoom(2);
            game.getCamera().setYPos(((int) game.getCamera().getYPos()) + 150);
            game.getWorld().render(game.getCanvas().getGraphicsContext2D());
            game.getCanvas().getGraphicsContext2D().drawImage(gameSnapshot, 0, -150);


            game.paused = true;
                
        }));
        
        TL2 = new Timeline(new KeyFrame(Duration.millis(6200), the -> {
            stomp.setVolume(0.4);
            hitLetter();
        }));
        
        TL3 = new Timeline(new KeyFrame(Duration.millis(6600), big1 -> {
            stomp.setVolume(0.4);
            hitLetter();
        }));
        
        TL4 = new Timeline(new KeyFrame(Duration.millis(7600), big2 -> {
            stomp.setVolume(0.65);
            hitLetter();
        }));    
        
        TL5 = new Timeline(new KeyFrame(Duration.millis(8600), big3 -> {
            stomp.setVolume(0.75);
            hitLetter();
        })); 
                            
        TL6 = new Timeline(new KeyFrame(Duration.millis(9600), big4 -> {
            stomp.setVolume(1);
            hitLetter();
        }));
                                
                                
        TL7 = new Timeline(new KeyFrame(Duration.millis(10600), w84Big -> {
            bollitoTitle.play();
        }));
          
        end = new Timeline(new KeyFrame(Duration.millis(13700), aea -> {
            game.getCamera().setFollowJerry(true);
            game.getCamera().zoom(1);
            game.paused = false;
            bgMusic.play();
            playingKinematic = false;
        }));
            
        
        
        
        
        
        
        
        //initializeWorld();
        
        
        
    }

    @Override
    public void initializeWorld() {
        playingKinematic = true;
        game.getCamera().leftOffset = 32;
        game.getCamera().rightOffset = 32;
        game.getCamera().downOffset = 64;
        AssetsViejo.theBigBollito.setCurrentAnimationFrame(0);
        
        TL0.stop();
        TL0.play();

        if(firstTime){
            
            TL1.stop();
            TL1.play();

            TL2.stop();
            TL2.play();

            TL3.stop();
            TL3.play();

            TL4.stop();
            TL4.play();

            TL5.stop();
            TL5.play();

            TL6.stop();
            TL6.play();

            TL7.stop();
            TL7.play();

            end.stop();
            end.play();
        }else{
            playingKinematic = false;
            bgMusic.play();
        }
        
        firstTime = false;
    }
    
    
    private void hitLetter(){
        game.getCanvas().getGraphicsContext2D().drawImage(gameSnapshot, 0, -150);
        game.getCanvas().getGraphicsContext2D().drawImage(AssetsViejo.theBigBollito.nextFrame(), 280, 180);

        game.getCamera().zoom(1);
        shakeSnapshot = game.getCanvas().snapshot(new SnapshotParameters(), null);
        game.getCamera().zoom(2);
        shake.play();
        stomp.play();
    }
}
