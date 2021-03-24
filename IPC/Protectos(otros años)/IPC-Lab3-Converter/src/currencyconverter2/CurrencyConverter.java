package currencyconverter2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main class of the CurrencyConverter application. This is a simple JavaFX application implementing basic currency
 * conversion functionality and using fxml to specify the View.
 * This app is intended as a demo for educational purposes. It shows some examples of interaction between the view and
 * the controller, using a few JavaFX controls defined in fxml, and a controller class containing various event handlers
 * and listeners to be executed in response to interface events.
 * This app makes use of fxml has been priorited but some initialization is also done in the controller to ensure the
 * initial state is set properly (to its default values).
 */
public class CurrencyConverter extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));
        primaryStage.setTitle("Currency Converter");
        primaryStage.setScene(new Scene(root, 250, 250));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
