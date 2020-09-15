package FXML_Controllers.Car_DB_FXML_Controllers;

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

public class CrudCarController extends Parent implements Initializable {

    private static final Logger LOGGER = LogManager.getLogger(CrudCarController.class);

    @FXML
    private void createCarButton() throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/JavaFX/Car_DB_FXML/CreateCar.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mCreateCar.fxml is opened !\u001B[0m");
        }
    }

    @FXML
    private void readCarButton() throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/JavaFX/Car_DB_FXML/ReadCar.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mReadCar.fxml is opened !\u001B[0m");
        }
    }

    @FXML
    private void updateCarButton() throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/JavaFX/Car_DB_FXML/UpdateCar.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mUpdateCar.fxml is opened !\u001B[0m");
        }
    }

    @FXML
    private void deleteCarButton() throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/JavaFX/Car_DB_FXML/DeleteCar.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mDeleteCar.fxml is opened !\u001B[0m");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
