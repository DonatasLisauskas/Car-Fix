import carfix.utils.HibernateUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Main extends Application {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        LOGGER.info("\u001B[33mInitializing app!\u001B[0m");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("JavaFX/SelectDB.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (
                IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mSELECT DB: Running SelectDB.fxml \u001B[0m");
        }
    }
    @Override
    public void stop() throws Exception {
        LOGGER.info("\u001B[33mStopping app!\u001B[0m");
        if (null != HibernateUtil.getSessionFactory())
            HibernateUtil.shutdown();
    }
}
