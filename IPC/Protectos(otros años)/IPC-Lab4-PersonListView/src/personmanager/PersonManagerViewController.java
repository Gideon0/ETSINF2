package personmanager;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;

/**
 *
 * @author Mario Gómez (margomez@dsic.upv.es)
 */
public class PersonManagerViewController implements Initializable {

    @FXML
    private ListView<Person> listView;
    @FXML
    private Button addButton;
    @FXML
    private Button removeButton;
    @FXML
    private Button modifyButton;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;

    private final ObservableList<Person> data = FXCollections.observableArrayList(
            new Person("John", "Doe"),
            new Person("Jane", "Doe")
    );

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listView.setItems(data);
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        BooleanBinding noPersonSelected = 
                Bindings.isEmpty(listView.getSelectionModel().getSelectedItems());
        
        BooleanBinding dataMissing =
                firstName.textProperty().isEmpty()
                        .or(lastName.textProperty().isEmpty());

        removeButton.disableProperty().bind(noPersonSelected);

        addButton.disableProperty().bind(dataMissing);
        
        modifyButton.disableProperty().bind(noPersonSelected.or(dataMissing));

        listView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    firstName.setText(newValue.getFirstName());
                    lastName.setText(newValue.getLastName());
                }
        );
    }
    
    
    @FXML
    private void addItem(ActionEvent event) {
        data.add(new Person(firstName.getText(), lastName.getText()));
        firstName.clear();
        lastName.clear();
        firstName.requestFocus(); 
    }

    @FXML
    private void removeItem(ActionEvent event) {
        data.removeAll(listView.getSelectionModel().getSelectedItems());
    }

    @FXML
    private void modifyItem(ActionEvent event) {
        Person person = listView.getSelectionModel().getSelectedItem();
        person.setFirstName(firstName.getText());
        person.setLastName(lastName.getText());
        listView.refresh();
    }

}
