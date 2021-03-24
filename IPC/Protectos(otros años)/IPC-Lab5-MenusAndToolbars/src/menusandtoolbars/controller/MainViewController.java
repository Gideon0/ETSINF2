package menusandtoolbars.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToggleGroup;
import menusandtoolbars.model.Blog;

/**
 * FXML Controller class
 *
 * @author mario
 */
public class MainViewController implements Initializable {

    @FXML
    private Label status;
    @FXML
    private ToggleGroup buyOption;
    @FXML
    private RadioMenuItem amazonOption;
    @FXML
    private RadioMenuItem ebayOption;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void exit(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText("Vas a salir del programa");
        alert.setContentText("¿Seguro que quieres salir?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            // ... user chose OK
            status.getScene().getWindow().hide();
        } else {
            // ... user chose CANCEL or closed the dialog
        }
    }

    @FXML
    private void amazon(ActionEvent event) {
        buy("Amazon");
    }

    @FXML
    private void ebay(ActionEvent event) {
        buy("Ebay");
    }

    private void buy(String seller) {
        String option = ((RadioMenuItem) buyOption.getSelectedToggle()).getId();
        Alert alert = new Alert(AlertType.INFORMATION);
        if (option.equals(seller.toLowerCase())) {
            alert.setTitle("Confirmación");
            alert.setHeaderText("Compra realizada correctamente");
            alert.setContentText("Has comprado en " + seller);
        } else {
            alert.setTitle("Error en la selección");
            alert.setHeaderText("No puede comprar en " + seller);
            alert.setContentText("Por favor, cambie la selección actual en el menú Opciones");
        }
        alert.showAndWait();
    }

    @FXML
    private void blogger(ActionEvent event) {
        List<String> choices = new ArrayList<>();
        for (Blog blog : Blog.values()) {
            choices.add("El blog de " + blog.getName());
        }

        ChoiceDialog<String> dialog = new ChoiceDialog<>(choices.get(0), choices);
        dialog.setTitle("Selecciona un blog");
        dialog.setHeaderText("¿Qué blog quieres visitar?");
        dialog.setContentText("Elige");

        Optional<String> result = dialog.showAndWait();
// Traditional way to get the response value.
//        if (result.isPresent()) {
//            System.out.println(status.setText("Visitando " + result.get());
//        }

// The Java 8 way to get the response value (with lambda expression).
        result.ifPresent(choice -> status.setText("Visitando " + choice));

    }

    @FXML
    private void facebook(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Introduce tu nombre");
        dialog.setHeaderText("¿Con qué usuario quieres escribir en Facebook?");
        dialog.setContentText("Introduce tu nombre");

        Optional<String> result = dialog.showAndWait();
// Traditional way to get the response value.
//        if (result.isPresent()) {
//            status.setText("Mensaje enviado como "+ result.get());
//        }

// The Java 8 way to get the response value (with lambda expression).
        result.ifPresent(name -> status.setText("Mensaje enviado como " + name));
    }

    @FXML
    private void google(ActionEvent event) {
    }

}
