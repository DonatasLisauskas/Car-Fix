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
    public void updateFirstName() throws IOException {
        try {
            Customer customer = customerDao.getCustomerById(Long.valueOf(id.getText()));
            customer.setFirstName(firstName.getText());
            customerDao.updateCustomer(customer);
        } catch (RuntimeException ex) {
            LOGGER.error(ex);
        } // update is completed successful, but throw Runtime exception JavaFX.
        finally {
            LOGGER.info("\u001B[33mUPDATE Customer: Database is UPDATED by FirstName!\u001B[0m");
            try {
                LoaderFXML.loadDatabaseUpdatedFXML();
            } catch (IOException ex) {
                LOGGER.error(ex);
            }
        }
    }

    @FXML
    public void updateLastName() throws IOException {
        try {
            CustomerDao customerDao = new CustomerDao();
            Customer customer = customerDao.getCustomerById(Long.valueOf(id.getText()));
            customer.setLastName(lastName.getText());
            customerDao.updateCustomer(customer);
        } catch (RuntimeException ex) {
            LOGGER.error(ex);
        } // update is completed successful, but throw Runtime exception JavaFX.
        finally {
            LOGGER.info("\u001B[33mUPDATE Customer: Database is UPDATED by LastName!\u001B[0m");
            try {
                LoaderFXML.loadDatabaseUpdatedFXML();
            } catch (IOException ex) {
                LOGGER.error(ex);
            }
        }
    }

    @FXML
    public void updateEmail() throws IOException {
        try {
            Customer customer = customerDao.getCustomerById(Long.valueOf(id.getText()));
            customer.setEmail(email.getText());
            customerDao.updateCustomer(customer);
        } catch (RuntimeException ex) {
            LOGGER.error(ex);
        } // update is completed successful, but throw Runtime exception JavaFX.
        finally {
            LOGGER.info("\u001B[33mUPDATE Customer: Database is UPDATED by Email!\u001B[0m");
            try {
                LoaderFXML.loadDatabaseUpdatedFXML();
            } catch (IOException ex) {
                LOGGER.error(ex);
            }
        }
    }

    @FXML
    public void updatePhoneNumber() throws IOException {
        try {
            Customer customer = customerDao.getCustomerById(Long.valueOf(id.getText()));
            customer.setPhoneNumber(Long.valueOf(phoneNumber.getText()));
            customerDao.updateCustomer(customer);
        } catch (RuntimeException ex) {
            LOGGER.error(ex);
        } // update is completed successful, but throw Runtime exception JavaFX.
        finally {
            LOGGER.info("\u001B[33mUPDATE Customer: Database is UPDATED by PhoneNumber!\u001B[0m");
            try {
                LoaderFXML.loadDatabaseUpdatedFXML();
            } catch (IOException ex) {
                LOGGER.error(ex);
            }
        }
    }
}
