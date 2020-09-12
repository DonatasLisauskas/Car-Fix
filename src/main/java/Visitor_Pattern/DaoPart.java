package Visitor_Pattern;

import java.io.IOException;

public interface DaoPart {

    public void accept(VisitPart visitPart, Visitors visitors) throws IOException;

}
