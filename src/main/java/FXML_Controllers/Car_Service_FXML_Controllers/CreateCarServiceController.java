package FXML_Controllers.Car_Service_FXML_Controllers;

import carfix.dao.CarServiceDao;
import carfix.entities.CarService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


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
    }
}
