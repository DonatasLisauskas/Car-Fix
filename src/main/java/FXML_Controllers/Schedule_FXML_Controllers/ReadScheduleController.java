package FXML_Controllers.Schedule_FXML_Controllers;

import Facade_Pattern.DaoMaker;
import carfix.entities.Schedule;
import carfix.entities.Work;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReadScheduleController extends DaoMaker {

    private static final Logger LOGGER = LogManager.getLogger(ReadScheduleController.class);

    @FXML
    private TextField Id;
    @FXML
    private TextField byQuery;
    @FXML
    private TextField byNamedQuery;

    @FXML
    private void readByID() {
        try {
            Long scheduleID = Long.valueOf(String.valueOf(Id.getText()));

            ListView listView = new ListView();

            Schedule schedule = scheduleDao.getScheduleById(scheduleID);

            ObservableList<Schedule> items = listView.getItems();
            items.add(schedule);

            VBox vBox = new VBox();
            vBox.getChildren().add(listView);
            Stage stage = new Stage();
            Scene scene = new Scene(vBox, 500, 500);
            stage.setScene(scene);
            stage.show();

        } catch (Exception ex) {

            LOGGER.error(ex);
            if ( ex instanceof IllegalArgumentException ) {
                throw ex;
            }

        } finally {
            LOGGER.info("\u001B[33mREAD Schedule: Database is READ by ID!\u001B[0m");
        }
    }

    @FXML
    private void readByQuery() {
        try {
            String query = String.valueOf((byQuery.getText()));

            ListView listView = new ListView();

            ObservableList<Schedule> items = listView.getItems();

            items.addAll(scheduleDao.getListOfScheduleByQueries(query));

            VBox vBox = new VBox();
            vBox.getChildren().add(listView);
            Stage stage = new Stage();
            Scene scene = new Scene(vBox, 500, 500);
            stage.setScene(scene);
            stage.show();

        } catch (Exception ex) {

            LOGGER.error(ex);
            if ( ex instanceof IllegalArgumentException ) {
                throw ex;
            }

        } finally {
            LOGGER.info("\u001B[33mREAD Schedule: Database is READ by Query!\u001B[0m");
        }
    }
}
