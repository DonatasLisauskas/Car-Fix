package FXML_Controllers.Work_FXML_Controllers;

import Visitor_Pattern.LoaderFXML;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CrudWorkController implements Initializable {

    private static final Logger LOGGER = LogManager.getLogger(CrudWorkController.class);

    @FXML
    private void createWorkButton() throws IOException {
        try {
            LoaderFXML.loadFXML("/JavaFX/Work_DB_FXML/CreateWork.fxml");
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mCreateWork.fxml is opened !\u001B[0m");
        }
    }

    @FXML
    private void readWorkButton() throws IOException {
        try {
            LoaderFXML.loadFXML("/JavaFX/Work_DB_FXML/ReadWork.fxml");
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mReadWork.fxml is opened !\u001B[0m");
        }
    }

    @FXML
    private void updateWorkButton() throws IOException {
        try {
            LoaderFXML.loadFXML("/JavaFX/Work_DB_FXML/UpdateWork.fxml");
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mUpdateWork.fxml is opened !\u001B[0m");
        }
    }

    @FXML
    private void deleteWorkButton() throws IOException {
        try {
            LoaderFXML.loadFXML("/JavaFX/Work_DB_FXML/DeleteWork.fxml");
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mDeleteWork.fxml is opened !\u001B[0m");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
