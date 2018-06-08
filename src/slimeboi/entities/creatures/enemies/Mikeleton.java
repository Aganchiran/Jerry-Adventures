/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures.enemies;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.BoundingBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import slimeboi.Game;
import slimeboi.entities.creatures.ammo.BoneAmmo;
import slimeboi.entities.creatures.ammo.JackboneFive;
import slimeboi.graphics.AssetsMikeleton;
import slimeboi.graphics.CustomAnimation;

/**
 *
 * @author Javier Pastor Pérez
 */
public class Mikeleton extends Enemy{
    
    private long count = 0;
    private final int distance;
    private boolean dancing = false;
    private final Timeline boneLoop;
    private boolean lastBoneWentRight = true;
    private final CustomAnimation[] jackboneFive = new CustomAnimation[5];
    private int jackboneCount = 0;
    
    
    //private final JackboneFive jackPrueba = new JackboneFive(100, 100, 0, AssetsMikeleton.jackie, game);
    
    

    public Mikeleton(double xPos, double yPos, int distance, long boneLoopTime, Game game) {
        super(xPos, yPos, 15, 56, 24, 4, 0.5, 1, new AssetsMikeleton(),new BoneAmmo(game), game);
        this.distance = distance;
        
        jackboneFive[0] = AssetsMikeleton.jackie;
        jackboneFive[1] = AssetsMikeleton.jermaine;
        jackboneFive[2] = AssetsMikeleton.marlon;
        jackboneFive[3] = AssetsMikeleton.randy;
        jackboneFive[4] = AssetsMikeleton.tito;
        
        
        
        //boneAtack();
        /*
        Timeline chargeLoop = new Timeline(new KeyFrame(Duration.millis(5200), ae -> {
            assets.right.setCurrentAnimationFrame(0);
            assets.left.setCurrentAnimationFrame(0);
        }));
        
        chargeLoop.setCycleCount(Animation.INDEFINITE);
        chargeLoop.play();*/
        
        boneLoop = new Timeline(new KeyFrame(Duration.millis(boneLoopTime), ea -> {
            
            
            boneAtack();
            
        }));
        
        boneLoop.setCycleCount(Animation.INDEFINITE);
        boneLoop.play();
        
        /*Timer timer = new Timer();
        try {
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Hola");
                    thunderAtack();

                }
            };

            timer.scheduleAtFixedRate(task, 10, 3000);
        } finally {
            //timer.cancel();
        }*/
    }

    @Override
    public void updateCreatureStateSpecific() {
        if(game.getCamera().getXPos() < xPos + 100 && game.getCamera().getXPos() + game.getCanvas().getWidth() > xPos - 100){
        
            if(isEated()){
                game.jerry.setAmmo(ammo);
                game.jerry.hasAmmo = true;
                kill();
            }

            if(!game.jerry.isBiting() && hitsJerry()){
                game.jerry.hurt();
            }

            if(health == 0){
                kill();
            }
        }
            if(!dancing){
                if(state == STATE_RIGHT){
                    count++;
                    if(count == distance) state = STATE_LEFT;
                }else{
                    count--;
                    if(count == 0) state = STATE_RIGHT;
                }

                state.move();
            }else{
                state.idle();
                
                if(game.getCamera().getXPos() < xPos + 100 && game.getCamera().getXPos() + game.getCanvas().getWidth() > xPos - 100){
                    if(currentAnimation.getCurrentAnimationFrame() == 1 && lastBoneWentRight){
                        JackboneFive jackbone = new JackboneFive(xPos - 10, yPos, -3, jackboneFive[4 - jackboneCount], game);
                        game.getWorld().addEntityAtFront(jackbone);

                        lastBoneWentRight = false;
                        jackboneCount = (jackboneCount + 1) % 5;
                    }else if(currentAnimation.getCurrentAnimationFrame() == 3 && !lastBoneWentRight){
                        JackboneFive jackbone = new JackboneFive(xPos + 10, yPos, 3, jackboneFive[4 -jackboneCount], game);
                        game.getWorld().addEntityAtFront(jackbone);

                        lastBoneWentRight = true;
                        jackboneCount = (jackboneCount + 1) % 5;
                    }
                }
            }
        
    }
    
    
    private void boneAtack(){
        dancing = true;
        
        new Timeline(new KeyFrame(Duration.millis(2000), ae -> {
            assets.idleRight.setCurrentAnimationFrame(0);
            assets.idleLeft.setCurrentAnimationFrame(0);
            lastBoneWentRight = true;
            dancing = false;

        })).play();
    }

    
    @Override
    public void kill(){
        game.getWorld().killEntity(this);
        boneLoop.stop();
    }
    
    @Override
    public boolean isEated(){
        BoundingBox eatDetectionHitbox = new BoundingBox(xPos + 15,yPos + 4, 33, 20);
        //game.getCanvas().getGraphicsContext2D().setFill(Color.rgb(255, 0, 0, 0.5));
        //game.getCanvas().getGraphicsContext2D().fillRect(eatDetectionHitbox.getMinX() - game.getCamera().getXPos(), eatDetectionHitbox.getMinY() - game.getCamera().getYPos(), eatDetectionHitbox.getWidth(), eatDetectionHitbox.getHeight());
        return game.jerry.getBiteBounds().contains(eatDetectionHitbox) && game.jerry.isBiting();

    }
}
