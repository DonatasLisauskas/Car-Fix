package Visitor_Pattern;

import Facade_Pattern.DaoMaker;
import javafx.stage.Stage;
import java.io.IOException;

public abstract class DaoPartVisitor extends DaoMaker {

    public abstract DaoPartVisitor visit(Stage stage, DaoPartVisitor daoPartVisitor) throws IOException;

}
