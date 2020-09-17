package FXML_Controllers.Customer_FXML_Controllers;

import Visitor_Pattern.LoaderFXML;
import carfix.dao.CustomerDao;
import carfix.entities.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class CreateCustomerController {

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
        CustomerDao customerDao = new CustomerDao();
        customerDao.createCustomer(new Customer(firstName.getText(), lastName.getText(), email.getText(), Long.valueOf(phoneNumber.getText())));
        try {
            LoaderFXML.loadDatabaseUpdatedFXML();
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mCREATE Customer: Database is updated!\u001B[0m");
        }
    }
}
