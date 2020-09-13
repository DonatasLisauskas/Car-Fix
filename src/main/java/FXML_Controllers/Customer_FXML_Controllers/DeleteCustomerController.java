package FXML_Controllers.Customer_FXML_Controllers;

import Facade_Pattern.DaoMaker;
import carfix.entities.Customer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class DeleteCustomerController extends DaoMaker {

    @FXML
    private TextField number;

    @FXML
    private void deleteButton() throws IOException {
        try {
            Customer customer = customerDao.getCustomerById(Long.valueOf(number.getText()));
            customerDao.deleteCustomer(customer);
        } catch (RuntimeException e) {
        } // delete is completed successful, but throw Runtime exception JavaFX.
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
