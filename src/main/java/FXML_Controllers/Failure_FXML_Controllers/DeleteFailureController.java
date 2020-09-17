package FXML_Controllers.Failure_FXML_Controllers;

import Facade_Pattern.DaoMaker;
import Visitor_Pattern.LoaderFXML;
import carfix.entities.Failure;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class DeleteFailureController extends DaoMaker {

    private static final Logger LOGGER = LogManager.getLogger(DeleteFailureController.class);

    @FXML
    private TextField number;

    @FXML
    private void deleteButton() throws IOException {
        try {
            Failure failure = failureDao.getFailureById(Long.valueOf(number.getText()));
            failureDao.deleteFailure(failure);
        } catch (RuntimeException ex) {
            LOGGER.error(ex);
        }// delete is completed successful, but throw Runtime exception JavaFX.
        finally {
            LOGGER.info("\u001B[33mDELETE Failure: Database is updated!\u001B[0m");
            try {
                LoaderFXML.loadDatabaseUpdatedFXML();
            } catch (IOException ex) {
                LOGGER.error(ex);
            }
        }
    }
}
