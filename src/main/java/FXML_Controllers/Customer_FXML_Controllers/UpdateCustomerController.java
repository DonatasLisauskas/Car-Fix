package FXML_Controllers.Customer_FXML_Controllers;

import carfix.dao.CustomerDao;
import carfix.entities.Customer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

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
    public void updateFirstName() throws IOException{
        try {
            Customer customer = new Customer();
            CustomerDao customerDao = new CustomerDao();
            customer = customerDao.getCustomerById(Long.valueOf(id.getText()));
            customer.setFirstName(firstName.getText());
            customerDao.updateCustomer(customer);
        } catch (RuntimeException e) {
        } // update is completed successful, but throw Runtime exception JavaFX.
        finally {
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

    @FXML
    public void updateLastName() throws IOException{
        try {
            Customer customer = new Customer();
            CustomerDao customerDao = new CustomerDao();
            customer = customerDao.getCustomerById(Long.valueOf(id.getText()));
            customer.setLastName(lastName.getText());
            customerDao.updateCustomer(customer);
        } catch (RuntimeException e) {
        } // update is completed successful, but throw Runtime exception JavaFX.
        finally {
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

    @FXML
    public void updateEmail() throws IOException{
        try {
            Customer customer = new Customer();
            CustomerDao customerDao = new CustomerDao();
            customer = customerDao.getCustomerById(Long.valueOf(id.getText()));
            customer.setEmail(email.getText());
            customerDao.updateCustomer(customer);
        } catch (RuntimeException e) {
        } // update is completed successful, but throw Runtime exception JavaFX.
        finally {
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

    @FXML
    public void updatePhoneNumber() throws IOException{
        try {
            Customer customer = new Customer();
            CustomerDao customerDao = new CustomerDao();
            customer = customerDao.getCustomerById(Long.valueOf(id.getText()));
            customer.setPhoneNumber(Long.valueOf(phoneNumber.getText()));
            customerDao.updateCustomer(customer);
        } catch (RuntimeException e) {
        } // update is completed successful, but throw Runtime exception JavaFX.
        finally {
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
}
