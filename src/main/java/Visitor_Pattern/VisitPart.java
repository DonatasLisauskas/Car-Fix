package Visitor_Pattern;

import Facade_Pattern.DaoMaker;
import Visitor_Pattern.Visitors.Visitors;
import javafx.stage.Stage;
import java.io.IOException;

public abstract class VisitPart extends DaoMaker {

    public abstract void visit(Visitors visitors) throws IOException;
}

