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
public class SlimeMenuController implements Initializable {

    @FXML
    private Button startButton;
    @FXML
    private Button quitButton;
    @FXML
    private VBox fondo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        fondo.setId("vbox-custom");
    }

    @FXML
    private void startPulsar(ActionEvent event) {
       
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("SlimeLevel1.fxml"));
            Scene scene = new Scene(root);
            
            Stage stage = (Stage) fondo.getScene().getWindow();
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(SlimeMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    @FXML
    private void quitPulsar(ActionEvent event) {
       System.exit(0);
    }
    
}
