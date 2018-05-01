/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slimeboi;

import java.net.URL;
import java.util.ResourceBundle;
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
 * @author Salahodin
 */
public class SettingsMenuController implements Initializable {

    @FXML
    private VBox fondo;
    @FXML
    private Button configB;
    @FXML
    private Button configA;
    
    public static boolean AorB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void setConfigA(ActionEvent event) throws Exception {
        AorB = true;
        
        Parent root;
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
        root = loader.load();
        Scene scene = new Scene(root);
            
        Stage stage = (Stage) fondo.getScene().getWindow();
            
        stage.setScene(scene);
    }

    @FXML
    private void setConfigB(ActionEvent event) throws Exception {
        AorB = false;
        
        Parent root;
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu.fxml"));
        root = loader.load();
        Scene scene = new Scene(root);
            
        Stage stage = (Stage) fondo.getScene().getWindow();
            
        stage.setScene(scene);
        
    }
    
}
