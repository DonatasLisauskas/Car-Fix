package Visitor_Pattern.Visitors;

import Visitor_Pattern.CarDaoPartDisplayVisitor;
import Visitor_Pattern.DaoPart;
import Visitor_Pattern.DaoPartVisitor;
import carfix.dao.CarDao;

public class CarDaoVisitor implements DaoPart {

    @Override
    public DaoPart accept() {
        new CarDaoPartDisplayVisitor().visit();
        return this;
    }
}
