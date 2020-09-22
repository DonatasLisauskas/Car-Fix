package FXML_Controllers.Schedule_FXML_Controllers;

import Facade_Pattern.DaoMaker;
import Visitor_Pattern.LoaderFXML;
import carfix.entities.*;
import com.mysql.cj.Session;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.Date;

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

            String textDate = String.valueOf(date.getText());
            Date dateSQL = Date.valueOf(textDate);

            String textTime = String.valueOf(time.getText());

            scheduleDao.createSchedule(new Schedule(dateSQL, textTime, Long.valueOf(totalPrice.getText()), registration));

        try {
            LoaderFXML.loadDatabaseUpdatedFXML();
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mCREATE Schedule: Database is updated!\u001B[0m");
        }
    }
}
