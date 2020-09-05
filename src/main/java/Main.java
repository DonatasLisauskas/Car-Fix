import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    private static SessionFactory factory;

    public static void setup() {
    
        
        Configuration configuration = new Configuration();
        configuration.configure("/hibernate.cfg.xml");
                
                
        factory = configuration.buildSessionFactory();

    }

    public static void main(String[] args) {

        Main.setup();

    }

}
