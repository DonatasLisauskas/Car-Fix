package FXML_Controllers.Car_DB_FXML_Controllers;

import carfix.dao.CarDao;
import carfix.entities.Car;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class UpdateCarController {

    @FXML
    private TextField id;

    @FXML
    private TextField seriesName;

    @FXML
    private TextField yearsOfManufacture;

    @FXML
    private TextField engineDisplacement;

    @FXML
    private TextField power;

    @FXML
    public void updateName() {
        try {
            Car car = new Car();
            CarDao carDao = new CarDao();
            car = carDao.getCarById(Long.valueOf(id.getText()));
            car.setSeriesName(seriesName.getText());
            carDao.updateCar(car);
        } catch (RuntimeException e) {
        } // update is completed successful, but throw Runtime exception JavaFX.
    }

    @FXML
    public void updateYears() {
        try {
            Car car = new Car();
            CarDao carDao = new CarDao();
            car = carDao.getCarById(Long.valueOf(id.getText()));
            car.setManufactureYear(Long.valueOf(yearsOfManufacture.getText()));
            carDao.updateCar(car);
        } catch (RuntimeException e) {
        } // update is completed successful, but throw Runtime exception JavaFX.
    }

    @FXML
    public void updateDisplacement() {
        try {
            Car car = new Car();
            CarDao carDao = new CarDao();
            car = carDao.getCarById(Long.valueOf(id.getText()));
            car.setEngineDisplacement_L(engineDisplacement.getText());
            carDao.updateCar(car);
        } catch (RuntimeException e) {
        } // update is completed successful, but throw Runtime exception JavaFX.
    }

    @FXML
    public void updatePower() {
        try {
            Car car = new Car();
            CarDao carDao = new CarDao();
            car = carDao.getCarById(Long.valueOf(id.getText()));
            car.setEnginePower_KW(Long.valueOf(power.getText()));
            carDao.updateCar(car);
        } catch (RuntimeException e) {
        } // update is completed successful, but throw Runtime exception JavaFX.
    }
}
