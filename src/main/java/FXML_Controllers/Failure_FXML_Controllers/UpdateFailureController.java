package FXML_Controllers.Failure_FXML_Controllers;

import carfix.dao.FailureDao;
import carfix.entities.Failure;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class UpdateFailureController {

    @FXML
    private TextField id;

    @FXML
    private TextField failureName;

    @FXML
    public void updateName() {
        try {
            Failure failure = new Failure();
            FailureDao failureDao = new FailureDao();
            failure = failureDao.getFailureById(Long.valueOf(id.getText()));
            failure.setFailureName(failureName.getText());
            failureDao.updateFailure(failure);
        } catch (RuntimeException e) {
        } // update is completed successful, but throw Runtime exception JavaFX.
    }
}
