package Visitor_Pattern;

import Facade_Pattern.DaoMaker;
import JavaFX.Buttons;
import Visitor_Pattern.Visitors.CarDaoVisitor;
import javafx.stage.Stage;

public abstract class DaoPartVisitor extends DaoMaker implements Buttons {

    public abstract DaoPartVisitor visit(Stage stage);

    protected abstract void create(Stage stage);

    protected abstract void read(Stage stage);

    protected abstract void update(Stage stage);

    protected abstract void delete(Stage stage);

    protected abstract Long inputNumber();

    protected abstract String inputString();

    protected abstract void welcome();
}
