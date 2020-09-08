package JavaFX;

import Visitor_Pattern.CarDaoPartDisplayVisitor;
import Visitor_Pattern.DaoPart;
import Visitor_Pattern.DaoPartVisitor;
import Visitor_Pattern.Visitors.CarDaoVisitor;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Actions implements Buttons {

    public void selectTableFromDataBase(Stage stage) {

        double weight = 100;
        double height = 100;

        startButton.setMinHeight(height);
        startButton.setMinWidth(weight);

        Scene scene = new Scene(startButton, weight, height);
        stage.setMinHeight(1000);
        stage.setMinWidth(1000);
        stage.setScene(scene);
        stage.show();

        startButton.setOnAction(event -> {

            carDaoButton.setMinHeight(height);
            carDaoButton.setMinWidth(weight);

            carDaoButton.setOnAction(event1 -> new CarDaoVisitor().accept(stage));

            carServiceDaoButton.setMinHeight(height);
            carServiceDaoButton.setMinWidth(weight);

            backButton.setMinHeight(height);
            backButton.setMinWidth(weight);

            backButton.setOnAction(event1 -> {
                stage.setMinHeight(1000);
                stage.setMinWidth(1000);
                stage.setScene(scene);
                stage.show();
            });

            VBox vBox1 = new VBox();
            vBox1.getChildren().add(carDaoButton);
            vBox1.getChildren().add(carServiceDaoButton);

            VBox vBox2 = new VBox();
            vBox2.getChildren().add(backButton);

            HBox hBox = new HBox(vBox1,vBox2);

            Scene sc2 = new Scene(hBox, weight, height);
            stage.setMinHeight(1000);
            stage.setMinWidth(1000);
            stage.setScene(sc2);
            stage.show();

        });
    }
}