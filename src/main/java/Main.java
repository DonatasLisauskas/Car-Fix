import carfix.utils.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        HibernateUtil.shutdown();
    }
}
