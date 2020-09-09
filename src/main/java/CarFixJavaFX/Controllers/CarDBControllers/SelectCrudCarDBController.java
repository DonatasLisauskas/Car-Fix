package CarFixJavaFX.Controllers.CarDBControllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SelectCrudCarDBController extends Parent implements Initializable {

    @FXML
    private TextField textField;
    @FXML
    private Label label;

    @FXML
    private void createButton() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/JavaFX/CarDB/CreateCarDB.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void readButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/JavaFX/CarDB/ReadCarDB.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void updateButton() {

    }

    @FXML
    private void deleteButton() {

    }

    @FXML
    private void backButton() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
