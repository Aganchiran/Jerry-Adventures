/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sabehas
 */
public class GameOverController implements Initializable {

    @FXML
    private Button retryButton;
    @FXML
    private Button returnMenuButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void retry(ActionEvent event) {
        
    }

    @FXML
    private void returnMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        
        Scene scene = new Scene(root);
        Stage stage = (Stage) retryButton.getScene().getWindow();
        
        scene.getStylesheets().add("slimeboi/slime.css");
        
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }
    
}
