package FXML_Controllers.Schedule_FXML_Controllers;

import Facade_Pattern.DaoMaker;
import carfix.entities.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

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
            schedule.setDate(date.getText());
            scheduleDao.updateSchedule(schedule);
        } catch (RuntimeException ex) {
            LOGGER.error(ex);
        } // update is completed successful, but throw Runtime exception JavaFX.
        finally {
            LOGGER.info("\u001B[33mUPDATE Schedule: Database is UPDATED by Date!\u001B[0m");
            try {
                FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/JavaFX/DatabaseUpdated.fxml"));
                Parent root1 = (Parent) fxmlLoader1.load();
                Stage stage1 = new Stage();
                stage1.setScene(new Scene(root1));
                stage1.show();
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
                FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/JavaFX/DatabaseUpdated.fxml"));
                Parent root1 = (Parent) fxmlLoader1.load();
                Stage stage1 = new Stage();
                stage1.setScene(new Scene(root1));
                stage1.show();
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
                FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/JavaFX/DatabaseUpdated.fxml"));
                Parent root1 = (Parent) fxmlLoader1.load();
                Stage stage1 = new Stage();
                stage1.setScene(new Scene(root1));
                stage1.show();
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
                FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/JavaFX/DatabaseUpdated.fxml"));
                Parent root1 = (Parent) fxmlLoader1.load();
                Stage stage1 = new Stage();
                stage1.setScene(new Scene(root1));
                stage1.show();
            } catch (IOException ex) {
                LOGGER.error(ex);
            }
        }
    }
}
