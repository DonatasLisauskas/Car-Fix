package FXML_Controllers.Customer_FXML_Controllers;

import carfix.dao.CustomerDao;
import carfix.entities.Customer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateCustomerController {

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField email;

    @FXML
    private TextField phoneNumber;

    @FXML
    private Label label;

    @FXML
    public void createCustomerButton() {
        CustomerDao customerDao = new CustomerDao();
        customerDao.createCustomer(new Customer(firstName.getText(), lastName.getText(), email.getText(), Long.valueOf(phoneNumber.getText())));
        try {
            FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/JavaFX/DatabaseUpdated.fxml"));
            Parent root1 = (Parent) fxmlLoader1.load();
            Stage stage1 = new Stage();
            stage1.setScene(new Scene(root1));
            stage1.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
