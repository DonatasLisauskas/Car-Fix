package JavaFX;

import Visitor_Pattern.CarDaoPartDisplayVisitor;
import Visitor_Pattern.DaoPart;
import Visitor_Pattern.DaoPartVisitor;
import Visitor_Pattern.Visitors.DaoVisitor;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Actions implements Buttons {

    public static DaoPart daoPart = new DaoVisitor();

    public void selectTableFromDataBase(Stage stage) {

        /*createButton.setOnAction(event -> daoPartVisitor.create(stage));*/


        GridPane gridPane = new GridPane();
        gridPane.addRow(0,carDaoButton);

        Scene scene = new Scene(gridPane, 400, 300);

        stage.setScene(scene);
        stage.setTitle("CarFix / SELECT LIST");
        stage.show();

        carDaoButton.setOnAction(event1 -> daoPart.accept(stage, new CarDaoPartDisplayVisitor()));

    }

    public void crudJavaFX(Stage stage, DaoPartVisitor daoPartVisitor) {

        createButton.setOnAction(event -> daoPartVisitor.create(stage));
        //deleteButton.set
        //read
        //update

        GridPane gridPane = new GridPane();
        gridPane.addRow(0,createButton);
        gridPane.addColumn(1,readButton);
        gridPane.addRow(2,updateButton);
        gridPane.addColumn(3,deleteButton);
        gridPane.addRow(4,backButton);

        Scene scene = new Scene(gridPane, 400, 300);

        stage.setScene(scene);
        stage.setTitle("CarFix / CRUD operations");
        stage.show();

    }

}