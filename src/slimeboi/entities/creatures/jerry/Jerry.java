/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi.entities.creatures.jerry;

import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.BoundingBox;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;
import slimeboi.Game;
import slimeboi.commands.ControlLoader;
import static slimeboi.commands.DefaultControls.configuration;
import slimeboi.entities.creatures.Creature;
import slimeboi.entities.creatures.jerry.ammo.Ammo;
import slimeboi.entities.creatures.jerry.ammo.NoAmmo;
import slimeboi.graphics.AssetsFat;
import slimeboi.graphics.AssetsJerry;
import slimeboi.graphics.AssetsJerryBlink;
import slimeboi.graphics.CustomAnimation;
import slimeboi.input.KeyManager;

/**
 *
 * @author Javier Pastor Pérez
 */
public class Jerry extends Creature{
    
    private boolean lastStateOnAir = true;
    private double lastYIncrement = 0;
    private boolean invulnerable = false;
    private int numberOfFrameInASecond = 0;
    //private Timer timer;
    //private Timer timer2;
    
    private final GraphicsContext gc;
    private Ammo ammo;
        
    private final BoundingBox biteHitBox = new BoundingBox(5, 14, 55, 32);
    
    private final int JERRY_DEFAULT_SPEED = 1;
    public final AssetsJerry ASSETS_NORMAL;
    public final AssetsJerryBlink ASSETS_BLINK;
    public final AssetsFat ASSETS_FAT;
               
    public Jerry(double xPos, double yPos, Game game){
        super(xPos, yPos, 23, 16, 21, 30, 1, 2, new AssetsJerry(), game);
        ASSETS_NORMAL = (AssetsJerry) assets;
        ASSETS_BLINK = new AssetsJerryBlink();
        ASSETS_FAT = new AssetsFat();
        gc = game.getCanvas().getGraphicsContext2D();
        ammo = new NoAmmo(game);
        super.speed = JERRY_DEFAULT_SPEED;
    }
    
    @Override
    public void updateCreatureStateSpecific(){
        ammo.render(gc);
        if(hasAmmo){
            assets = ASSETS_FAT;
            
            if(numberOfFrameInASecond % 2 != 0){
                speed = 0;
            }else{
                speed = JERRY_DEFAULT_SPEED;
            }
        }else{
            assets = ASSETS_NORMAL;
            speed = JERRY_DEFAULT_SPEED;
        }
        
        if(health <= 0){
            invulnerable = true;
            xIncrement = 0;
            state = STATE_FREEZED;
        }
        
        if(lastStateOnAir && !isOnAir()){
            
            if(!isBiting()){
                if(lastYIncrement > 2.5) land(((AssetsJerry)assets).endJumpRight, ((AssetsJerry)assets).endJumpLeft);
            }else{
                land(((AssetsJerry)assets).endBiteRight, ((AssetsJerry)assets).endBiteLeft);
                
                new Timeline(new KeyFrame(Duration.millis(currentAnimation.getDurationInMilis() + 10), ea -> {
                    if(facingRight()){
                        currentAnimation = ((AssetsJerry) assets).noEatRight;
                    }else{
                        currentAnimation = ((AssetsJerry) assets).noEatLeft;
                    }
                    freeze(currentAnimation.getDurationInMilis());
                })).play();
            }
            
        } 
        
        if(KeyManager.checkKey(KeyCode.SPACE.getName())){

            ControlLoader.doAction(2); //2 es Espacio
        }
        if(KeyManager.checkKey(KeyCode.Z.getName())){
            
            ControlLoader.doAction(3); //3 es Z (o la que acabe siendo)
        }
        if(KeyManager.checkKey(KeyCode.RIGHT.getName())){
            
            ControlLoader.doAction(0); // 0 es Derecha
        }else if(KeyManager.checkKey(KeyCode.LEFT.getName())){           
            
            ControlLoader.doAction(1); // 1 es Izquierda
        }else {
            state.idle();
        }
        
        
        lastStateOnAir = isOnAir();
        lastYIncrement = yIncrement;
    }
    
    @Override
    public void render(GraphicsContext gc){
        numberOfFrameInASecond = (numberOfFrameInASecond + 1) % 60;

        if(invulnerable){
            if(numberOfFrameInASecond % 15 > 5){
                gc.drawImage(currentAnimation.nextFrame(), xPos  - game.getCamera().getXPos(), yPos - game.getCamera().getYPos());
            }
        }else{
            gc.drawImage(currentAnimation.nextFrame(), xPos  - game.getCamera().getXPos(), yPos - game.getCamera().getYPos());
        }
    }
    
    @Override
    public void hurt(){
        
        if(!invulnerable && health > 0){
            //assets = ASSETS_BLINK;
            health--;
            
            if(facingRight()){
                currentAnimation = ((AssetsJerry) assets).hurtRight;
                notFreezedState = STATE_RIGHT_ON_AIR;
            }else{
                currentAnimation = ((AssetsJerry) assets).hurtLeft;
                notFreezedState = STATE_LEFT_ON_AIR;
            }

            xIncrement = -xIncrement;
            yIncrement = -2;
            
            freeze(400);
            makeInvulnerable();
            
        }
    }
    
    public void makeInvulnerable(){
        invulnerable = true;        
        
        new Timeline(new KeyFrame(Duration.millis(3000), ae -> {
            invulnerable = false;
            //assets = ASSETS_NORMAL;
            //timer2.cancel();
        })).play();
        
        /*timer2 = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                invulnerable = false;
                assets = ASSETS_NORMAL;
                timer2.cancel();
            }
        };
        
        timer2.schedule(task, 3000);*/
    }
    
    private void land(CustomAnimation rightAnim, CustomAnimation leftAnim){
        
        if(facingRight()) currentAnimation = rightAnim;
        else currentAnimation = leftAnim;
        
        
        xIncrement = 0;
        freeze(currentAnimation.getDurationInMilis());
        
    }
    
    public BoundingBox getBiteBounds(){
        return new BoundingBox(xPos + biteHitBox.getMinX(), yPos + biteHitBox.getMinY(), biteHitBox.getWidth(), biteHitBox.getHeight());
    }
    
    public boolean isBiting(){
        return currentAnimation == ((AssetsJerry)assets).biteLeft || currentAnimation == ((AssetsJerry)assets).biteRight;
    }
    
    public boolean isInvulnerable(){
        return invulnerable;
    }
    
    public Ammo getAmmo(){
        return ammo;
    }
    public void setAmmo(Ammo newAmmo) {
        ammo = newAmmo;
    }

    
    
    
    
    
} 
