package internationalization;

import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author mario
 */
public class Internationalization extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Locale locale = Locale.getDefault();
        changeLanguage(stage, locale);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public static void changeLanguage(Stage stage, Locale locale) throws Exception {
        // Cargar el bundle (p.e., strings_es_ES.properties)
        ResourceBundle bundle = ResourceBundle.getBundle("internationalization.bundles.strings", locale);
        // Pasar el bundle al FXMLLoader
        Parent root = FXMLLoader.load(Internationalization.class.getResource("view/MainView.fxml"), bundle);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
