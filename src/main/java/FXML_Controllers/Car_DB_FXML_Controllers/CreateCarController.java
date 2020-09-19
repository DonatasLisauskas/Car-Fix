package FXML_Controllers.Car_DB_FXML_Controllers;

import Facade_Pattern.DaoMaker;
import Visitor_Pattern.LoaderFXML;
import carfix.entities.Car;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lombok.NonNull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class CreateCarController extends DaoMaker {

    private static final Logger LOGGER = LogManager.getLogger(CreateCarController.class);

    @FXML
    @NonNull
    private TextField seriesName;

    @FXML
    @NonNull
    private TextField yearsOfManufacture;

    @FXML
    @NonNull
    private TextField engineDisplacement;

    @FXML
    @NonNull
    private TextField power;

    @FXML
    public void createCarButton() throws IOException {
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
