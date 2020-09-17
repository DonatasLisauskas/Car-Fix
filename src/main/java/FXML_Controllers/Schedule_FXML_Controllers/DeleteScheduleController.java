package FXML_Controllers.Schedule_FXML_Controllers;

import Facade_Pattern.DaoMaker;
import Visitor_Pattern.LoaderFXML;
import carfix.entities.Schedule;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class DeleteScheduleController extends DaoMaker {

    private static final Logger LOGGER = LogManager.getLogger(DeleteScheduleController.class);

    @FXML
    private TextField number;

    @FXML
    private void deleteButton() throws IOException {
        try {
            Schedule schedule = scheduleDao.getScheduleById(Long.valueOf(number.getText()));
            scheduleDao.deleteSchedule(schedule);
        } catch (RuntimeException ex) {
            LOGGER.error(ex);
        }// delete is completed successful, but throw Runtime exception JavaFX.
        finally {
            LOGGER.info("\u001B[33mDELETE Schedule: Database is updated!\u001B[0m");
            try {
                LoaderFXML.loadDatabaseUpdatedFXML();
            } catch (IOException ex) {
                LOGGER.error(ex);
            }
        }
    }
}
