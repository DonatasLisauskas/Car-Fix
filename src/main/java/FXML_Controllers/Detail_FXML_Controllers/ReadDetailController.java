package FXML_Controllers.Detail_FXML_Controllers;

import carfix.dao.DetailDao;
import carfix.entities.Detail;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ReadDetailController {

    @FXML
    private TextField Id;
    @FXML
    private TextField byQuery;
    @FXML
    private TextField byNamedQuery;

    @FXML
    private void readByID() throws IOException {

        Long detailId = Long.valueOf(String.valueOf(Id.getText()));

        ListView listView = new ListView();

        Detail detail = new Detail();
        DetailDao detailDao = new DetailDao();
        detail = detailDao.getDetailById(detailId);

        ObservableList<String> items = listView.getItems();
        items.add("ID: " + detail.getDetailId() + " // " +
                detail.getDetailName() + " // " +
                detail.getCar().getCarId() + " //");

        VBox vBox = new VBox();
        vBox.getChildren().add(listView);

        Stage stage = new Stage();

        Scene scene = new Scene(vBox, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
}
