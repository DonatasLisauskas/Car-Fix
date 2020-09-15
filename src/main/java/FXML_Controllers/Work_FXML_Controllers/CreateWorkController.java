package FXML_Controllers.Work_FXML_Controllers;

import Facade_Pattern.DaoMaker;
import carfix.entities.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class CreateWorkController extends DaoMaker {

    private static final Logger LOGGER = LogManager.getLogger(CreateWorkController.class);

    @FXML
    private TextField price;

    @FXML
    private TextField carServiceID;

    @FXML
    private TextField carID;

    @FXML
    private TextField failureID;

    @FXML
    public void createWorkButton() {

        CarService carService = carServiceDao.getCarServiceById(Long.valueOf(carServiceID.getText()));
        Car car = carDao.getCarById(Long.valueOf(carID.getText()));
        Failure failure = failureDao.getFailureById(Long.valueOf(failureID.getText()));

        workDao.createWork(new Work(Long.valueOf(price.getText()), carService, car, failure));
        try {
            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/JavaFX/DatabaseUpdated.fxml"));
            Parent root1 = (Parent) fxmlLoader1.load();
            Stage stage1 = new Stage();
            stage1.setScene(new Scene(root1));
            stage1.show();
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mCREATE Work: Database is updated!\u001B[0m");
        }
    }
}
