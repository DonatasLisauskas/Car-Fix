package FXML_Controllers.Car_Service_FXML_Controllers;

import Facade_Pattern.DaoMaker;
import Visitor_Pattern.LoaderFXML;
import carfix.entities.CarService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;


public class CreateCarServiceController extends DaoMaker {

    private static final Logger LOGGER = LogManager.getLogger(CreateCarServiceController.class);

    @FXML
    private TextField nameService;

    @FXML
    private TextField address;

    @FXML
    private TextField workTime;

    @FXML
    private TextField employeesNumber;

    @FXML
    private void createCarServiceButton() {
        carServiceDao.createCarService(new CarService(nameService.getText(), address.getText(), workTime.getText(), Long.valueOf(employeesNumber.getText())));
        try {
            LoaderFXML.loadDatabaseUpdatedFXML();
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mCREATE CarService: Database is updated!\u001B[0m");
        }
    }
}
