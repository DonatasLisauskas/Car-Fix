package FXML_Controllers.Detail_FXML_Controllers;

import carfix.dao.CarDao;
import carfix.dao.DetailDao;
import carfix.entities.Car;
import carfix.entities.Detail;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CreateDetailController {

    @FXML
    private TextField detailName;

    @FXML
    private TextField price;

    @FXML
    private Car car;

    @FXML
    private TextField carId;

    @FXML
    private Label label;

    @FXML
    public void createDetailButton() {
        DetailDao detailDao = new DetailDao();
        detailDao.createDetail(new Detail(detailName.getText(), Long.valueOf(price.getText()), car.getCarId()));
    }
}
