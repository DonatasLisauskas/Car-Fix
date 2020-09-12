package FXML_Controllers.Car_Service_FXML_Controllers;

import Facade_Pattern.DaoMaker;
import carfix.dao.CarDao;
import carfix.entities.Car;
import carfix.entities.CarService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdateCarServiceController extends DaoMaker {

    @FXML
    private TextField id;

    @FXML
    private TextField serviceName;

    @FXML
    private TextField address;

    @FXML
    private TextField workTime;

    @FXML
    private TextField employeesNum;

    @FXML
    public void updateName() throws IOException {
        try {
            CarService carService = carServiceDao.getCarServiceById(Long.valueOf(id.getText()));
            carService.setName(serviceName.getText());
            carServiceDao.updateCarService(carService);
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
    public void updateAddress() throws IOException {
        try {
            CarService carService = carServiceDao.getCarServiceById(Long.valueOf(id.getText()));
            carService.setAddress(address.getText());
            carServiceDao.updateCarService(carService);
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
    public void updateWorkTime() throws IOException {
        try {
            CarService carService = carServiceDao.getCarServiceById(Long.valueOf(id.getText()));
            carService.setWorkTime(workTime.getText());
            carServiceDao.updateCarService(carService);
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
    public void updateEmployeesNum() throws IOException {
        try {
            CarService carService = carServiceDao.getCarServiceById(Long.valueOf(id.getText()));
            carService.setEmployeesNum(Long.valueOf(employeesNum.getText()));
            carServiceDao.updateCarService(carService);
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
