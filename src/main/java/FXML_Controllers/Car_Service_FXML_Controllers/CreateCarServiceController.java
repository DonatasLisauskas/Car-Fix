package FXML_Controllers.Car_Service_FXML_Controllers;

import carfix.dao.CarServiceDao;
import carfix.entities.CarService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class CreateCarServiceController {

    @FXML
    private TextField nameService;

    @FXML
    private TextField address;

    @FXML
    private TextField workTime;

    @FXML
    private TextField employeesNumber;

    @FXML
    private void createCarServiceButton() {
        CarServiceDao carServiceDao = new CarServiceDao();
        carServiceDao.createCarService(new CarService(nameService.getText(), address.getText(), workTime.getText(), Long.valueOf(employeesNumber.getText())));
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
