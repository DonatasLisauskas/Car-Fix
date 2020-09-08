package Visitor_Pattern;

import Facade_Pattern.DaoMaker;
import JavaFX.Buttons;
import javafx.stage.Stage;

public abstract class DaoPartVisitor extends DaoMaker implements Buttons {

    public abstract DaoPartVisitor visit(Stage stage, DaoPartVisitor daoPartVisitor);

    public abstract void create(Stage stage);

    public abstract void read(Stage stage);

    public abstract void update(Stage stage);

    public abstract void delete(Stage stage);

    public abstract Long inputNumber();

    public abstract String inputString();

    public abstract void welcome();
}
