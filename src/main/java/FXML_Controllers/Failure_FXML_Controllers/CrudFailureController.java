package FXML_Controllers.Failure_FXML_Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CrudFailureController extends Parent implements Initializable {

    @FXML
    private void createFailureButton() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/JavaFX/Failure_DB_FXML/CreateFailure.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void readFailureButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/JavaFX/Failure_DB_FXML/ReadFailure.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void updateFailureButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/JavaFX/Failure_DB_FXML/UpdateFailure.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void deleteFailureButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/JavaFX/Failure_DB_FXML/DeleteFailure.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
