package Visitor_Pattern;

import java.io.IOException;

public class DaoVisitor implements DaoPart {

    @Override
    public void accept(VisitPart visitPart, Visitors visitors) throws IOException {
        visitPart.visit(visitors);
    }
}
