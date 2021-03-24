package personmanager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Mario Gomez (margomez@dsic.upv.es)
 */
public class PersonViewController implements Initializable {

    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField phone;
    @FXML
    private TextField email;
    @FXML
    private Button buttonOK;
    private Person person;
    protected Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stage = new Stage();
        final BooleanBinding missingData
                = firstName.textProperty().isEmpty()
                        .or(lastName.textProperty().isEmpty())
                        .or(phone.textProperty().isEmpty())
                        .or(email.textProperty().isEmpty());
        buttonOK.disableProperty().bind(missingData);
        phone.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                //phone.setText(newValue.replaceAll("[^\\d]", ""));
                phone.setText(oldValue);
            }
        });
    }

    public static PersonViewController init(Modality modality, Stage owner) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PersonViewController.class.getResource("PersonView.fxml"));
        Parent parent = fxmlLoader.load();
        PersonViewController controller = fxmlLoader.getController();
        controller.stage.setScene(new Scene(parent));
        controller.stage.initModality(modality);
        controller.stage.initOwner(owner);
        return controller;
    }

    public Person showAndWait(Person person) {
        this.person = person;
        firstName.setText(person.getFirstName());
        lastName.setText(person.getLastName());
        phone.setText(String.valueOf(person.getPhoneNumber()));
        stage.showAndWait();
        return this.person;
    }

    public Person showAndWait() {
        this.person = null;
        stage.showAndWait();
        return person;
    }

    @FXML
    private void confirm(ActionEvent event) {
        if (person != null) {
            person.setFirstName(firstName.getText());
            person.setLastName(lastName.getText());
            person.setPhoneNumber(Integer.valueOf(phone.getText()));
        } else {
            person = new Person(firstName.getText(), lastName.getText(), Integer.valueOf(phone.getText()), email.getText());
        }
        stage.close();
    }

    @FXML
    private void cancel(ActionEvent event) {
        stage.close();
    }

}
