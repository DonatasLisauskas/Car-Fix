package FXML_Controllers.Car_Service_FXML_Controllers;

import Facade_Pattern.DaoMaker;
import carfix.entities.Car;
import carfix.entities.CarService;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ReadCarServiceController extends DaoMaker {

    @FXML
    private TextField Id;
    @FXML
    private TextField byQuery;
    @FXML
    private TextField byNamedQuery;

    @FXML
    private void readByID() throws IOException {

        Long carServiceId = Long.valueOf(String.valueOf(Id.getText()));

        ListView listView = new ListView();

        CarService carService = carServiceDao.getCarServiceById(carServiceId);

        ObservableList<CarService> items = listView.getItems();
        items.add(carService);

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

        ObservableList<CarService> items = listView.getItems();

        items.addAll(carServiceDao.getListOfCarServiceByQueries(query));

        VBox vBox = new VBox();
        vBox.getChildren().add(listView);

        Stage stage = new Stage();

        Scene scene = new Scene(vBox, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
}
