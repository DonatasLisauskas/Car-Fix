package Visitor_Pattern;

import Visitor_Pattern.Visitors.Visitors;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Visit extends VisitPart {

    @Override
    //CRUD
    public void visit(Visitors visitors) throws IOException {

        switch (visitors) {
            case CAR:
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/JavaFX/Car_DB_FXML/CrudCar.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            break;
            case CAR_SERVICE:
                FXMLLoader fxmlLoader1 = new FXMLLoader(getClass().getResource("/JavaFX/Car_Service_DB_FXML/CrudCarService.fxml"));
                Parent root1 = (Parent) fxmlLoader1.load();
                Stage stage1 = new Stage();
                stage1.setScene(new Scene(root1));
                stage1.show();
            break;
            case CUSTOMER:
                FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("/JavaFX/Customer_DB_FXML/CrudCustomer.fxml"));
                Parent root2 = (Parent) fxmlLoader2.load();
                Stage stage2 = new Stage();
                stage2.setScene(new Scene(root2));
                stage2.show();
                break;
        }
    }
}
