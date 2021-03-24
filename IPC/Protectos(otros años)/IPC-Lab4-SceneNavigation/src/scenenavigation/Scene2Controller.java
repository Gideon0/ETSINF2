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
public class Scene2Controller {

    private Stage stage;
    private Scene scene1;
    private Scene scene3;

    @FXML
    private void back(ActionEvent event) throws IOException {
        if (stage == null) {
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        }
        if (scene1 == null) {
            Parent root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
            scene1 = new Scene(root);
        }
        stage.setScene(scene1);
        stage.show();
    }

    @FXML
    private void next(ActionEvent event) throws IOException {
        if (stage == null) {
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        }
        if (scene3 == null) {
            Parent root = FXMLLoader.load(getClass().getResource("Scene3.fxml"));
            scene3 = new Scene(root);
        }
        stage.setScene(scene3);
        stage.show();
    }
}
