package FXML_Controllers.Registration_FXML_Controllers;

import Facade_Pattern.DaoMaker;
import carfix.entities.Registration;
import carfix.entities.Work;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ReadRegistrationController extends DaoMaker {

    @FXML
    private TextField Id;
    @FXML
    private TextField byQuery;
    @FXML
    private TextField byNamedQuery;

    @FXML
    private void readByID() throws IOException {

        Long registrationID = Long.valueOf(String.valueOf(Id.getText()));

        ListView listView = new ListView();

        Registration registration = registrationDao.getRegistrationById(registrationID);

        ObservableList<Registration> items = listView.getItems();
        items.add(registration);

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

        ObservableList<Registration> items = listView.getItems();

        items.addAll(registrationDao.getListOfRegistrationByQueries(query));

        VBox vBox = new VBox();
        vBox.getChildren().add(listView);

        Stage stage = new Stage();

        Scene scene = new Scene(vBox, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
}
