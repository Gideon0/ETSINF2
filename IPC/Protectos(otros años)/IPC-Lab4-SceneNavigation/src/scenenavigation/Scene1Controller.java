package scenenavigation;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Mario Gomez (margomez@dsic.upv.es)
 */
public class Scene1Controller {


    private Stage stage;
    private Scene scene2;

    @FXML
    private void next(ActionEvent event) throws IOException {
        if (stage == null) {
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        }
        if (scene2 == null) {
            Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
            scene2 = new Scene(root);
        }
        stage.setScene(scene2);
        stage.show();
    }
}
