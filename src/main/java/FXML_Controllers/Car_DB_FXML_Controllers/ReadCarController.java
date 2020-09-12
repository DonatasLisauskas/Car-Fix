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
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ReadCarController extends DaoMaker {

    @FXML
    private TextField Id;
    @FXML
    private TextField byQuery;
    @FXML
    private TextField byNamedQuery;

    @FXML
    private void readByID() throws IOException {

        Long carId = Long.valueOf(String.valueOf(Id.getText()));

        ListView<String> listView = new ListView<String>();

        Car car = carDao.getCarById(carId);

        ObservableList<String> items = listView.getItems();
        items.add("ID: " + car.getCarId() + " // " +
                car.getSeriesName() + " // " +
                car.getManufactureYear() + " m // " +
                car.getEngineDisplacement_L() + " L // " +
                car.getEnginePower_KW() + " kW //");

        VBox vBox = new VBox();
        vBox.getChildren().add(listView);

        Stage stage = new Stage();

        Scene scene = new Scene(vBox, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void readByQuery() throws IOException {

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
    }
}
