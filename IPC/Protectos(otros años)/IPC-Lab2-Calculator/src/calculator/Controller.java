package calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;

/**
 * This version of the controller does not validates the text introduced into
 * the text field to ensure it is a number. Neither this supports localization,
 * in other words, it only accepts a dot '.' as the decimal point.
 *
 * @author mario gomez
 */
public class Controller implements Initializable {

    @FXML
    private CheckBox subtractCheckBox;

    @FXML
    private Label subtractLabel;

    @FXML
    private Button addOneButton;

    @FXML
    private Button addFiveButton;

    @FXML
    private TextField valueToAdd;

    @FXML
    private Button addTenButton;

    @FXML
    private Button addValueButton;

    @FXML
    private Label resultLabel;

    @Override

    public void initialize(URL arg0, ResourceBundle arg1) {
        subtractCheckBox.setSelected(false);
        subtractLabel.setVisible(false);
    }

    @FXML
    void switchMode(ActionEvent event) {
        if (subtractCheckBox.isSelected()) {
            subtractLabel.setVisible(true);
        } else {
            subtractLabel.setVisible(false);
        }
    }

    @FXML
    void addAction(ActionEvent event) throws ParseException {
        Node source = (Node) event.getSource();
        System.out.println(source.toString());
        String id = source.getId();
        switch (id) {
            case "addOneButton":
                add(1);
                break;
            case "addFiveButton":
                add(5);
                break;
            case "addTenButton":
                add(10);
                break;
            default:
                add(Double.parseDouble(valueToAdd.getText()));
                break;
        }
    }

    private void add(double amount) throws ParseException {
        double result = Double.parseDouble(resultLabel.getText());
        if (!subtractCheckBox.isSelected()) {
            result += amount;
        } else {
            result -= amount;
        }
        resultLabel.setText(Double.toString(result));

    }

}
