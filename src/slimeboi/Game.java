/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import slimeboi.HUD.HUD;
import static slimeboi.SettingsMenu.AorB;
import slimeboi.commands.DefaultControls;
import slimeboi.entities.creatures.jerry.Jerry;
import slimeboi.graphics.AssetsMikeleton;
import slimeboi.graphics.AssetsViejo;
import slimeboi.graphics.Camera;
import slimeboi.input.KeyManager;
import slimeboi.worlds.Cave;
import slimeboi.worlds.Leaflands;
import slimeboi.worlds.World;

/**
 * FXML Controller class
 *
 * @author sabehas
 */
public class Game implements Initializable {
    

    @FXML
    private Canvas canvas;
    
    private Camera camera;
    private World world;
    private HUD HUD;
    public Jerry jerry;
    private boolean paused = false;
    private URL url;
    private ResourceBundle rb;
    private AnimationTimer gameLoop;
    
    boolean gover;
    
    @FXML
    private Button cagobutton;
    @FXML
    private Button retryButton;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.url = url;
        this.rb = rb;
        
        cagobutton.setVisible(false);
        retryButton.setVisible(false);
        
        GraphicsContext gc = canvas.getGraphicsContext2D();
        jerry = new Jerry(50, 10, this);
        
        
        world = new Cave("src/slimeboi/resources/Bonetrousle.mp3", 40, 21, this);
        world.loadWorld();
        world.addEntityAtFront(jerry);
        
        if(AorB)
            DefaultControls.LoadControlsA(this);
        else
            DefaultControls.LoadControlsB(this);
        
        camera = new Camera(this);
        HUD = new HUD(this);
        
        
        
        //GAME LOOP//
        gameLoop = new AnimationTimer()
        {
            @Override
            public void handle(long currentNanoTime)
            {
                
                if(!paused){
                    gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                    
                    world.render(gc);
                    /*//jerry.updateState();*/
                    
                    
                    HUD.render(gc);
                    
                    
                    
                    
                    
                    if(jerry.getHealth() == 0) {
                        
                        gc.setFill(Color.rgb(0, 0, 0, 0.5));
                        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
                        gover = true;
                        cagobutton.setVisible(true);
                        retryButton.setVisible(true);
                        //jerry.cancelTimers();
                        /*Parent root;
                        try {
                            root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
                            Scene scene = new Scene(root);
                            Stage stage = (Stage) getCanvas().getScene().getWindow();

                            scene.getStylesheets().add("slimeboi/slime.css");

                            stage.setScene(scene);
                            stage.show();
                            stage.setResizable(false);
                        } catch (IOException ex) {
                            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                        }*/

                     }
                }
            }
        };
        gameLoop.start();
        
    }    
    
    public void listenKeys(){
        canvas.getScene().addEventFilter(KeyEvent.KEY_PRESSED, KeyEvent -> {
            KeyManager.pressingKey(KeyEvent);
            if(!gover)
            if(KeyEvent.getCode() == KeyCode.ESCAPE){
                System.out.println(paused);
                pauseUnpause();
            }
        });
        
        canvas.getScene().addEventFilter(KeyEvent.KEY_RELEASED, KeyEvent -> {
            KeyManager.releasingKey(KeyEvent);
            
        });
    }
    
    public Canvas getCanvas(){
        return canvas;
    }
    
    public Camera getCamera(){
        return camera;
    }
    public World getWorld(){
        return world;
    }
    
    public void setWorld(World wardo){
        world = wardo;
    }

    @FXML
    private void onCago(ActionEvent event) throws Throwable {
        world.apocalypse();
        Parent root;
        
        try {
            root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) getCanvas().getScene().getWindow();

            scene.getStylesheets().add("slimeboi/slime.css");

            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void retry(ActionEvent event) {
        paused = true;
        pauseUnpause();
        gover = false;
        world.resetWorld();
        jerry.resetJerry();
        world.addEntityAtFront(jerry);
        //gameLoop.stop();
        //world.killAllEntities();
        //initialize(url, rb);
    }
    
    public void pauseUnpause(){
        paused = !paused;
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.rgb(0, 0, 0, 0.5));
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        cagobutton.setVisible(paused);
        retryButton.setVisible(paused);
        
    }
    
    public boolean isPaused(){
        return paused;
    }
}
