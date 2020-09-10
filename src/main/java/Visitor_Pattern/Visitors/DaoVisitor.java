package Visitor_Pattern.Visitors;

import Visitor_Pattern.DaoPart;
import Visitor_Pattern.VisitPart;
import javafx.stage.Stage;

import java.io.IOException;

public class DaoVisitor implements DaoPart {

    @Override
    public DaoPart accept(Stage stage, VisitPart visitPart) throws IOException {
        visitPart.visitCar(stage);
        return this;
    }
}
