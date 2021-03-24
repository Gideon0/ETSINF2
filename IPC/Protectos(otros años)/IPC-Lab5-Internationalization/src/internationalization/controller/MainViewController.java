package internationalization.controller;

import internationalization.Internationalization;
import internationalization.model.Blog;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mario
 */
public class MainViewController implements Initializable {

    private static final Locale SPANISH = new Locale("es", "ES");

    @FXML
    private Label status;
    @FXML
    private ToggleGroup buyOption;
    @FXML
    private RadioMenuItem amazonOption;
    @FXML
    private RadioMenuItem ebayOption;
    private ResourceBundle bundle;
    private String language;
    @FXML
    private ToggleGroup languageOption;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bundle = rb;
        language = bundle.getLocale().getLanguage();
    }

    @FXML
    private void exit(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle(bundle.getString("message.Confirmation"));
        alert.setHeaderText(bundle.getString("message.Exit.Header"));
        alert.setContentText(bundle.getString("message.Exit.Question"));

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
            alert.setTitle(bundle.getString("message.Confirmation"));
            alert.setHeaderText(bundle.getString("message.Buy.OK.Header"));
            alert.setContentText(bundle.getString("message.Buy.OK.Info") + ' ' + seller);
        } else {
            alert.setTitle(bundle.getString("message.Buy.Error"));
            alert.setHeaderText(bundle.getString("message.Buy.Error.Header") + ' ' + seller);
            alert.setContentText(bundle.getString("message.Buy.Error.Info"));
        }
        alert.showAndWait();
    }

    @FXML
    private void blogger(ActionEvent event) {
        List<String> choices = new ArrayList<>();
        for (Blog blog : Blog.values()) {
            choices.add(bundle.getString("message.Blog.Name") + ' ' + blog.getName());
        }

        ChoiceDialog<String> dialog = new ChoiceDialog<>(choices.get(0), choices);
        dialog.setTitle(bundle.getString("message.Blog.Selection"));
        dialog.setHeaderText(bundle.getString("message.Blog.Header"));
        dialog.setContentText(bundle.getString("message.Blog.Choose"));

        Optional<String> result = dialog.showAndWait();
// Traditional way to get the response value.
//        if (result.isPresent()) {
//            System.out.println(status.setText(bundle.getString("status.Blog.Visiting") + ' ' + result.get());
//        }

// The Java 8 way to get the response value (with lambda expression).
        result.ifPresent(choice -> status.setText(bundle.getString("status.Blog.Visiting") + ' ' + choice));

    }

    @FXML
    private void facebook(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle(bundle.getString("message.Facebook.InputName"));
        dialog.setHeaderText(bundle.getString("message.Facebook.Header"));
        dialog.setContentText(bundle.getString("message.Facebook.InputName"));

        Optional<String> result = dialog.showAndWait();
// Traditional way to get the response value.
//        if (result.isPresent()) {
//            status.setText(bundle.getString("status.Facebook.Sent") + ' '+ result.get());
//        }

// The Java 8 way to get the response value (with lambda expression).
        result.ifPresent(name -> status.setText(bundle.getString("status.Facebook.Sent") + ' ' + name));
    }

    @FXML
    private void google(ActionEvent event) {
    }

    @FXML
    private void spanish(ActionEvent event) {
        changeLanguage(SPANISH);
    }

    @FXML
    private void english(ActionEvent event) {
        changeLanguage(Locale.US);
    }
    
    private void changeLanguage(Locale locale) {
        if (language.equals(locale.getLanguage())) {
            return;
        }
        try {
            Internationalization.changeLanguage((Stage) status.getScene().getWindow(), locale);
        } catch (Exception ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
