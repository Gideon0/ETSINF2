package events;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;

public class EventHandlerSample3Controller {

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Label label;

    private static final DropShadow shadow = new DropShadow();

    @FXML
    void buttonClicked(ActionEvent event) {
        String id = ((Node) event.getSource()).getId();
        if (id.equals("B1")) {
            label.setText("Button 1");
        } else {
            label.setText("Button 2");
        }
    }

    @FXML
    void mouseEntered(MouseEvent event) {
        button2.setEffect(shadow);
    }

    @FXML
    void mouseExited(MouseEvent event) {
        button2.setEffect(null);
    }

}
