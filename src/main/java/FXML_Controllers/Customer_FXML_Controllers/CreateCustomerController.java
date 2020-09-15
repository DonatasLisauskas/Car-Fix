package FXML_Controllers.Customer_FXML_Controllers;

import carfix.dao.CustomerDao;
import carfix.entities.Customer;
import carfix.utils.HibernateUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class CreateCustomerController {

    private static final Logger LOGGER = LogManager.getLogger(CreateCustomerController.class);

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField email;

    @FXML
    private TextField phoneNumber;

    @FXML
    public void createCustomerButton() throws IOException {
        CustomerDao customerDao = new CustomerDao();
        customerDao.createCustomer(new Customer(firstName.getText(), lastName.getText(), email.getText(), Long.valueOf(phoneNumber.getText())));
        try {
            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/JavaFX/DatabaseUpdated.fxml"));
            Parent root1 = (Parent) fxmlLoader1.load();
            Stage stage1 = new Stage();
            stage1.setScene(new Scene(root1));
            stage1.show();
        } catch (IOException ex) {
            LOGGER.error(ex);
        } finally {
            if (null != HibernateUtil.getSessionFactory())
                HibernateUtil.shutdown();
            LOGGER.info("\u001B[33mCREATE Customer: Database is updated!\u001B[0m");
        }
    }
}
