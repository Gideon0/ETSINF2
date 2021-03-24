package controllercommunication;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Mario Gomez (margomez@dsic.upv.es)
 */
public class Scene1Controller implements Initializable {

    @FXML
    private VBox mainPane;
    @FXML
    private TextField message;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML
    private void newWindow(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene2.fxml"));
        Parent root = loader.load();
        Scene2Controller controller = loader.getController();
        controller.setMessage(message.getText());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.showAndWait();
        Color color = controller.getColor();
        if (color != null) {
            mainPane.setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
        }

    }

}
