package FXML_Controllers.Car_DB_FXML_Controllers;

import carfix.dao.CarDao;
import carfix.entities.Car;
import carfix.utils.HibernateUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class CreateCarController {

    private static final Logger LOGGER = LogManager.getLogger(CreateCarController.class);

    @FXML
    private TextField seriesName;

    @FXML
    private TextField yearsOfManufacture;

    @FXML
    private TextField engineDisplacement;

    @FXML
    private TextField power;

    @FXML
    public void createCarButton() throws IOException {
        CarDao carDao = new CarDao();
        carDao.createCar(new Car(seriesName.getText(), Long.valueOf(yearsOfManufacture.getText()), engineDisplacement.getText(), Long.valueOf(power.getText())));
        try {
            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/JavaFX/DatabaseUpdated.fxml"));
            Parent root1 = (Parent) fxmlLoader1.load();
            Stage stage1 = new Stage();
            stage1.setScene(new Scene(root1));
            stage1.show();
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            if (null != HibernateUtil.getSessionFactory())
                HibernateUtil.shutdown();
            LOGGER.info("\u001B[33mCREATE Car: Database is updated!\u001B[0m");
        }
    }
}
