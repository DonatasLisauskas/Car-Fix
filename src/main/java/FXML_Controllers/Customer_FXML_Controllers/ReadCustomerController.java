package FXML_Controllers.Customer_FXML_Controllers;

import Facade_Pattern.DaoMaker;
import Visitor_Pattern.LoaderFXML;
import carfix.entities.Customer;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static carfix.Validation.Regexp.*;

public class ReadCustomerController extends DaoMaker {

    private static final Logger LOGGER = LogManager.getLogger(ReadCustomerController.class);

    @FXML
    private TextField Id;
    @FXML
    private TextField byQuery;
    @FXML
    private TextField byNamedQuery;

    @FXML
    private void readByID() {
        try {
            Long customerId = Long.valueOf(String.valueOf(Id.getText()));
            Customer customer = customerDao.getCustomerById(customerId);

            String testID = Id.getText();

            if (testID.matches(ID_OR_NUMBER) && customer != null) {

                ListView listView = new ListView();
                ObservableList<Customer> items = listView.getItems();
                items.add(customer);

                VBox vBox = new VBox();
                vBox.getChildren().add(listView);
                Stage stage = new Stage();
                Scene scene = new Scene(vBox, 500, 500);
                stage.setScene(scene);
                stage.show();
                LOGGER.info("\u001B[33mREAD Customer: Database is READED by ID!\u001B[0m");
            } else if (customer == null) {
                LoaderFXML.databaseIsEmpty();
                LOGGER.info("\u001B[33mREAD Customer: Database IS NOT READED by ID!\u001B[0m");
            }
        } catch (Exception exception) {
            LOGGER.error(exception);
        }
    }

    @FXML
    private void readByQuery() {
        try {
            String query = String.valueOf((byQuery.getText()));
            ListView listView = new ListView();
            ObservableList<Customer> items = listView.getItems();

            try {
                items.addAll(customerDao.getListOfCustomerByQueries(query));
            } catch (Exception exception) {
                LOGGER.warn(exception);
            }
            if (!items.isEmpty()) {

                VBox vBox = new VBox();
                vBox.getChildren().add(listView);
                Stage stage = new Stage();
                Scene scene = new Scene(vBox, 500, 500);
                stage.setScene(scene);
                stage.show();
                LOGGER.info("\u001B[33mREAD Customer: Database is READED by Query!\u001B[0m");
            } else {
                LoaderFXML.wrongQuery();
            }
        } catch (Exception exception) {
            LOGGER.warn(exception);
        }
    }
}
