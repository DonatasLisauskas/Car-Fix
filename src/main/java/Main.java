import Utils.HibernateUtil;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        HibernateUtil.shutdown();
    }
}
