package FXML_Controllers.Car_DB_FXML_Controllers;

import Facade_Pattern.DaoMaker;
import carfix.entities.Car;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class DeleteCarController extends DaoMaker {

    @FXML
    private TextField number;

    @FXML
    private void deleteButton() throws IOException {
        try {
            Car car = carDao.getCarById(Long.valueOf(number.getText()));
            carDao.deleteCar(car);
        } catch (RuntimeException e) {
        } // delete is completed successful, but throw Runtime exception JavaFX.
        finally {
            try {
                FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/JavaFX/DatabaseUpdated.fxml"));
                Parent root1 = (Parent) fxmlLoader1.load();
                Stage stage1 = new Stage();
                stage1.setScene(new Scene(root1));
                stage1.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
