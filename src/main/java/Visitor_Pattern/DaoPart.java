package Visitor_Pattern;

import javafx.stage.Stage;
import java.io.IOException;

public interface DaoPart {

    public DaoPart accept(Stage stage, VisitPart visitPart) throws IOException;

}
