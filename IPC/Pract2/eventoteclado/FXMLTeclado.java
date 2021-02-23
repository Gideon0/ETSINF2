/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventoteclado;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

/**
 * FXML Controller class
 *
 * @author ydavpacat
 */
public class FXMLTeclado implements Initializable {

    @FXML
    private GridPane gridP;
    @FXML
    private Circle circulo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void keyPressed(InputMethodEvent event) {
    }

    @FXML
    private void initialize(KeyEvent event) {
        System.out.println(event.getCode());
        
        
        int fila = gridP.getRowIndex(circulo);
        int columna = gridP.getColumnIndex(circulo);
        
        if (event.getCode().equals(KeyCode.RIGHT) && columna  < 4){
            gridP.getChildren().remove(circulo);
            gridP.add(circulo, columna + 1, fila);
        }
        
        if (event.getCode().equals(KeyCode.LEFT) && columna  > 0){
            gridP.getChildren().remove(circulo);
            gridP.add(circulo, columna - 1, fila);
        }
        
        
        if (event.getCode().equals(KeyCode.UP) && fila > 0){
           gridP.getChildren().remove(circulo);
            gridP.add(circulo, columna, fila - 1 );
        }
        
        if (event.getCode().equals(KeyCode.DOWN) && fila < 4){
            gridP.getChildren().remove(circulo);
            gridP.add(circulo, columna, fila + 1);
        
        }
    System.out.println("("+fila+" "+ columna+")");

        
    }
    
}
