package personmanager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
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
 * @author Mario Gomez
 */
public class PersonViewController implements Initializable {

    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private Button buttonOK;
    private Person person;
    protected Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stage = new Stage();
        final BooleanBinding invalidName = Bindings.isEmpty(firstName.textProperty())
                .or(Bindings.isEmpty(lastName.textProperty()));
        buttonOK.disableProperty().bind(invalidName);
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
        } else {
            person = new Person(firstName.getText(), lastName.getText());
        }
        stage.close();
    }

    @FXML
    private void cancel(ActionEvent event) {
        stage.close();
    }

}
