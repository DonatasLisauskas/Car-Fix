package Visitor_Pattern.Visitors;

import Visitor_Pattern.CarDaoPartDisplayVisitor;
import Visitor_Pattern.DaoPart;
import Visitor_Pattern.DaoPartVisitor;
import carfix.dao.CarDao;
import javafx.stage.Stage;

public class CarDaoVisitor implements DaoPart {

    @Override
    public DaoPart accept(Stage stage) {
        new CarDaoPartDisplayVisitor().visit(stage);
        return this;
    }
}
