package FXML_Controllers.Failure_FXML_Controllers;

import Visitor_Pattern.LoaderFXML;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CrudFailureController implements Initializable {

    private static final Logger LOGGER = LogManager.getLogger(CrudFailureController.class);

    @FXML
    private void createFailureButton() throws IOException {
        try {
            LoaderFXML.loadFXML("/JavaFX/Failure_DB_FXML/CreateFailure.fxml");
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mCreateFailure.fxml is opened !\u001B[0m");
        }
    }

    @FXML
    private void readFailureButton() throws IOException {
        try {
            LoaderFXML.loadFXML("/JavaFX/Failure_DB_FXML/ReadFailure.fxml");
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mReadFailure.fxml is opened !\u001B[0m");
        }
    }

    @FXML
    private void updateFailureButton() throws IOException {
        try {
            LoaderFXML.loadFXML("/JavaFX/Failure_DB_FXML/UpdateFailure.fxml");
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mUpdateFailure.fxml is opened !\u001B[0m");
        }
    }

    @FXML
    private void deleteFailureButton() throws IOException {
        try {
            LoaderFXML.loadFXML("/JavaFX/Failure_DB_FXML/DeleteFailure.fxml");
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mDeleteFailure.fxml is opened !\u001B[0m");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
