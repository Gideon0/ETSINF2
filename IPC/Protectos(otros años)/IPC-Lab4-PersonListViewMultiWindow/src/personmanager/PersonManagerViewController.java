package personmanager;

import java.io.IOException;
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
import javafx.stage.Modality;
import javafx.stage.Stage;

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

    private final ObservableList<Person> data = FXCollections.observableArrayList(
            new Person("John", "Doe"),
            new Person("Jane", "Doe")
    );

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listView.setItems(data);
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        final BooleanBinding noPersonSelected = Bindings.isNull(
                listView.getSelectionModel().selectedItemProperty());
        removeButton.disableProperty().bind(noPersonSelected);
        modifyButton.disableProperty().bind(noPersonSelected);
    }

    @FXML
    private void addItem(ActionEvent event) throws IOException {
        final Stage currentStage = (Stage) listView.getScene().getWindow();
        PersonViewController pvc = PersonViewController.init(Modality.APPLICATION_MODAL, currentStage);
        Person newPerson = pvc.showAndWait();
        if (newPerson != null) {
            data.add(newPerson);
        }
    }

    @FXML
    private void removeItem(ActionEvent event) {
        data.removeAll(listView.getSelectionModel().getSelectedItems());
    }

    @FXML
    private void modifyItem(ActionEvent event) throws IOException {
        final Stage currentStage = (Stage) listView.getScene().getWindow();
        PersonViewController controller = PersonViewController.init(Modality.APPLICATION_MODAL, currentStage);
        Person selectedPerson = listView.getSelectionModel().getSelectedItem();
        controller.showAndWait(selectedPerson);
        listView.refresh();
    }

}
