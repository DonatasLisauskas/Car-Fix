package FXML_Controllers.Detail_FXML_Controllers;

import carfix.dao.CarDao;
import carfix.dao.DetailDao;
import carfix.entities.Car;
import carfix.entities.Detail;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class UpdateDetailController {

    @FXML
    private TextField id;

    @FXML
    private TextField detailName;

    @FXML
    private TextField price;

    @FXML
    private Car car;

    @FXML
    private TextField carId;

    @FXML
    public void updateName() {
        try {
            Detail detail = new Detail();
            DetailDao detailDao = new DetailDao();
            detail = detailDao.getDetailById(Long.valueOf(id.getText()));
            detail.setDetailName(detailName.getText());
            detailDao.updateDetail(detail);
        } catch (RuntimeException e) {
        } // update is completed successful, but throw Runtime exception JavaFX.
    }

    @FXML
    public void updatePrice() {
        try {
            Detail detail = new Detail();
            DetailDao detailDao = new DetailDao();
            detail = detailDao.getDetailById(Long.valueOf(id.getText()));
            detail.setPrice(Long.valueOf(price.getText()));
            detailDao.updateDetail(detail);
        } catch (RuntimeException e) {
        } // update is completed successful, but throw Runtime exception JavaFX.
    }

    @FXML
    public void updateCarId() {
        try {
            Detail detail = new Detail();
            DetailDao detailDao = new DetailDao();
            detail = detailDao.getDetailById(Long.valueOf(id.getText()));
            detail.setCar(car.getCarId());
            detailDao.updateDetail(detail);
        } catch (RuntimeException e) {
        } // update is completed successful, but throw Runtime exception JavaFX.
    }
}
