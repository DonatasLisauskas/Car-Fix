package FXML_Controllers.Failure_FXML_Controllers;

import Facade_Pattern.DaoMaker;
import Visitor_Pattern.LoaderFXML;
import carfix.entities.Failure;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class UpdateFailureController extends DaoMaker {

    private static final Logger LOGGER = LogManager.getLogger(UpdateFailureController.class);

    @FXML
    private TextField id;

    @FXML
    private TextField failureName;

    @FXML
    public void updateName() throws IOException {
        try {
            Failure failure = failureDao.getFailureById(Long.valueOf(id.getText()));
            failure.setFailureName(failureName.getText());
            failureDao.updateFailure(failure);
        } catch (RuntimeException ex) {
            LOGGER.error(ex);
        } // update is completed successful, but throw Runtime exception JavaFX.
        finally {
            LOGGER.info("\u001B[33mUPDATE Failure: Database is UPDATED by FailureName!\u001B[0m");
            try {
                LoaderFXML.loadDatabaseUpdatedFXML();
            } catch (IOException ex) {
                LOGGER.error(ex);
            }
        }
    }
}
