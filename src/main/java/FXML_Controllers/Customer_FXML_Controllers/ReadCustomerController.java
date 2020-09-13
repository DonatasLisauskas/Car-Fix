package FXML_Controllers.Customer_FXML_Controllers;

import Facade_Pattern.DaoMaker;
import carfix.entities.Customer;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ReadCustomerController extends DaoMaker {

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

        Customer customer = customerDao.getCustomerById(customerId);

        ObservableList<Customer> items = listView.getItems();
        items.add(customer);

        VBox vBox = new VBox();
        vBox.getChildren().add(listView);

        Stage stage = new Stage();

        Scene scene = new Scene(vBox, 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void readByQuery() throws IOException {

        String query = String.valueOf((byQuery.getText()));

        ListView listView = new ListView();

        ObservableList<Customer> items = listView.getItems();

        items.addAll(customerDao.getListOfCustomerByQueries(query));

        VBox vBox = new VBox();
        vBox.getChildren().add(listView);

        Stage stage = new Stage();

        Scene scene = new Scene(vBox, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
}
