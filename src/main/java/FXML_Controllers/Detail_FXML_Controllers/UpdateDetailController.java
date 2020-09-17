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

public class UpdateDetailController extends DaoMaker {

    private static final Logger LOGGER = LogManager.getLogger(UpdateDetailController.class);

    @FXML
    private TextField detailID;

    @FXML
    private TextField detailName;

    @FXML
    private TextField price;

    @FXML
    private TextField carID;

    @FXML
    public void updateName() throws IOException {
        try {
            Detail detail = detailDao.getDetailById(Long.valueOf(detailID.getText()));
            detail.setDetailName(detailName.getText());
            detailDao.updateDetail(detail);
        } catch (RuntimeException ex) {
            LOGGER.error(ex);
        } // update is completed successful, but throw Runtime exception JavaFX.
        finally {
            LOGGER.info("\u001B[33mUPDATE Detail: Database is UPDATED by Name!\u001B[0m");
            try {
                LoaderFXML.loadDatabaseUpdatedFXML();
            } catch (IOException ex) {
                LOGGER.error(ex);
            }
        }
    }

    @FXML
    public void updatePrice() throws IOException {
        try {
            Detail detail = detailDao.getDetailById(Long.valueOf(detailID.getText()));
            detail.setPrice(Long.valueOf(price.getText()));
            detailDao.updateDetail(detail);
        } catch (RuntimeException ex) {
            LOGGER.error(ex);
        } // update is completed successful, but throw Runtime exception JavaFX.
        finally {
            LOGGER.info("\u001B[33mUPDATE Detail: Database is UPDATED by Price!\u001B[0m");
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
            Detail detail = detailDao.getDetailById(Long.valueOf(detailID.getText()));
            Car car = carDao.getCarById(Long.valueOf(carID.getText()));
            detail.setCar(car);
            detailDao.updateDetail(detail);
        } catch (RuntimeException ex) {
            LOGGER.error(ex);
        } // update is completed successful, but throw Runtime exception JavaFX.
        finally {
            LOGGER.info("\u001B[33mUPDATE Detail: Database is UPDATED by CarID!\u001B[0m");
            try {
                LoaderFXML.loadDatabaseUpdatedFXML();;
            } catch (IOException ex) {
                LOGGER.error(ex);
            }
        }
    }
}
