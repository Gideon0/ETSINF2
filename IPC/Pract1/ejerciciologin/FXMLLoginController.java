/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciologin;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author ydavpacat
 */
public class FXMLLoginController implements Initializable {

    @FXML
    private TextField userName;
    @FXML
    private Button buttonIni;
    @FXML
    private Text mensajeIni;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void inicarpulsar(ActionEvent event) {
        mensajeIni.setText("Bienvenido " + userName.getText());
    }
    
}
