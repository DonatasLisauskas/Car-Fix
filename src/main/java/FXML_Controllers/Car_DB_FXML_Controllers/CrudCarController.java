package FXML_Controllers.Car_DB_FXML_Controllers;

import Visitor_Pattern.LoaderFXML;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CrudCarController implements Initializable {

    private static final Logger LOGGER = LogManager.getLogger(CrudCarController.class);

    @FXML
    private void createCarButton() throws IOException {
        try {
            LoaderFXML.loadFXML("/JavaFX/Car_DB_FXML/CreateCar.fxml");
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mCreateCar.fxml is opened !\u001B[0m");
        }
    }

    @FXML
    private void readCarButton() throws IOException {
        try {
            LoaderFXML.loadFXML("/JavaFX/Car_DB_FXML/ReadCar.fxml");
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mReadCar.fxml is opened !\u001B[0m");
        }
    }

    @FXML
    private void updateCarButton() throws IOException {
        try {
            LoaderFXML.loadFXML("/JavaFX/Car_DB_FXML/UpdateCar.fxml");
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mUpdateCar.fxml is opened !\u001B[0m");
        }
    }

    @FXML
    private void deleteCarButton() throws IOException {
        try {
            LoaderFXML.loadFXML("/JavaFX/Car_DB_FXML/DeleteCar.fxml");
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mDeleteCar.fxml is opened !\u001B[0m");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
