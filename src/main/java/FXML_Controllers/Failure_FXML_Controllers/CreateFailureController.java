package FXML_Controllers.Failure_FXML_Controllers;

import carfix.dao.FailureDao;
import carfix.entities.Failure;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateFailureController {

    @FXML
    private TextField failureName;

    @FXML
    private Label label;

    @FXML
    public void createFailureButton() throws IOException{
        FailureDao failureDao = new FailureDao();
        failureDao.createFailure(new Failure(failureName.getText()));
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
