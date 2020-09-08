package Visitor_Pattern.Visitors;

import Visitor_Pattern.CarDaoPartDisplayVisitor;
import Visitor_Pattern.DaoPart;
import Visitor_Pattern.DaoPartVisitor;
import carfix.dao.CarDao;
import javafx.stage.Stage;

public class DaoVisitor implements DaoPart {

    @Override
    public DaoPart accept(Stage stage, DaoPartVisitor daoPartVisitor) {
        daoPartVisitor.visit(stage,daoPartVisitor);
        return this;
    }
}
