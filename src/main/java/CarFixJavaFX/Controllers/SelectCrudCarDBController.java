package CarFixJavaFX.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SelectCrudCarDBController extends Parent implements Initializable {

    @FXML
    private TextField textField;
    @FXML
    private Label label;

    /*daoPartVisitor.create(stage));
        readButton.setOnAction(event -> daoPartVisitor.create(stage));
        updateButton.setOnAction(event -> daoPartVisitor.create(stage));
        deleteButton.setOnAction(event -> daoPartVisitor.create(stage));
        backButton.setOnAction(event -> selectTableFromDataBase(stage));*/

    @FXML
    private void createButton(){

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/JavaFX/SelectCrudCarDB.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        stage.setScene(new Scene(root));
        stage.show();

    }

    @FXML
    private void readButton() {

    }

    @FXML
    private void updateButton() {

    }

    @FXML
    private void deleteButton() {

    }

    @FXML
    private void backButton() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
