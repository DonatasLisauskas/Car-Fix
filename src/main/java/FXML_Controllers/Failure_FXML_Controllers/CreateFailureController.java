package FXML_Controllers.Failure_FXML_Controllers;

import Facade_Pattern.DaoMaker;
import Visitor_Pattern.LoaderFXML;
import carfix.entities.Failure;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class CreateFailureController extends DaoMaker {

    private static final Logger LOGGER = LogManager.getLogger(CreateFailureController.class);

    @FXML
    private TextField failureName;

    @FXML
    public void createFailureButton() throws IOException {
        failureDao.createFailure(new Failure(failureName.getText()));
        try {
            LoaderFXML.loadDatabaseUpdatedFXML();
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mCREATE Failure: Database is updated!\u001B[0m");
        }
    }
}
