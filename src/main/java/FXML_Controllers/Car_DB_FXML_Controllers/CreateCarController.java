package FXML_Controllers.Car_DB_FXML_Controllers;

import Visitor_Pattern.LoaderFXML;
import carfix.dao.CarDao;
import carfix.entities.Car;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class CreateCarController {

    private static final Logger LOGGER = LogManager.getLogger(CreateCarController.class);

    @FXML
    private TextField seriesName;

    @FXML
    private TextField yearsOfManufacture;

    @FXML
    private TextField engineDisplacement;

    @FXML
    private TextField power;

    @FXML
    public void createCarButton() throws IOException {
        CarDao carDao = new CarDao();
        carDao.createCar(new Car(seriesName.getText(), Long.valueOf(yearsOfManufacture.getText()), engineDisplacement.getText(), Long.valueOf(power.getText())));
        try {
            LoaderFXML.loadDatabaseUpdatedFXML();
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mCREATE Car: Database is updated!\u001B[0m");
        }
    }
}
