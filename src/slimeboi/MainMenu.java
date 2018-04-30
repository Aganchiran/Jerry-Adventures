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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sabehas
 */
public class MainMenu implements Initializable {

    @FXML
    private Button startButton;
    @FXML
    private Button quitButton;
    @FXML
    private VBox fondo;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fondo.setId("vbox-custom");
        startButton.setId("start-custom");
        quitButton.setId("quit-custom");
    }

    @FXML
    private void startPulsar(ActionEvent event) {
       
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Game.fxml"));
            root = loader.load();
            Scene scene = new Scene(root);
            
            Stage stage = (Stage) fondo.getScene().getWindow();
            
            stage.setScene(scene);
            
            Game level = loader.getController();
            level.listenKeys();
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @FXML
    private void quitPulsar(ActionEvent event) {
       System.exit(0);
    }
    
}
