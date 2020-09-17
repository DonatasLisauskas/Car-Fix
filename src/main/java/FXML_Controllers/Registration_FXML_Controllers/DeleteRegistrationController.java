package FXML_Controllers.Registration_FXML_Controllers;

import Facade_Pattern.DaoMaker;
import Visitor_Pattern.LoaderFXML;
import carfix.entities.Registration;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class DeleteRegistrationController extends DaoMaker {

    private static final Logger LOGGER = LogManager.getLogger(DeleteRegistrationController.class);

    @FXML
    private TextField number;

    @FXML
    private void deleteButton() throws IOException {
        try {
            Registration registration = registrationDao.getRegistrationById(Long.valueOf(number.getText()));
            registrationDao.deleteRegistration(registration);
        } catch (RuntimeException ex) {
            LOGGER.error(ex);
        }// delete is completed successful, but throw Runtime exception JavaFX.
        finally {
            LOGGER.info("\u001B[33mDELETE Registration: Database is updated!\u001B[0m");
            try {
                LoaderFXML.loadDatabaseUpdatedFXML();
            } catch (IOException ex) {
                LOGGER.error(ex);
            }
        }
    }
}
