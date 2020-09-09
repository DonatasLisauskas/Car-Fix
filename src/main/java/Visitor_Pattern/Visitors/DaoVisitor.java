package Visitor_Pattern.Visitors;

import Visitor_Pattern.DaoPart;
import Visitor_Pattern.DaoPartVisitor;
import javafx.stage.Stage;

import java.io.IOException;

public class DaoVisitor implements DaoPart {

    @Override
    public DaoPart accept(Stage stage, DaoPartVisitor daoPartVisitor) throws IOException {
        daoPartVisitor.visit(stage,daoPartVisitor);
        return this;
    }
}
