package Visitor_Pattern;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class LoaderFXML {

    private static final Logger LOGGER = LogManager.getLogger(LoaderFXML.class);

    public static void loadFXML(String direction) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(LoaderFXML.class.getResource(direction));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            LOGGER.error(ex);
        }
    }

    public static void loadDatabaseUpdatedFXML() throws IOException {
        try {
            FXMLLoader fxmlLoader1 = new FXMLLoader(LoaderFXML.class.getResource("/JavaFX/DatabaseUpdated.fxml"));
            Parent root1 = (Parent) fxmlLoader1.load();
            Stage stage1 = new Stage();
            stage1.setScene(new Scene(root1));
            stage1.show();
        } catch (IOException ex) {
            LOGGER.error(ex);
        }
    }

    public static void loadInvalidValueFXML() throws IOException {
        try {
            FXMLLoader fxmlLoader1 = new FXMLLoader(LoaderFXML.class.getResource("/JavaFX/InvalidValue.fxml"));
            Parent root1 = (Parent) fxmlLoader1.load();
            Stage stage1 = new Stage();
            stage1.setScene(new Scene(root1));
            stage1.show();
        } catch (IOException ex) {
            LOGGER.error(ex);
        }
    }

    public static void databaseIsEmpty() throws IOException {
        try {
            FXMLLoader fxmlLoader1 = new FXMLLoader(LoaderFXML.class.getResource("/JavaFX/DatabaseIsEmpty.fxml"));
            Parent root1 = (Parent) fxmlLoader1.load();
            Stage stage1 = new Stage();
            stage1.setScene(new Scene(root1));
            stage1.show();
        } catch (IOException ex) {
            LOGGER.error(ex);
        }
    }
}
