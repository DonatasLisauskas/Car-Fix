package FXML_Controllers.Car_DB_FXML_Controllers;

import carfix.dao.CarDao;
import carfix.entities.Car;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CreateCarController {

    @FXML
    private TextField seriesName;

    @FXML
    private TextField yearsOfManufacture;

    @FXML
    private TextField engineDisplacement;

    @FXML
    private TextField power;

    @FXML
    private Label label;

    @FXML
    public void createCarButton() {
        CarDao carDao = new CarDao();
        carDao.createCar(new Car(seriesName.getText(), Long.valueOf(yearsOfManufacture.getText()), engineDisplacement.getText(), Long.valueOf(power.getText())));
    }
}
