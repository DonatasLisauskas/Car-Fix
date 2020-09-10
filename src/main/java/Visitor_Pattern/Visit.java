package Visitor_Pattern;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Visit extends VisitPart {

    @Override
    //CRUD
    public VisitPart visitCar(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/JavaFX/CarDB/SelectCrudCarDB.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        stage.setScene(new Scene(root));
        stage.show();
        return this;
    }

    @Override
    public VisitPart visitCarService(Stage stage) throws IOException {
        return this;
    }

    @Override
    public VisitPart visitCustomer(Stage stage) throws IOException {
        return this;
    }

    @Override
    public VisitPart visitDetail(Stage stage) throws IOException {
        return this;
    }

    @Override
    public VisitPart visitFailure(Stage stage) throws IOException {
        return this;
    }

    @Override
    public VisitPart visitRegistration(Stage stage) throws IOException {
        return this;
    }

    @Override
    public VisitPart visitSchedule(Stage stage) throws IOException {
        return this;
    }

    @Override
    public VisitPart visitWork(Stage stage) throws IOException {
        return this;
    }
}
