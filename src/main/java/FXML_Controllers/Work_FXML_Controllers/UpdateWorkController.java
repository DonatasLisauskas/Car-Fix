package FXML_Controllers.Work_FXML_Controllers;

import Facade_Pattern.DaoMaker;
import carfix.entities.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdateWorkController extends DaoMaker {

    @FXML
    private TextField workID;

    @FXML
    private TextField price;

    @FXML
    private TextField carServiceID;

    @FXML
    private TextField carID;

    @FXML
    private TextField failureID;

    @FXML
    public void updatePrice() throws IOException {
        try {
            Work work = workDao.getWorkById(Long.valueOf(workID.getText()));
            work.setPrice(Long.valueOf(price.getText()));
            workDao.updateWork(work);
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
    public void updateCarServiceID() throws IOException {
        try {
            Work work = workDao.getWorkById(Long.valueOf(workID.getText()));
            CarService carService = carServiceDao.getCarServiceById(Long.valueOf(carServiceID.getText()));
            work.setCarService(carService);
            workDao.updateWork(work);
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
    public void updateCarID() throws IOException {
        try {
            Work work = workDao.getWorkById(Long.valueOf(workID.getText()));
            Car car = carDao.getCarById(Long.valueOf(carID.getText()));
            work.setCar(car);
            workDao.updateWork(work);
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
    public void updateFailureID() throws IOException {
        try {
            Work work = workDao.getWorkById(Long.valueOf(workID.getText()));
            Failure failure = failureDao.getFailureById(Long.valueOf(failureID.getText()));
            work.setFailure(failure);
            workDao.updateWork(work);
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
