package Visitor_Pattern;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CarDaoPartDisplayVisitor extends DaoPartVisitor {

    @Override
    //CRUD
    public DaoPartVisitor visit(Stage stage, DaoPartVisitor daoPartVisitor) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/JavaFX/CarDB/SelectCrudCarDB.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        stage.setScene(new Scene(root));
        stage.show();

        return this;
    }
}
