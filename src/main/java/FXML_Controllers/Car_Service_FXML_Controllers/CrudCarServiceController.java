package FXML_Controllers.Car_Service_FXML_Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CrudCarServiceController implements Initializable {

    private static final Logger LOGGER = LogManager.getLogger(CrudCarServiceController.class);

    @FXML
    private void createCarServiceButton() throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/JavaFX/Car_Service_DB_FXML/CreateCarService.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mCreateCarService.fxml is opened !\u001B[0m");
        }
    }

    @FXML
    private void readCarServiceButton() throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/JavaFX/Car_Service_DB_FXML/ReadCarService.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mReadCarService.fxml is opened !\u001B[0m");
        }
    }

    @FXML
    private void updateButton() throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/JavaFX/Car_Service_DB_FXML/UpdateCarService.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mUpdateCarService.fxml is opened !\u001B[0m");
        }
    }

    @FXML
    private void deleteButton() throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/JavaFX/Car_Service_DB_FXML/DeleteCarService.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mDeleteCarService.fxml is opened !\u001B[0m");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
