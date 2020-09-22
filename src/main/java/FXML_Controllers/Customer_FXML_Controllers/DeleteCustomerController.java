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

public class DeleteCustomerController extends DaoMaker {

    private static final Logger LOGGER = LogManager.getLogger(DeleteCustomerController.class);

    @FXML
    private TextField number;

    @FXML
    private void deleteButton() throws IOException {
        try {
            Customer customer = customerDao.getCustomerById(Long.valueOf(number.getText()));
            String testID = number.getText();

            if (testID.matches(ID_OR_NUMBER) && customer != null) {
                customerDao.deleteCustomer(customer);
                LOGGER.info("\u001B[33mDELETE Customer: Database is updated!\u001B[0m");
                LoaderFXML.loadDatabaseUpdatedFXML();
            } else if (customer == null) {
                LoaderFXML.databaseIsEmpty();
            }
        } catch (Exception ex) {
            LOGGER.error(ex);
        }
    }
}
