package FXML_Controllers.Failure_FXML_Controllers;

import Facade_Pattern.DaoMaker;
import carfix.entities.Failure;
import carfix.utils.HibernateUtil;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReadFailureController extends DaoMaker {

    private static final Logger LOGGER = LogManager.getLogger(ReadFailureController.class);

    @FXML
    private TextField Id;
    @FXML
    private TextField byQuery;
    @FXML
    private TextField byNamedQuery;

    @FXML
    private void readByID() {
        try {
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
        } catch (Exception ex) {
            LOGGER.error(ex);
        } finally {
            if (null != HibernateUtil.getSessionFactory())
                HibernateUtil.shutdown();
            LOGGER.info("\u001B[33mREAD Failure: Database is READED by ID!\u001B[0m");
        }
    }

    @FXML
    private void readByQuery() {
        try {
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
        } catch (Exception ex) {
            LOGGER.error(ex);
        } finally {
            if (null != HibernateUtil.getSessionFactory())
                HibernateUtil.shutdown();
            LOGGER.info("\u001B[33mREAD Failure: Database is READED by Query!\u001B[0m");
        }
    }
}
