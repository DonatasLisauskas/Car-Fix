package FXML_Controllers.Schedule_FXML_Controllers;

import Facade_Pattern.DaoMaker;
import Visitor_Pattern.LoaderFXML;
import carfix.entities.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.Date;

public class UpdateScheduleController extends DaoMaker {

    private static final Logger LOGGER = LogManager.getLogger(UpdateScheduleController.class);

    @FXML
    private TextField scheduleID;

    @FXML
    private TextField date;

    @FXML
    private TextField time;

    @FXML
    private TextField totalPrice;

    @FXML
    private TextField registrationID;

    @FXML
    public void updateDate() throws IOException {
        try {
            Schedule schedule = scheduleDao.getScheduleById(Long.valueOf(scheduleID.getText()));
            schedule.setDate( Date.valueOf(date.getText()) );
            scheduleDao.updateSchedule(schedule);
        } catch (RuntimeException ex) {
            LOGGER.error(ex);

            if ( ex instanceof IllegalArgumentException ) {
                throw ex;
            }

        } // update is completed successful, but throw Runtime exception JavaFX.
        finally {
            LOGGER.info("\u001B[33mUPDATE Schedule: Database is UPDATED by Date!\u001B[0m");
            try {
                LoaderFXML.loadDatabaseUpdatedFXML();
            } catch (IOException ex) {
                LOGGER.error(ex);
            }
        }
    }

    @FXML
    public void updateTime() throws IOException {
        try {
            Schedule schedule = scheduleDao.getScheduleById(Long.valueOf(scheduleID.getText()));
            schedule.setTime(time.getText());
            scheduleDao.updateSchedule(schedule);
        } catch (RuntimeException ex) {
            LOGGER.error(ex);
        } // update is completed successful, but throw Runtime exception JavaFX.
        finally {
            LOGGER.info("\u001B[33mUPDATE Schedule: Database is UPDATED by Time!\u001B[0m");
            try {
                LoaderFXML.loadDatabaseUpdatedFXML();
            } catch (IOException ex) {
                LOGGER.error(ex);
            }
        }
    }

    @FXML
    public void updateTotalPrice() throws IOException {
        try {
            Schedule schedule = scheduleDao.getScheduleById(Long.valueOf(scheduleID.getText()));
            schedule.setTotalPrice(Long.valueOf(totalPrice.getText()));
            scheduleDao.updateSchedule(schedule);
        } catch (RuntimeException ex) {
            LOGGER.error(ex);
        } // update is completed successful, but throw Runtime exception JavaFX.
        finally {
            LOGGER.info("\u001B[33mUPDATE Schedule: Database is UPDATED by Total Price!\u001B[0m");
            try {
                LoaderFXML.loadDatabaseUpdatedFXML();
            } catch (IOException ex) {
                LOGGER.error(ex);
            }
        }
    }

    @FXML
    public void updateRegistrationID() throws IOException {
        try {
            Schedule schedule = scheduleDao.getScheduleById(Long.valueOf(scheduleID.getText()));
            Registration registration = registrationDao.getRegistrationById(Long.valueOf(registrationID.getText()));
            schedule.setRegistration(registration);
            scheduleDao.updateSchedule(schedule);
        } catch (RuntimeException ex) {
            LOGGER.error(ex);
        } // update is completed successful, but throw Runtime exception JavaFX.
        finally {
            LOGGER.info("\u001B[33mUPDATE Schedule: Database is UPDATED by Registration ID!\u001B[0m");
            try {
                LoaderFXML.loadDatabaseUpdatedFXML();
            } catch (IOException ex) {
                LOGGER.error(ex);
            }
        }
    }
}
