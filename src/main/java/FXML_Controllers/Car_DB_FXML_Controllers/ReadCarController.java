package FXML_Controllers.Car_DB_FXML_Controllers;

import Facade_Pattern.DaoMaker;
import carfix.entities.Car;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.NonNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.transaction.Transactional;

public class ReadCarController extends DaoMaker {

    private static final Logger LOGGER = LogManager.getLogger(ReadCarController.class);

    @FXML
    @NonNull
    private TextField Id;

    @FXML
    @NonNull
    private TextField byQuery;

    @FXML
    @NonNull
    private TextField byNamedQuery;

    @FXML
    @Transactional
    private void readByID() {
        try {
            Long carId = Long.valueOf(String.valueOf(Id.getText()));

            ListView listView = new ListView();

            Car car = carDao.getCarById(carId);

            ObservableList<Car> items = listView.getItems();
            items.add(car);

            VBox vBox = new VBox();
            vBox.getChildren().add(listView);
            Stage stage = new Stage();
            Scene scene = new Scene(vBox, 500, 500);
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mREAD Car: Database is READED by ID!\u001B[0m");
        }
    }

    @FXML
    @Transactional
    private void readByQuery() {
        try {
            String query = String.valueOf((byQuery.getText()));

            ListView listView = new ListView();

            ObservableList<Car> items = listView.getItems();

            items.addAll(carDao.getListOfCarByQueries(query));

            VBox vBox = new VBox();
            vBox.getChildren().add(listView);
            Stage stage = new Stage();
            Scene scene = new Scene(vBox, 500, 500);
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mREAD Car: Database is READED by Query!\u001B[0m");
        }
    }
}
