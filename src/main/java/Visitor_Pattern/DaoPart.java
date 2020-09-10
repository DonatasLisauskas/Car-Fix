package Visitor_Pattern;

import Visitor_Pattern.Visitors.Visitors;

import java.io.IOException;

public interface DaoPart {

    public void accept(VisitPart visitPart, Visitors visitors) throws IOException;

}
