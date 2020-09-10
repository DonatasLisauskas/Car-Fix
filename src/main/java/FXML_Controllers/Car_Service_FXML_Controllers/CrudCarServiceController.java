package FXML_Controllers.Car_Service_FXML_Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CrudCarServiceController implements Initializable {

        @FXML
        private void createCarServiceButton() throws IOException {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/JavaFX/Car_Service_DB_FXML/CreateCarService.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }

        @FXML
        private void readCarServiceButton() throws IOException {
            /*FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/JavaFX/Car_DB_FXML/.fxml"));*/
            /*Parent root = (Parent) fxmlLoader.load();*/
            Stage stage = new Stage();
            /*stage.setScene(new Scene(root));*/
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
