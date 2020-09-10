package Visitor_Pattern.Visitors;

import Visitor_Pattern.DaoPart;
import Visitor_Pattern.VisitPart;
import javafx.stage.Stage;

import java.io.IOException;

public class DaoVisitor implements DaoPart {

    @Override
    public void accept(VisitPart visitPart, Visitors visitors) throws IOException {
        visitPart.visit(visitors);
    }
}
