package FXML_Controllers.Registration_FXML_Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CrudRegistrationController extends Parent implements Initializable {

    @FXML
    private void createRegistrationButton() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/JavaFX/Registration_DB_FXML/CreateRegistration.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void readRegistrationButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/JavaFX/Registration_DB_FXML/ReadRegistration.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void updateRegistrationButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/JavaFX/Registration_DB_FXML/UpdateRegistration.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    private void deleteRegistrationButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/JavaFX/Registration_DB_FXML/DeleteRegistration.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
