package Visitor_Pattern;

import javafx.stage.Stage;

public interface DaoPart {

    public DaoPart accept(Stage stage, DaoPartVisitor daoPartVisitor);

}
