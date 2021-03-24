package windownavigation;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Mario Gomez (margomez@dsic.upv.es)
 */
public class Scene1Controller implements Initializable {

    @FXML
    private RadioButton nonModalOption;
    @FXML
    private RadioButton windowModalOption;
    @FXML
    private RadioButton appModalOption;
    @FXML
    private ToggleGroup modalitySelection;

    private int counter = 2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nonModalOption.setUserData(Modality.NONE);
        windowModalOption.setUserData(Modality.WINDOW_MODAL);
        appModalOption.setUserData(Modality.APPLICATION_MODAL);
    }

    @FXML
    private void newWindow(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setTitle("Stage " + counter++);

        Modality modality = (Modality) modalitySelection.getSelectedToggle().getUserData();
        stage.initModality(modality);

        if (modality.equals(Modality.WINDOW_MODAL)) {
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.initOwner(currentStage);
        }

        Parent root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
