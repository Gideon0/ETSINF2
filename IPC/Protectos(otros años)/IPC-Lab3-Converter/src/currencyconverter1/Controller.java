package currencyconverter1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.util.converter.DoubleStringConverter;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.scene.control.Slider;

/**
 * Main controller class holding all the event handlers and listeners of the
 * main view, specified in view.fxml
 */
public class Controller implements Initializable {

    @FXML
    private TextField outputAmount;

    @FXML
    private TextField inputAmount;

    @FXML
    private Slider conversionRate;

    @FXML
    private Button convertButton;

    /**
     * Utility object to convert from String to double.
     */
    private final static DoubleStringConverter DOUBLE_STRING_CONVERTER = new DoubleStringConverter();
    /**
     * Utility object to convert from double to String using a decimal format.
     */
    private final static DecimalFormat CURRENCY_FORMAT = new DecimalFormat("#0.00");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clearAction(null);

    }

    /**
     * Event handler implementing the conversion of the amount of money
     * specified in the {@link #inputAmount} between the input and output
     * currencies ({@link #inputCurrencyComboBox} and
     * {@link #outputCurrencyComboBox}). Any {@link currencyconverter1.Currency}
     * object specifies a conversion rate between itself and the U.S.Dollar).
     * The conversion is done in two steps: from input value to dollars, and
     * then into the output of the given output currency.
     *
     * @param actionEvent
     * @see currencyconverter1.Currency
     */
    @FXML
    private void convertAction(ActionEvent actionEvent) {
        double inputValue;
        if (!inputAmount.getText().equals("") && isNumeric(inputAmount.getText())) {
            inputValue = DOUBLE_STRING_CONVERTER.fromString(inputAmount.getText());
            double outputValue = inputValue * conversionRate.getValue();
            outputAmount.setText(CURRENCY_FORMAT.format(outputValue));
        }
    }

    /**
     * Event handler used to clear the conversion interface from previous values
     *
     * @param actionEvent
     */
    @FXML
    private void clearAction(ActionEvent actionEvent) {
        inputAmount.setText("");
        outputAmount.setText("");
    }

    /**
     * Checks whether a given string satisfies the criteria to be converted into
     * a Java number
     *
     * @param str
     * @return
     */
    private static boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
