package FXML_Controllers.Registration_FXML_Controllers;

import Visitor_Pattern.LoaderFXML;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CrudRegistrationController implements Initializable {

    private static final Logger LOGGER = LogManager.getLogger(CrudRegistrationController.class);

    @FXML
    private void createRegistrationButton() throws IOException {
        try {
            LoaderFXML.loadFXML("/JavaFX/Registration_DB_FXML/CreateRegistration.fxml");
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mCreateRegistration.fxml is opened !\u001B[0m");
        }
    }

    @FXML
    private void readRegistrationButton() throws IOException {
        try {
            LoaderFXML.loadFXML("/JavaFX/Registration_DB_FXML/ReadRegistration.fxml");
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mReadRegistration.fxml is opened !\u001B[0m");
        }
    }

    @FXML
    private void updateRegistrationButton() throws IOException {
        try {
            LoaderFXML.loadFXML("/JavaFX/Registration_DB_FXML/UpdateRegistration.fxml");
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mUpdateRegistration.fxml is opened !\u001B[0m");
        }
    }

    @FXML
    private void deleteRegistrationButton() throws IOException {
        try {
            LoaderFXML.loadFXML("/JavaFX/Registration_DB_FXML/DeleteRegistration.fxml");
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mDeleteRegistration.fxml is opened !\u001B[0m");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
