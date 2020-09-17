package FXML_Controllers.Car_Service_FXML_Controllers;

import Facade_Pattern.DaoMaker;

import Visitor_Pattern.LoaderFXML;
import carfix.entities.CarService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class DeleteCarServiceController extends DaoMaker {

    private static final Logger LOGGER = LogManager.getLogger(DeleteCarServiceController.class);

    @FXML
    private TextField number;

    @FXML
    private void deleteButton() throws IOException {
        try {
            CarService carService = carServiceDao.getCarServiceById(Long.valueOf(number.getText()));
            carServiceDao.deleteCarService(carService);
        } catch (RuntimeException ex) {
            LOGGER.error(ex);
        }// delete is completed successful, but throw Runtime exception JavaFX.
        finally {
            LOGGER.info("\u001B[33mDELETE CarService: Database is updated!\u001B[0m");
            try {
                LoaderFXML.loadDatabaseUpdatedFXML();
            } catch (IOException ex) {
                LOGGER.error(ex);
            }
        }
    }
}
