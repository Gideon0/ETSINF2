package controllercommunication;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Mario Gomez (margomez@dsic.upv.es)
 */
public class Scene2Controller {
    private Color color;

    @FXML
    private ColorPicker colorPicker;
    @FXML
    private TextField message;

    @FXML
    private void confirm(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        color = colorPicker.getValue();
        stage.close(); // it's the same as stage.hide()
    }

    @FXML
    private void cancel(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        color = null;
        stage.close(); // it's the same as stage.hide()
    }

    public Color getColor() {
        return color;
    }

    void setMessage(String text) {
        message.setText(text);
    }
    
    
}
