package FXML_Controllers.Registration_FXML_Controllers;

import Facade_Pattern.DaoMaker;
import Visitor_Pattern.LoaderFXML;
import carfix.entities.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class CreateRegistrationController extends DaoMaker {

    private static final Logger LOGGER = LogManager.getLogger(CreateRegistrationController.class);

    @FXML
    private TextField workID;

    @FXML
    private TextField customerID;

    @FXML
    private TextField detailID;

    @FXML
    public void createRegistrationButton() {

        Work work = workDao.getWorkById(Long.valueOf(workID.getText()));
        Customer customer = customerDao.getCustomerById(Long.valueOf(customerID.getText()));
        Detail detail = detailDao.getDetailById(Long.valueOf(detailID.getText()));

        registrationDao.createRegistration(new Registration(work, customer, detail));
        try {
            LoaderFXML.loadDatabaseUpdatedFXML();
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mCREATE Registration: Database is updated!\u001B[0m");
        }
    }
}
