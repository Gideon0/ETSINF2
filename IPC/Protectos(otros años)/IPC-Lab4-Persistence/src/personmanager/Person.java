package personmanager;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mario Gomez (margomez@dsic.upv.es)
 */
@XmlRootElement
public class Person {

    private final StringProperty firstName = new SimpleStringProperty();
    private final StringProperty lastName = new SimpleStringProperty();
    private final IntegerProperty phoneNumber = new SimpleIntegerProperty();
    private final StringProperty email = new SimpleStringProperty();

    public Person() {
    }

    public Person(String firstName, String lastName, int phone, String email) {
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.phoneNumber.set(phone);
        this.email.set(email);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String value) {
        email.set(value);
    }

    public StringProperty emailProperty() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber.get();
    }

    public void setPhoneNumber(int value) {
        phoneNumber.set(value);
    }

    public IntegerProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String value) {
        lastName.set(value);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String value) {
        firstName.set(value);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    @Override
    public String toString() {
        return firstName.get() + "  " + lastName.get();
    }

}
