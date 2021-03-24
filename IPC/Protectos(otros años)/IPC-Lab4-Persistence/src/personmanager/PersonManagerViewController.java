package personmanager;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Mario Gomez (margomez@dsic.upv.es)
 */
public class PersonManagerViewController implements Initializable {

    @FXML
    private Button addButton;
    @FXML
    private Button removeButton;
    @FXML
    private Button modifyButton;
    @FXML
    private TableView<Person> tableView;
    @FXML
    private TableColumn<Person, String> name;
    @FXML
    private TableColumn<Person, Number> phone;
    @FXML
    private TableColumn<Person, String> email;
    @FXML
    private TextField filePath;

    private final ObservableList<Person> data = FXCollections.observableArrayList(
            new Person("John", "Doe", 961234567, "john@domain.es"),
            new Person("Jane", "Doe", 967654321, "jane@domain.es"),
            new Person("Jim", "Doe", 961267345, "jim@domain.es")
    );

    private final ObjectProperty<File> file = new SimpleObjectProperty<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        tableView.setItems(data);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        name.setCellValueFactory(cellData
                -> new SimpleStringProperty(cellData.getValue().getFirstName()
                        + " " + cellData.getValue().getLastName()));
        phone.setCellValueFactory(cellData -> cellData.getValue().phoneNumberProperty());
        email.setCellValueFactory(cellData -> cellData.getValue().emailProperty());

        final BooleanBinding noPersonSelected = Bindings.isNull(
                tableView.getSelectionModel().selectedItemProperty());
        removeButton.disableProperty().bind(noPersonSelected);
        modifyButton.disableProperty().bind(noPersonSelected);

        file.addListener((observable, oldValue, newValue) -> {
            filePath.setText(newValue.getName());
            filePath.setTooltip(new Tooltip(newValue.getPath()));
        });
        file.set(new File(System.getProperty("user.dir") + "/address_book.xml"));
    }

    @FXML
    private void addItem(ActionEvent event) throws IOException {
        final Stage currentStage = (Stage) tableView.getScene().getWindow();
        PersonViewController pvc = PersonViewController.init(Modality.APPLICATION_MODAL, currentStage);
        Person newPerson = pvc.showAndWait();
        if (newPerson != null) {
            data.add(newPerson);
        }
    }

    @FXML
    private void removeItem(ActionEvent event) {
        data.removeAll(tableView.getSelectionModel().getSelectedItems());
    }

    @FXML
    private void modifyItem(ActionEvent event) throws IOException {
        final Stage currentStage = (Stage) tableView.getScene().getWindow();
        PersonViewController controller = PersonViewController.init(Modality.APPLICATION_MODAL, currentStage);
        Person selectedPerson = tableView.getSelectionModel().getSelectedItem();
        controller.showAndWait(selectedPerson);
        tableView.refresh();
    }

    @FXML
    private void load(ActionEvent event) throws JAXBException {
        if (file.get() != null) {
            JAXBContext context = JAXBContext.newInstance(AddressBook.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            AddressBook addressBook = (AddressBook) unmarshaller.unmarshal(file.get());
            data.setAll(addressBook.getContacts());
        }
    }

    @FXML
    private void save(ActionEvent event) throws JAXBException {
        if (file.get() != null) {
            JAXBContext context = JAXBContext.newInstance(AddressBook.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            AddressBook addressBook = new AddressBook();
            addressBook.setContacts(data);
            //m.marshal(directory, System.out); //displays XML in console
            marshaller.marshal(addressBook, file.get());
        }
    }

    @FXML
    private void selectFile(ActionEvent event) {
        Window stage = ((Node) event.getSource()).getScene().getWindow();
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Save directory to XML file");
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML File", "*.xml"));
        chooser.setInitialFileName("address_book");
        chooser.setInitialDirectory(file.get().getParentFile());
        File newFile = chooser.showSaveDialog(stage);
        if (newFile != null) {
            file.set(newFile);
        }
    }

}
