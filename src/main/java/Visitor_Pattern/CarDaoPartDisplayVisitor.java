package Visitor_Pattern;

import carfix.entities.Car;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class CarDaoPartDisplayVisitor extends DaoPartVisitor {

    @Override
    //CRUD
    public DaoPartVisitor visit(Stage stage, DaoPartVisitor daoPartVisitor) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/JavaFX/SelectCrudCarDB.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        stage.setScene(new Scene(root));
        stage.show();

        return this;
    }
}
