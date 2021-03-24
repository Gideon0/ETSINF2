package calculator3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ResourceBundle;
import javafx.scene.control.TextFormatter;

/**
 * This version of the controller validates the text introduced into the text
 * field to ensure it is a number. It improves the previous solution in two
 * ways:
 *
 * First, it takes into account localization, so the decimal point is validated
 * considering the character used as decimal point in the current localization.
 * This is achieved by means of a DecimalFormat object.
 *
 * Second, this solution can accept or discard simply the last addition to the
 * field, so if an invalid character is introduced it will simply discard the
 * last character, not the entire value in the field. This is achieved by means
 * of a TextFormatter.
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

    private static final DecimalFormat FORMAT = new DecimalFormat();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        subtractCheckBox.setSelected(false);
        subtractLabel.setVisible(false);

        valueToAdd.setTextFormatter(new TextFormatter<>(c
                -> {
            if (c.getControlNewText().isEmpty()) {
                return c;
            }

            ParsePosition parsePosition = new ParsePosition(0);
            Object object = FORMAT.parse(c.getControlNewText(), parsePosition);

            if (object == null || parsePosition.getIndex() < c.getControlNewText().length()) {
                return null;
            } else {
                return c;
            }
        }));
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
                add(FORMAT.parse(valueToAdd.getText()).doubleValue());
                break;
        }
    }

    private void add(double amount) throws ParseException {
        double result = FORMAT.parse(resultLabel.getText()).doubleValue();
        if (!subtractCheckBox.isSelected()) {
            result += amount;
        } else {
            result -= amount;
        }
        resultLabel.setText(FORMAT.format(result));

    }

}
