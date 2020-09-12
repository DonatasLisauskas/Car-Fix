package FXML_Controllers.Detail_FXML_Controllers;

import Facade_Pattern.DaoMaker;
import carfix.dao.CarDao;
import carfix.entities.Car;
import carfix.entities.Detail;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdateDetailController extends DaoMaker {

    @FXML
    private TextField detailID;

    @FXML
    private TextField detailName;

    @FXML
    private TextField price;

    @FXML
    private TextField carID;

    @FXML
    public void updateName() throws IOException {
        try {
            Detail detail = detailDao.getDetailById(Long.valueOf(detailID.getText()));
            detail.setDetailName(detailName.getText());
            detailDao.updateDetail(detail);
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
    public void updatePrice() throws IOException {
        try {
            Detail detail = detailDao.getDetailById(Long.valueOf(detailID.getText()));
            detail.setPrice(Long.valueOf(price.getText()));
            detailDao.updateDetail(detail);
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
            Detail detail = detailDao.getDetailById(Long.valueOf(detailID.getText()));
            Car car = carDao.getCarById(Long.valueOf(carID.getText()));
            detail.setCar(car);
            detailDao.updateDetail(detail);
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
