package seedu.address.ui;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import jdk.jfr.Frequency;
import seedu.address.model.person.Person;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class PersonCard extends UiPart<Region> {

    private static final String FXML = "PersonListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Person person;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label name1;
    @FXML
    private Label id;
    @FXML
    private Label id1;
    @FXML
    private Label phone;
    @FXML
    private Label phone1;
    @FXML
    private Label address;
    @FXML
    private Label address1;
    @FXML
    private Label email;
    @FXML
    private Label email1;
    @FXML
    private FlowPane tags;
    @FXML
    private FlowPane tags1;

    public PersonCard(Person person, int displayedIndex) {
        super(FXML);
        this.person = person;

        if (displayedIndex % 2 == 0) {
            id.setText(displayedIndex + ". ");
            name.setText(person.getName().fullName);
            phone.setText(person.getPhone().value);
            address.setText(person.getAddress().value);
            email.setText(person.getEmail().value);
            person.getTags().stream()
                    .sorted(Comparator.comparing(tag -> tag.tagName))
                    .forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
        } else {
            id1.setText(displayedIndex + ". ");
            name1.setText(person.getName().fullName);
            phone1.setText(person.getPhone().value);
            address1.setText(person.getAddress().value);
            email1.setText(person.getEmail().value);
            person.getTags().stream()
                    .sorted(Comparator.comparing(tag -> tag.tagName))
                    .forEach(tag -> tags1.getChildren().add(new Label(tag.tagName)));
        }
        //for original version, delete everything but the contents of the "if" block.
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof PersonCard)) {
            return false;
        }

        // state check
        PersonCard card = (PersonCard) other;
        return id.getText().equals(card.id.getText())
                && person.equals(card.person);
    }
}
