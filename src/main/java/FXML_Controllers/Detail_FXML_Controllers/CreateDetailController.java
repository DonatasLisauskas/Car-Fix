package FXML_Controllers.Detail_FXML_Controllers;

import Facade_Pattern.DaoMaker;
import Visitor_Pattern.LoaderFXML;
import carfix.entities.Car;
import carfix.entities.Detail;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;

public class CreateDetailController extends DaoMaker {

    private static final Logger LOGGER = LogManager.getLogger(CreateDetailController.class);

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
            LoaderFXML.loadDatabaseUpdatedFXML();
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mCREATE Detail: Database is updated!\u001B[0m");
        }
    }
}
