package Visitor_Pattern;

import Facade_Pattern.DaoMaker;
import Visitor_Pattern.Visitors.CarDaoVisitor;

public abstract class DaoPartVisitor extends DaoMaker {

    public abstract DaoPartVisitor visit();

    protected abstract Long inputNumber();

    protected abstract String inputString();

    protected abstract void welcome();
}
