package FXML_Controllers.Customer_FXML_Controllers;

import carfix.dao.CustomerDao;
import carfix.entities.Customer;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ReadCustomerController {

    @FXML
    private TextField Id;
    @FXML
    private TextField byQuery;
    @FXML
    private TextField byNamedQuery;

    @FXML
    private void readByID() throws IOException {

        Long customerId = Long.valueOf(String.valueOf(Id.getText()));

        ListView listView = new ListView();

        Customer customer = new Customer();
        CustomerDao customerDao = new CustomerDao();
        customer = customerDao.getCustomerById(customerId);

        ObservableList<String> items = listView.getItems();
        items.add("ID: " + customer.getCustomerId() + " // " +
                customer.getFirstName() + " // " +
                customer.getLastName() + " // " +
                customer.getEmail() + " // " +
                customer.getPhoneNumber()+ " //");

        VBox vBox = new VBox();
        vBox.getChildren().add(listView);

        Stage stage = new Stage();

        Scene scene = new Scene(vBox, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
}
