package FXML_Controllers.Registration_FXML_Controllers;

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

public class CrudRegistrationController extends Parent implements Initializable {

    private static final Logger LOGGER = LogManager.getLogger(CrudRegistrationController.class);

    @FXML
    private void createRegistrationButton() throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/JavaFX/Registration_DB_FXML/CreateRegistration.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mCreateRegistration.fxml is opened !\u001B[0m");
        }
    }

    @FXML
    private void readRegistrationButton() throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/JavaFX/Registration_DB_FXML/ReadRegistration.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mReadRegistration.fxml is opened !\u001B[0m");
        }
    }

    @FXML
    private void updateRegistrationButton() throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/JavaFX/Registration_DB_FXML/UpdateRegistration.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mUpdateRegistration.fxml is opened !\u001B[0m");
        }
    }

    @FXML
    private void deleteRegistrationButton() throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/JavaFX/Registration_DB_FXML/DeleteRegistration.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mDeleteRegistration.fxml is opened !\u001B[0m");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
