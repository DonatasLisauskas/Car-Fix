package FXML_Controllers.Customer_FXML_Controllers;

import Facade_Pattern.DaoMaker;
import Visitor_Pattern.LoaderFXML;
import carfix.entities.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static carfix.Validation.Regexp.*;

import java.io.IOException;

public class CreateCustomerController extends DaoMaker {

    private static final Logger LOGGER = LogManager.getLogger(CreateCustomerController.class);

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField email;

    @FXML
    private TextField phoneNumber;

    @FXML
    public void createCustomerButton() throws IOException {
        try {
            String testEmail = email.getText();
            String testPhoneNumber = phoneNumber.getText();
            String testName = firstName.getText();
            String testLastName = lastName.getText();

            if (testEmail.matches(EMAIL) && testPhoneNumber.matches(PHONE_NUMBER) &&
                    testName.matches(NAME_LASTNAME) && testLastName.matches(NAME_LASTNAME)) {

                customerDao.createCustomer(new Customer(firstName.getText(), lastName.getText(), testEmail, testPhoneNumber));

                LoaderFXML.loadDatabaseUpdatedFXML();

                LOGGER.info("\u001B[33mCREATE Customer: Database is updated!\u001B[0m");
            } else {

                LoaderFXML.loadInvalidValueFXML();

                LOGGER.info("\u001B[35mCREATE Customer: Database IS NOT updated!\u001B[0m");
            }
        } catch (IOException ioException) {
            LOGGER.error(ioException);
        }
    }
}
