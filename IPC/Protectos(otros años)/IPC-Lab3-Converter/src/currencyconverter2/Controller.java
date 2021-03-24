package currencyconverter2;

import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.util.converter.DoubleStringConverter;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;


/**
 * Main controller class holding all the event handlers and listeners of the main view, specified in view.fxml
 */
public class Controller implements Initializable {
    @FXML
    private Slider conversionRateSlider;

    @FXML
    private Label conversionRateLabel;

    @FXML
    private TextField inputAmount;

    @FXML
    private TextField outputAmount;

    @FXML
    private Button convertButton;

    @FXML
    private Button clearButton;

    @FXML
    private CheckBox autoCheckBoxButton;

    /**
     * Utility object to convert from String to double.
     */
    private final static DoubleStringConverter DOUBLE_STRING_CONVERTER = new DoubleStringConverter();
    /**
     * Utility object to convert from double to String using a decimal format.
     */
    private final static DecimalFormat CURRENCY_FORMAT = new DecimalFormat("#0.00");

    /**
     * Listens for changes in the input amount and calls method {@link #convertAction(javafx.event.ActionEvent)} in response
     */
    private final ChangeListener<String> inputAmountChangeListener = (observable, oldValue, newValue) -> convertAction(null);
    private final ChangeListener conversionRateChangeListener = (observable, oldValue, newValue) -> convertAction(null);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        autoCheckBoxButton.setSelected(false);
        conversionRateLabel.textProperty().bind(Bindings.format("%.2f", conversionRateSlider.valueProperty()));
        conversionRateSlider.setValue(0.5);
        clearAction(null);


    }

    /**
     * Event handler implementing the conversion of the amount of money specified in the  {@link #inputAmount}
     * between the input and output currencies ({@link #inputCurrencyComboBox} and {@link #outputCurrencyComboBox}).
     * Any {@link currencyconverter1.Currency} object specifies a conversion rate between itself and the U.S.Dollar).
     * The conversion is done in two steps: from  input value to dollars, and then into the output of the given output
     * currency.
     *
     * @param actionEvent
     * @see currencyconverter1.Currency
     */
    @FXML
    private void convertAction(ActionEvent actionEvent) {
        double inputValue;
        if (!inputAmount.getText().equals("") && isNumeric(inputAmount.getText())) {
            inputValue = DOUBLE_STRING_CONVERTER.fromString(inputAmount.getText());
            double outputValue = inputValue *  conversionRateSlider.getValue();
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
     * Event handler to manage the conversion mode, which can alternate between "automatic" and "manual" modes.
     * In the manual mode, the conversion can only be run by clicking the "Convert" button (or pressing the Enter key).
     * In the automatic mode, a listener is added to field {@link #inputAmount} so as to be notified when the amount
     * changes and act accordingly.
     *
     * @param actionEvent
     * @see #inputAmountChangeListener
     */
    @FXML
    private void switchAutomaticConversion(ActionEvent actionEvent) {
        if (autoCheckBoxButton.isSelected()) {
            convertButton.setDisable(true);
            //  Add ChangeListener to inputAmount to launch convertAction whenever the input value changes
            inputAmount.textProperty().addListener(inputAmountChangeListener);
            conversionRateSlider.valueProperty().addListener(conversionRateChangeListener);
            convertAction(null);
        } else {
            convertButton.setDisable(false);
            // Remove change listener
            inputAmount.textProperty().removeListener(inputAmountChangeListener);
            conversionRateSlider.valueProperty().removeListener(conversionRateChangeListener);
        }
    }

    /**
     * Checks whether a given string satisfies the criteria to be converted into a Java number
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
