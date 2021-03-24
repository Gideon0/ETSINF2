package personmanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Mario Gomez (margomez@dsic.upv.es)
 */
public class PersonManagerApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("PersonManagerView.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Person Manager using TableView");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
