package FXML_Controllers.Detail_FXML_Controllers;

import Visitor_Pattern.LoaderFXML;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CrudDetailController implements Initializable {

    private static final Logger LOGGER = LogManager.getLogger(CrudDetailController.class);

    @FXML
    private void createDetailButton() throws IOException {
        try {
            LoaderFXML.loadFXML("/JavaFX/Detail_DB_FXML/CreateDetail.fxml");
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mCreateDetail.fxml is opened !\u001B[0m");
        }
    }

    @FXML
    private void readDetailButton() throws IOException {
        try {
            LoaderFXML.loadFXML("/JavaFX/Detail_DB_FXML/ReadDetail.fxml");
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mReadDetail.fxml is opened !\u001B[0m");
        }
    }

    @FXML
    private void updateDetailButton() throws IOException {
        try {
            LoaderFXML.loadFXML("/JavaFX/Detail_DB_FXML/UpdateDetail.fxml");
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mUpdateDetail.fxml is opened !\u001B[0m");
        }
    }

    @FXML
    private void deleteButton() throws IOException {
        try {
            LoaderFXML.loadFXML("/JavaFX/Detail_DB_FXML/DeleteDetail.fxml");
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mDeleteDetail.fxml is opened !\u001B[0m");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
