package FXML_Controllers.Car_DB_FXML_Controllers;

import carfix.dao.CarDao;
import carfix.entities.Car;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class ReadCarController {

    @FXML
    private TextField Id;
    @FXML
    private TextField byQuery;
    @FXML
    private TextField byNamedQuery;

    @FXML
    private void readByID() throws IOException {

        Long carId = Long.valueOf(String.valueOf(Id.getText()));

        ListView listView = new ListView();

        Car car = new Car();
        CarDao carDao = new CarDao();
        car = carDao.getCarById(carId);

        ObservableList<String> items = listView.getItems();
        items.add("ID: " + car.getCarId() + " // " +
                car.getSeriesName() + " // " +
                car.getManufactureYear() + " m // " +
                car.getEngineDisplacement_L() + " L // " +
                car.getEnginePower_KW()+ " kW //");

        VBox vBox = new VBox();
        vBox.getChildren().add(listView);

        Stage stage = new Stage();

        Scene scene = new Scene(vBox, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
}
