package FXML_Controllers.Work_FXML_Controllers;

import Facade_Pattern.DaoMaker;
import Visitor_Pattern.LoaderFXML;
import carfix.entities.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class UpdateWorkController extends DaoMaker {

    private static final Logger LOGGER = LogManager.getLogger(UpdateWorkController.class);

    @FXML
    private TextField workID;

    @FXML
    private TextField price;

    @FXML
    private TextField carServiceID;

    @FXML
    private TextField carID;

    @FXML
    private TextField failureID;

    @FXML
    public void updatePrice() throws IOException {
        try {
            Work work = workDao.getWorkById(Long.valueOf(workID.getText()));
            work.setPrice(Long.valueOf(price.getText()));
            workDao.updateWork(work);
        } catch (RuntimeException ex) {
            LOGGER.error(ex);
        } // update is completed successful, but throw Runtime exception JavaFX.
        finally {
            LOGGER.info("\u001B[33mUPDATE Work: Database is UPDATED by Price!\u001B[0m");
            try {
                LoaderFXML.loadDatabaseUpdatedFXML();
            } catch (IOException ex) {
                LOGGER.error(ex);
            }
        }
    }

    @FXML
    public void updateCarServiceID() throws IOException {
        try {
            Work work = workDao.getWorkById(Long.valueOf(workID.getText()));
            CarService carService = carServiceDao.getCarServiceById(Long.valueOf(carServiceID.getText()));
            work.setCarService(carService);
            workDao.updateWork(work);
        } catch (RuntimeException ex) {
            LOGGER.error(ex);
        } // update is completed successful, but throw Runtime exception JavaFX.
        finally {
            LOGGER.info("\u001B[33mUPDATE Work: Database is UPDATED by CarServiceID!\u001B[0m");
            try {
                LoaderFXML.loadDatabaseUpdatedFXML();
            } catch (IOException ex) {
                LOGGER.error(ex);
            }
        }
    }

    @FXML
    public void updateCarID() throws IOException {
        try {
            Work work = workDao.getWorkById(Long.valueOf(workID.getText()));
            Car car = carDao.getCarById(Long.valueOf(carID.getText()));
            work.setCar(car);
            workDao.updateWork(work);
        } catch (RuntimeException ex) {
            LOGGER.error(ex);
        } // update is completed successful, but throw Runtime exception JavaFX.
        finally {
            LOGGER.info("\u001B[33mUPDATE Work: Database is UPDATED by CarID!\u001B[0m");
            try {
                LoaderFXML.loadDatabaseUpdatedFXML();
            } catch (IOException ex) {
                LOGGER.error(ex);
            }
        }
    }

    @FXML
    public void updateFailureID() throws IOException {
        try {
            Work work = workDao.getWorkById(Long.valueOf(workID.getText()));
            Failure failure = failureDao.getFailureById(Long.valueOf(failureID.getText()));
            work.setFailure(failure);
            workDao.updateWork(work);
        } catch (RuntimeException ex) {
            LOGGER.error(ex);
        } // update is completed successful, but throw Runtime exception JavaFX.
        finally {
            LOGGER.info("\u001B[33mUPDATE Work: Database is UPDATED by FailureID!\u001B[0m");
            try {
                LoaderFXML.loadDatabaseUpdatedFXML();
            } catch (IOException ex) {
                LOGGER.error(ex);
            }
        }
    }
}
