import Visitor_Pattern.CarDaoPartDisplayVisitor;
import Visitor_Pattern.DaoPart;
import Visitor_Pattern.Visitors.CarDaoVisitor;
import carfix.utils.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        HibernateUtil.shutdown();

        DaoPart daoPart = new CarDaoVisitor().accept();

    }
}
