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

public class UpdateCarController extends DaoMaker {

    private static final Logger LOGGER = LogManager.getLogger(UpdateCarController.class);

    @FXML
    @NonNull
    private TextField id;

    @FXML
    @NonNull
    private TextField seriesName;

    @FXML
    @NonNull
    private TextField yearsOfManufacture;

    @FXML
    private TextField engineDisplacement;

    @FXML
    @NonNull
    private TextField power;

    @FXML
    public void updateName() throws IOException {
        try {
            Car car = carDao.getCarById(Long.valueOf(id.getText()));
            car.setSeriesName(seriesName.getText());
            carDao.updateCar(car);
        } catch (AssertionError ex) {
            ex.printStackTrace();
            LOGGER.error(ex);
        } // update is completed successful, but throw Runtime exception JavaFX.
        finally {
            LOGGER.info("\u001B[33mUPDATE Car: Database is UPDATED by Name!\u001B[0m");
            try {
                LoaderFXML.loadDatabaseUpdatedFXML();
            } catch (IOException ex) {
                LOGGER.error(ex);
            }
        }
    }

    @FXML
    public void updateYears() throws IOException {
        try {
            Car car = carDao.getCarById(Long.valueOf(id.getText()));
            car.setManufactureYear(Long.valueOf(yearsOfManufacture.getText()));
            carDao.updateCar(car);
        } catch (RuntimeException ex) {
            LOGGER.error(ex);
        } // update is completed successful, but throw Runtime exception JavaFX.
        finally {
            LOGGER.info("\u001B[33mUPDATE Car: Database is UPDATED by Years!\u001B[0m");
            try {
                LoaderFXML.loadDatabaseUpdatedFXML();
            } catch (IOException ex) {
                LOGGER.error(ex);
            }
        }
    }

    @FXML
    public void updateDisplacement() throws IOException {
        try {
            Car car = carDao.getCarById(Long.valueOf(id.getText()));
            car.setEngineDisplacement_L(engineDisplacement.getText());
            carDao.updateCar(car);
        } catch (RuntimeException ex) {
            LOGGER.error(ex);
        } // update is completed successful, but throw Runtime exception JavaFX.
        finally {
            LOGGER.info("\u001B[33mUPDATE Car: Database is UPDATED by Displacement!\u001B[0m");
            try {
                LoaderFXML.loadDatabaseUpdatedFXML();
            } catch (IOException ex) {
                LOGGER.error(ex);
            }
        }
    }

    @FXML
    public void updatePower() throws IOException {
        try {
            Car car = carDao.getCarById(Long.valueOf(id.getText()));
            car.setEnginePower_KW(Long.valueOf(power.getText()));
            carDao.updateCar(car);
        } catch (RuntimeException ex) {
            LOGGER.error(ex);
        } // update is completed successful, but throw Runtime exception JavaFX.
        finally {
            LOGGER.info("\u001B[33mUPDATE Car: Database is UPDATED by Power!\u001B[0m");
            try {
                LoaderFXML.loadDatabaseUpdatedFXML();
            } catch (IOException ex) {
                LOGGER.error(ex);
            }
        }
    }
}
