package personmanager;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mario Gomez (margomez@dsic.upv.es)
 */
@XmlRootElement
public class AddressBook {

    private List<Person> contacts;

    public AddressBook() {
    }

    @XmlElement(name = "contact")
    public List<Person> getContacts() {
        return contacts;
    }

    public void setContacts(List<Person> persons) {
        this.contacts = persons;
    }

}
