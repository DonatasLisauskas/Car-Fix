package FXML_Controllers.Car_DB_FXML_Controllers;

import Facade_Pattern.DaoMaker;
import Visitor_Pattern.LoaderFXML;
import carfix.entities.Car;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.transaction.Transactional;
import java.io.IOException;

public class DeleteCarController extends DaoMaker {

    private static final Logger LOGGER = LogManager.getLogger(DeleteCarController.class);

    @FXML
    private TextField number;

    @FXML
    @Transactional
    private void deleteButton() throws IOException {
        try {
            Car car = carDao.getCarById(Long.valueOf(number.getText()));
            carDao.deleteCar(car);
        } catch (RuntimeException ex) {
            LOGGER.error(ex);
        }// delete is completed successful, but throw Runtime exception JavaFX.
        finally {
            LOGGER.info("\u001B[33mDELETE Car: Database is updated!\u001B[0m");
            try {
                LoaderFXML.loadDatabaseUpdatedFXML();
            } catch (IOException ex) {
                LOGGER.error(ex);
            }
        }
    }
}
