package Visitor_Pattern;

import Facade_Pattern.DaoMaker;

import java.io.IOException;

public abstract class VisitPart extends DaoMaker {

    public abstract void visit(Visitors visitors) throws IOException;
}

