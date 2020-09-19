package FXML_Controllers.Detail_FXML_Controllers;

import Facade_Pattern.DaoMaker;
import carfix.entities.Detail;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class ReadDetailController extends DaoMaker {

    private static final Logger LOGGER = LogManager.getLogger(ReadDetailController.class);

    @FXML
    private TextField Id;
    @FXML
    private TextField byQuery;
    @FXML
    private TextField byNamedQuery;

    @FXML
    private void readByID() throws IOException {
        try {
            Long detailID = Long.valueOf(String.valueOf(Id.getText()));

            ListView listView = new ListView();

            Detail detail = detailDao.getDetailById(detailID);

            ObservableList<Detail> items = listView.getItems();
            items.add(detail);

            VBox vBox = new VBox();
            vBox.getChildren().add(listView);
            Stage stage = new Stage();
            Scene scene = new Scene(vBox, 500, 500);
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mREAD Detail: Database is READ by ID!\u001B[0m");
        }
    }

    @FXML
    private void readByQuery() throws IOException {
        try {
            String query = String.valueOf((byQuery.getText()));

            ListView listView = new ListView();

            ObservableList<Detail> items = listView.getItems();

            items.addAll(detailDao.getListOfDetailByQueries(query));

            VBox vBox = new VBox();
            vBox.getChildren().add(listView);
            Stage stage = new Stage();
            Scene scene = new Scene(vBox, 500, 500);
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mREAD Detail: Database is READ by Query!\u001B[0m");
        }
    }
}
