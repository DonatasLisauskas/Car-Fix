package FXML_Controllers.Customer_FXML_Controllers;

import Visitor_Pattern.LoaderFXML;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CrudCustomerController extends Parent implements Initializable {

    private static final Logger LOGGER = LogManager.getLogger(CrudCustomerController.class);

    @FXML
    private void createCustomerButton() throws IOException {
        try {
            LoaderFXML.loadFXML("/JavaFX/Customer_DB_FXML/CreateCustomer.fxml");
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mCreateCustomer.fxml is opened !\u001B[0m");
        }
    }

    @FXML
    private void readCustomerButton() throws IOException {
        try {
            LoaderFXML.loadFXML("/JavaFX/Customer_DB_FXML/ReadCustomer.fxml");
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mReadCustomer.fxml is opened !\u001B[0m");
        }
    }

    @FXML
    private void updateCustomerButton() throws IOException {
        try {
            LoaderFXML.loadFXML("/JavaFX/Customer_DB_FXML/UpdateCustomer.fxml");
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mUpdateCustomer.fxml is opened !\u001B[0m");
        }
    }

    @FXML
    private void deleteCustomerButton() throws IOException {
        try {
            LoaderFXML.loadFXML("/JavaFX/Customer_DB_FXML/DeleteCustomer.fxml");
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mDeleteCustomer.fxml is opened !\u001B[0m");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
