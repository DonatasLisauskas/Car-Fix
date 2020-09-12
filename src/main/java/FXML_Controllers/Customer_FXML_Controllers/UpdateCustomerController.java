package FXML_Controllers.Customer_FXML_Controllers;

import carfix.dao.CustomerDao;
import carfix.entities.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class UpdateCustomerController {

    @FXML
    private TextField id;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField email;

    @FXML
    private TextField phoneNumber;

    @FXML
    public void updateFirstName() {
        try {
            Customer customer = new Customer();
            CustomerDao customerDao = new CustomerDao();
            customer = customerDao.getCustomerById(Long.valueOf(id.getText()));
            customer.setFirstName(firstName.getText());
            customerDao.updateCustomer(customer);
        } catch (RuntimeException e) {
        } // update is completed successful, but throw Runtime exception JavaFX.
    }

    @FXML
    public void updateLastName() {
        try {
            Customer customer = new Customer();
            CustomerDao customerDao = new CustomerDao();
            customer = customerDao.getCustomerById(Long.valueOf(id.getText()));
            customer.setLastName(lastName.getText());
            customerDao.updateCustomer(customer);
        } catch (RuntimeException e) {
        } // update is completed successful, but throw Runtime exception JavaFX.
    }

    @FXML
    public void updateEmail() {
        try {
            Customer customer = new Customer();
            CustomerDao customerDao = new CustomerDao();
            customer = customerDao.getCustomerById(Long.valueOf(id.getText()));
            customer.setEmail(email.getText());
            customerDao.updateCustomer(customer);
        } catch (RuntimeException e) {
        } // update is completed successful, but throw Runtime exception JavaFX.
    }

    @FXML
    public void updatePhoneNumber() {
        try {
            Customer customer = new Customer();
            CustomerDao customerDao = new CustomerDao();
            customer = customerDao.getCustomerById(Long.valueOf(id.getText()));
            customer.setPhoneNumber(Long.valueOf(phoneNumber.getText()));
            customerDao.updateCustomer(customer);
        } catch (RuntimeException e) {
        } // update is completed successful, but throw Runtime exception JavaFX.
    }
}
