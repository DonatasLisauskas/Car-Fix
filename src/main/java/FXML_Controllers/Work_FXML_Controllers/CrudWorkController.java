package FXML_Controllers.Work_FXML_Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CrudWorkController extends Parent implements Initializable {

    @FXML
    private void createWorkButton() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/JavaFX/Work_DB_FXML/CreateWork.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void readWorkButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/JavaFX/Work_DB_FXML/ReadWork.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void updateWorkButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/JavaFX/Work_DB_FXML/UpdateWork.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void deleteWorkButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/JavaFX/Work_DB_FXML/DeleteWork.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
