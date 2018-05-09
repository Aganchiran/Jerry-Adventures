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
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import slimeboi.HUD.HUD;
import static slimeboi.SettingsMenu.AorB;
import slimeboi.commands.DefaultControls;
import slimeboi.entities.creatures.jerry.Jerry;
import slimeboi.graphics.Camera;
import slimeboi.input.KeyManager;
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
    @FXML
    private Button cagobutton;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cagobutton.setVisible(false);
        
        GraphicsContext gc = canvas.getGraphicsContext2D();
        jerry = new Jerry(500, 550, this);
        
        world = new Leaflands("music", "src/slimeboi/resources/GrassLands.txt", 40, 21, jerry, this);
        world.loadWorld();
        
        if(AorB)
            DefaultControls.LoadControlsA(this);
        else
            DefaultControls.LoadControlsB(this);
        
        camera = new Camera(this);
        HUD = new HUD(this);
        
        //GAME LOOP//
        new AnimationTimer()
        {
            @Override
            public void handle(long currentNanoTime)
            {
                gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

                world.render(gc);
                jerry.render(gc);
                try {
                    HUD.render(gc);
                } catch (IOException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(jerry.getHealth() == 0) {
                    cagobutton.setVisible(true);
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
        }.start();
        
    }    
    
    public void listenKeys(){
        canvas.getScene().addEventFilter(KeyEvent.KEY_PRESSED, KeyEvent -> {
            KeyManager.pressingKey(KeyEvent);
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

    @FXML
    private void onCago(ActionEvent event) throws Throwable {
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
}
