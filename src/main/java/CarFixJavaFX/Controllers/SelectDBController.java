package CarFixJavaFX.Controllers;

import Visitor_Pattern.CarDaoPartDisplayVisitor;
import Visitor_Pattern.DaoPart;
import Visitor_Pattern.Visitors.DaoVisitor;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class SelectDBController {

    @FXML
    private TextField textField;
    @FXML
    private Label label;

    @FXML
    private void carDaoButton() throws IOException {
        DaoPart daoPart = new DaoVisitor();
        Stage stage = new Stage();
        daoPart.accept(stage, new CarDaoPartDisplayVisitor());
    }
}
