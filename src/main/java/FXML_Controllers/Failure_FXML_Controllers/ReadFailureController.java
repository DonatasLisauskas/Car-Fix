package FXML_Controllers.Failure_FXML_Controllers;

import carfix.dao.FailureDao;
import carfix.entities.Failure;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ReadFailureController {

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

        Failure failure = new Failure();
        FailureDao failureDao = new FailureDao();
        failure = failureDao.getFailureById(failureId);

        ObservableList<String> items = listView.getItems();
        items.add("ID: " + failure.getFailureId() + " // " +
                failure.getFailureName() + " //");

        VBox vBox = new VBox();
        vBox.getChildren().add(listView);

        Stage stage = new Stage();

        Scene scene = new Scene(vBox, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
}
