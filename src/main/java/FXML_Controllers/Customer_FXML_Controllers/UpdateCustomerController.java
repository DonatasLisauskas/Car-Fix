package FXML_Controllers.Customer_FXML_Controllers;

import Facade_Pattern.DaoMaker;
import Visitor_Pattern.LoaderFXML;
import carfix.dao.CustomerDao;
import carfix.entities.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static carfix.Validation.Regexp.*;

public class UpdateCustomerController extends DaoMaker {

    private static final Logger LOGGER = LogManager.getLogger(UpdateCustomerController.class);

    @FXML
    private TextField id;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField email;

    @FXML
    private TextField phoneNumber;

    @FXML
    public void update() throws IOException {
        try {

            String testID = id.getText();
            String updateFirstName = firstName.getText();
            String updateLastName = lastName.getText();
            String updateEmail = email.getText();
            String updatePhoneNumber = phoneNumber.getText();

            Customer customer = customerDao.getCustomerById(Long.valueOf(id.getText()));

            if (testID.matches(ID) && !(testID.isEmpty()) && customer != null) {
                if (!(updateFirstName == null)) {
                    if (updateFirstName.matches(NAME_LASTNAME)) {
                        customer.setFirstName(firstName.getText());
                        customerDao.updateCustomer(customer);
                        LoaderFXML.loadDatabaseUpdatedFXML();
                        LOGGER.info("\u001B[33mUPDATE Customer: Database is UPDATED by FirstName!\u001B[0m");
                    } else if (!(updateFirstName.isEmpty())){
                        LoaderFXML.loadInvalidValueFXML();
                    }
                }
                if (!(updateLastName == null)) {
                    if (updateLastName.matches(NAME_LASTNAME)) {
                        customer.setLastName(lastName.getText());
                        customerDao.updateCustomer(customer);
                        LoaderFXML.loadDatabaseUpdatedFXML();
                        LOGGER.info("\u001B[33mUPDATE Customer: Database is UPDATED by LastName!\u001B[0m");
                    } else if (!(updateLastName.isEmpty())){
                        LoaderFXML.loadInvalidValueFXML();
                    }
                }
                if (!(updateEmail == null)) {
                    if (updateEmail.matches(EMAIL)) {
                        customer.setEmail(email.getText());
                        customerDao.updateCustomer(customer);
                        LoaderFXML.loadDatabaseUpdatedFXML();
                        LOGGER.info("\u001B[33mUPDATE Customer: Database is UPDATED by Email!\u001B[0m");
                    } else if (!(updateEmail.isEmpty())){
                        LoaderFXML.loadInvalidValueFXML();
                    }
                }
                if (!(updatePhoneNumber == null)) {
                    if (updatePhoneNumber.matches(PHONE_NUMBER)) {
                        customer.setPhoneNumber(phoneNumber.getText());
                        customerDao.updateCustomer(customer);
                        LoaderFXML.loadDatabaseUpdatedFXML();
                        LOGGER.info("\u001B[33mUPDATE Customer: Database is UPDATED by PhoneNumber!\u001B[0m");
                    } else if (!(updatePhoneNumber.isEmpty())){
                        LoaderFXML.loadInvalidValueFXML();
                    }
                }
            } else if (customer == null | testID.isEmpty()) {
                LoaderFXML.databaseIsEmpty();
                LOGGER.info("\u001B[33mUPDATE Customer: Database IS NOT UPDATED!\u001B[0m");
            }
        } catch (Exception exception) {
            LOGGER.warn(exception);
        }
    }
}
