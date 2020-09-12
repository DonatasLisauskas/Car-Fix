package FXML_Controllers.Car_DB_FXML_Controllers;

import carfix.dao.CarDao;
import carfix.entities.Car;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

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
    public void updateName() throws IOException {
        try {
            Car car = new Car();
            CarDao carDao = new CarDao();
            car = carDao.getCarById(Long.valueOf(id.getText()));
            car.setSeriesName(seriesName.getText());
            carDao.updateCar(car);
        } catch (RuntimeException e) {
        } // update is completed successful, but throw Runtime exception JavaFX.
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

    @FXML
    public void updateYears() throws IOException {
        try {
            Car car = new Car();
            CarDao carDao = new CarDao();
            car = carDao.getCarById(Long.valueOf(id.getText()));
            car.setManufactureYear(Long.valueOf(yearsOfManufacture.getText()));
            carDao.updateCar(car);
        } catch (RuntimeException e) {
        } // update is completed successful, but throw Runtime exception JavaFX.
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

    @FXML
    public void updateDisplacement() throws IOException {
        try {
            Car car = new Car();
            CarDao carDao = new CarDao();
            car = carDao.getCarById(Long.valueOf(id.getText()));
            car.setEngineDisplacement_L(engineDisplacement.getText());
            carDao.updateCar(car);
        } catch (RuntimeException e) {
        } // update is completed successful, but throw Runtime exception JavaFX.
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

    @FXML
    public void updatePower() throws IOException {
        try {
            Car car = new Car();
            CarDao carDao = new CarDao();
            car = carDao.getCarById(Long.valueOf(id.getText()));
            car.setEnginePower_KW(Long.valueOf(power.getText()));
            carDao.updateCar(car);
        } catch (RuntimeException e) {
        } // update is completed successful, but throw Runtime exception JavaFX.
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
