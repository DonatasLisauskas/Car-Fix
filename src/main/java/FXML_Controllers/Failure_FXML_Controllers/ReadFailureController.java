package FXML_Controllers.Failure_FXML_Controllers;

import Facade_Pattern.DaoMaker;
import carfix.entities.Failure;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ReadFailureController extends DaoMaker {

    @FXML
    private TextField Id;
    @FXML
    private TextField byQuery;
    @FXML
    private TextField byNamedQuery;

    @FXML
    private void readByID() throws IOException {

        Long failureId = Long.valueOf(String.valueOf(Id.getText()));

        ListView listView = new ListView();

        Failure failure = failureDao.getFailureById(failureId);

        ObservableList<Failure> items = listView.getItems();
        items.add(failure);

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

        ObservableList<Failure> items = listView.getItems();

        items.addAll(failureDao.getListOfFailureByQueries(query));

        VBox vBox = new VBox();
        vBox.getChildren().add(listView);

        Stage stage = new Stage();

        Scene scene = new Scene(vBox, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
}
