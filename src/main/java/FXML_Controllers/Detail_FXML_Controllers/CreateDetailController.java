package FXML_Controllers.Detail_FXML_Controllers;

import Facade_Pattern.DaoMaker;
import carfix.entities.Car;
import carfix.entities.Detail;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateDetailController extends DaoMaker {

    @FXML
    private TextField detailName;

    @FXML
    private TextField price;

    @FXML
    private TextField carId;

    @FXML
    public void createDetailButton() {

        Car car = carDao.getCarById(Long.valueOf(carId.getText()));

        detailDao.createDetail(new Detail(detailName.getText(), Long.valueOf(price.getText()), car));
        try {
            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/JavaFX/DatabaseUpdated.fxml"));
            Parent root1 = (Parent) fxmlLoader1.load();
            Stage stage1 = new Stage();
            stage1.setScene(new Scene(root1));
            stage1.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
