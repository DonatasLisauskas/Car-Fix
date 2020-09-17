package FXML_Controllers.Car_Service_FXML_Controllers;

import Facade_Pattern.DaoMaker;
import Visitor_Pattern.LoaderFXML;
import carfix.entities.CarService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class UpdateCarServiceController extends DaoMaker {

    private static final Logger LOGGER = LogManager.getLogger(UpdateCarServiceController.class);

    @FXML
    private TextField id;

    @FXML
    private TextField serviceName;

    @FXML
    private TextField address;

    @FXML
    private TextField workTime;

    @FXML
    private TextField employeesNum;

    @FXML
    public void updateName() throws IOException {
        try {
            CarService carService = carServiceDao.getCarServiceById(Long.valueOf(id.getText()));
            carService.setName(serviceName.getText());
            carServiceDao.updateCarService(carService);
        } catch (RuntimeException ex) {
            LOGGER.error(ex);
        } // update is completed successful, but throw Runtime exception JavaFX.
        finally {
            LOGGER.info("\u001B[33mUPDATE CarService: Database is UPDATED by Name!\u001B[0m");
            try {
                LoaderFXML.loadDatabaseUpdatedFXML();
            } catch (IOException ex) {
                LOGGER.error(ex);
            }
        }
    }

    @FXML
    public void updateAddress() throws IOException {
        try {
            CarService carService = carServiceDao.getCarServiceById(Long.valueOf(id.getText()));
            carService.setAddress(address.getText());
            carServiceDao.updateCarService(carService);
        } catch (RuntimeException ex) {
            LOGGER.error(ex);
        } // update is completed successful, but throw Runtime exception JavaFX.
        finally {
            LOGGER.info("\u001B[33mUPDATE CarService: Database is UPDATED by Address!\u001B[0m");
            try {
                LoaderFXML.loadDatabaseUpdatedFXML();
            } catch (IOException ex) {
                LOGGER.error(ex);
            }
        }
    }

    @FXML
    public void updateWorkTime() throws IOException {
        try {
            CarService carService = carServiceDao.getCarServiceById(Long.valueOf(id.getText()));
            carService.setWorkTime(workTime.getText());
            carServiceDao.updateCarService(carService);
        } catch (RuntimeException ex) {
            LOGGER.error(ex);
        } // update is completed successful, but throw Runtime exception JavaFX.
        finally {
            LOGGER.info("\u001B[33mUPDATE CarService: Database is UPDATED by Work time!\u001B[0m");
            try {
                LoaderFXML.loadDatabaseUpdatedFXML();
            } catch (IOException ex) {
                LOGGER.error(ex);
            }
        }
    }

    @FXML
    public void updateEmployeesNum() throws IOException {
        try {
            CarService carService = carServiceDao.getCarServiceById(Long.valueOf(id.getText()));
            carService.setEmployeesNum(Long.valueOf(employeesNum.getText()));
            carServiceDao.updateCarService(carService);
        } catch (RuntimeException ex) {
            LOGGER.error(ex);
        } // update is completed successful, but throw Runtime exception JavaFX.
        finally {
            LOGGER.info("\u001B[33mUPDATE CarService: Database is UPDATED by Employess number!\u001B[0m");
            try {
                LoaderFXML.loadDatabaseUpdatedFXML();
            } catch (IOException ex) {
                LOGGER.error(ex);
            }
        }
    }
}
