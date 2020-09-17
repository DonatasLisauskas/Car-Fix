package FXML_Controllers.Schedule_FXML_Controllers;

import Visitor_Pattern.LoaderFXML;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CrudScheduleController implements Initializable {

    private static final Logger LOGGER = LogManager.getLogger(CrudScheduleController.class);

    @FXML
    private void createScheduleButton() throws IOException {
        try {
            LoaderFXML.loadFXML("/JavaFX/Schedule_DB_FXML/CreateSchedule.fxml");
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mCreateSchedule.fxml is opened !\u001B[0m");
        }
    }

    @FXML
    private void readScheduleButton() throws IOException {
        try {
            LoaderFXML.loadFXML("/JavaFX/Schedule_DB_FXML/ReadSchedule.fxml");
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mReadSchedule.fxml is opened !\u001B[0m");
        }
    }

    @FXML
    private void updateScheduleButton() throws IOException {
        try {
            LoaderFXML.loadFXML("/JavaFX/Schedule_DB_FXML/UpdateSchedule.fxml");
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mUpdateSchedule.fxml is opened !\u001B[0m");
        }
    }

    @FXML
    private void deleteScheduleButton() throws IOException {
        try {
            LoaderFXML.loadFXML("/JavaFX/Schedule_DB_FXML/DeleteSchedule.fxml");
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mDeleteSchedule.fxml is opened !\u001B[0m");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
