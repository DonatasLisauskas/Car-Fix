package FXML_Controllers.Customer_FXML_Controllers;

import carfix.dao.CustomerDao;
import carfix.entities.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    public void createCustomerButton(){
        CustomerDao customerDao = new CustomerDao();
        customerDao.createCustomer(new Customer(firstName.getText(), lastName.getText(), email.getText(), Long.valueOf(phoneNumber.getText())));
    }

}
