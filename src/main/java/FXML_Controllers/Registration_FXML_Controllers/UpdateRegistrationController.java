package FXML_Controllers.Registration_FXML_Controllers;

import Facade_Pattern.DaoMaker;
import Visitor_Pattern.LoaderFXML;
import carfix.entities.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class UpdateRegistrationController extends DaoMaker {

    private static final Logger LOGGER = LogManager.getLogger(UpdateRegistrationController.class);

    @FXML
    private TextField registrationID;

    @FXML
    private TextField workID;

    @FXML
    private TextField customerID;

    @FXML
    private TextField detailID;


    @FXML
    public void updateWorkIdButton() throws IOException {
        try {
            Registration registration = registrationDao.getRegistrationById(Long.valueOf(registrationID.getText()));
            Work work = workDao.getWorkById(Long.valueOf(workID.getText()));
            registration.setWork(work);
            registrationDao.updateRegistration(registration);
        } catch (RuntimeException ex) {
            LOGGER.error(ex);
        } // update is completed successful, but throw Runtime exception JavaFX.
        finally {
            LOGGER.info("\u001B[33mUPDATE Registration: Database is UPDATED by WorkID!\u001B[0m");
            try {
                LoaderFXML.loadDatabaseUpdatedFXML();
            } catch (IOException ex) {
                LOGGER.error(ex);
            }
        }
    }

    @FXML
    public void updateCustomerIdButton() throws IOException {
        try {
            Registration registration = registrationDao.getRegistrationById(Long.valueOf(registrationID.getText()));
            Customer customer = customerDao.getCustomerById(Long.valueOf(customerID.getText()));
            registration.setCustomer(customer);
            registrationDao.updateRegistration(registration);
        } catch (RuntimeException ex) {
            LOGGER.error(ex);
        } // update is completed successful, but throw Runtime exception JavaFX.
        finally {
            LOGGER.info("\u001B[33mUPDATE Registration: Database is UPDATED by CustomerID!\u001B[0m");
            try {
                LoaderFXML.loadDatabaseUpdatedFXML();
            } catch (IOException ex) {
                LOGGER.error(ex);
            }
        }
    }

    @FXML
    public void updateDetailIdButton() throws IOException {
        try {
            Registration registration = registrationDao.getRegistrationById(Long.valueOf(registrationID.getText()));
            Detail detail = detailDao.getDetailById(Long.valueOf(detailID.getText()));
            registration.setDetail(detail);
            registrationDao.updateRegistration(registration);
        } catch (RuntimeException ex) {
            LOGGER.error(ex);
        } // update is completed successful, but throw Runtime exception JavaFX.
        finally {
            LOGGER.info("\u001B[33mUPDATE Registration: Database is UPDATED by DetailID!\u001B[0m");
            try {
                LoaderFXML.loadDatabaseUpdatedFXML();
            } catch (IOException ex) {
                LOGGER.error(ex);
            }
        }
    }
}
