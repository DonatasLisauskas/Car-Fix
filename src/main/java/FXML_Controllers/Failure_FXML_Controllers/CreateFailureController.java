package FXML_Controllers.Failure_FXML_Controllers;

import carfix.dao.FailureDao;
import carfix.entities.Failure;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CreateFailureController {

    @FXML
    private TextField failureName;

    @FXML
    private Label label;

    @FXML
    public void createFailureButton() {
        FailureDao failureDao = new FailureDao();
        failureDao.createFailure(new Failure(failureName.getText()));
    }
}
