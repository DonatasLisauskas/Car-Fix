package FXML_Controllers.Failure_FXML_Controllers;

import carfix.dao.FailureDao;
import carfix.entities.Failure;
import carfix.utils.HibernateUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class UpdateFailureController {

    private static final Logger LOGGER = LogManager.getLogger(UpdateFailureController.class);

    @FXML
    private TextField id;

    @FXML
    private TextField failureName;

    @FXML
    public void updateName() throws IOException {
        try {
            Failure failure = new Failure();
            FailureDao failureDao = new FailureDao();
            failure = failureDao.getFailureById(Long.valueOf(id.getText()));
            failure.setFailureName(failureName.getText());
            failureDao.updateFailure(failure);
        } catch (RuntimeException ex) {
            LOGGER.error(ex);
        } // update is completed successful, but throw Runtime exception JavaFX.
        finally {
            if (null != HibernateUtil.getSessionFactory())
                HibernateUtil.shutdown();
            LOGGER.info("\u001B[33mUPDATE Failure: Database is UPDATED by FailureName!\u001B[0m");
            try {
                FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/JavaFX/DatabaseUpdated.fxml"));
                Parent root1 = (Parent) fxmlLoader1.load();
                Stage stage1 = new Stage();
                stage1.setScene(new Scene(root1));
                stage1.show();
            } catch (IOException ex) {
                LOGGER.error(ex);
            }
        }
    }
}
