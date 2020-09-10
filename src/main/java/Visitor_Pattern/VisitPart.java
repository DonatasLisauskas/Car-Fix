package Visitor_Pattern;

import Facade_Pattern.DaoMaker;
import javafx.stage.Stage;
import java.io.IOException;

public abstract class VisitPart extends DaoMaker {

    public abstract VisitPart visitCar(Stage stage) throws IOException;

    public abstract VisitPart visitCarService(Stage stage) throws IOException;

    public abstract VisitPart visitCustomer(Stage stage) throws IOException;

    public abstract VisitPart visitDetail(Stage stage) throws IOException;

    public abstract VisitPart visitFailure(Stage stage) throws IOException;

    public abstract VisitPart visitRegistration(Stage stage) throws IOException;

    public abstract VisitPart visitSchedule(Stage stage) throws IOException;

    public abstract VisitPart visitWork(Stage stage) throws IOException;


}
