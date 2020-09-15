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

public class CreateScheduleController extends DaoMaker {

    private static final Logger LOGGER = LogManager.getLogger(CreateScheduleController.class);

    @FXML
    private TextField date;

    @FXML
    private TextField time;

    @FXML
    private TextField totalPrice;

    @FXML
    private TextField registrationId;

    @FXML
    public void createWorkButton() {

        Registration registration = registrationDao.getRegistrationById(Long.valueOf(registrationId.getText()));

        scheduleDao.createSchedule(new Schedule(date.getText(), time.getText(), Long.valueOf(totalPrice.getText()), registration));
        try {
            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/JavaFX/DatabaseUpdated.fxml"));
            Parent root1 = (Parent) fxmlLoader1.load();
            Stage stage1 = new Stage();
            stage1.setScene(new Scene(root1));
            stage1.show();
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mCREATE Schedule: Database is updated!\u001B[0m");
        }
    }
}
