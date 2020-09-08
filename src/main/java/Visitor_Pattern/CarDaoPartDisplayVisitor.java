package Visitor_Pattern;

import carfix.entities.Car;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Scanner;

public class CarDaoPartDisplayVisitor extends DaoPartVisitor {

    @Override
    //CRUD
    public DaoPartVisitor visit(Stage stage) {

        welcome();

        switch (inputString()) {
            case "Create": create(stage); break;
            case "Update":
        }
        return this;
    }

    public String nameS;
    public Long year;
    public String litre;
    public Long powerKW;

    @Override
    public void create(Stage stage) {

        Label seriesName = new Label("Series Name: "); // string
        Label manufactureY = new Label("Year of Manufacture: "); // long
        Label engineDisplacement = new Label("Engine displacement by (0.0) L"); //STRING
        Label power = new Label("Engine Power by KW "); //long

        TextField t1=new TextField();
        TextField t2=new TextField();
        TextField t3=new TextField();
        TextField t4=new TextField();

        selectButton.setOnAction(event -> carDao.createCar(new Car(t1.getText(), Long.valueOf(t2.getText()), t3.getText(), Long.valueOf(t4.getText()))));


        GridPane gridPane = new GridPane();
        gridPane.addRow(0,seriesName, t1);
        gridPane.addRow(1,manufactureY, t2);
        gridPane.addRow(2,engineDisplacement,t3);
        gridPane.addRow(3,power, t4);
        gridPane.addRow(4,selectButton);

        Scene scene = new Scene(gridPane, 400, 300);

        stage.setScene(scene);
        stage.setTitle("Example");
        stage.show();
    }

    @Override
    protected void read(Stage stage) {

    }

    @Override
    protected void update(Stage stage) {

    }

    @Override
    protected void delete(Stage stage) {

    }

    @Override
    protected Long inputNumber() {
        Scanner sc = new Scanner(System.in);
        Long number = sc.nextLong();
        return number;
    }

    @Override
    protected String inputString() {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        return command;
    }

    @Override
    protected void welcome() {
        System.out.println("Welcome to CarFix");
        System.out.println("Please select a command: (Create, Update, Delete, ID (get by ID), List (get Car DB List");
    }
}
