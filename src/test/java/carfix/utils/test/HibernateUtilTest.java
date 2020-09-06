package carfix.utils.test;

import carfix.dao.test.CarPersistenceTest;
import carfix.utils.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class HibernateUtilTest {

    private static final Logger LOGGER = LogManager.getLogger(HibernateUtilTest.class);

    private static SessionFactory sessionFactory;
    private Session session;

    @BeforeAll
    @Disabled
    public static void setup() {
        sessionFactory = HibernateUtil.getSessionFactory();
        System.out.println("SessionFactory created");
    }

    @AfterAll
    @Disabled
    public static void tearDown() {
        if (sessionFactory != null) sessionFactory.close();
        System.out.println("SessionFactory destroyed");
    }

    @Test
    @DisplayName("Test for CREATE")
    // C
    public void test001Create() {
    }

    // D
    @Test
    @DisplayName("Test for DELETE")
    public void test001Delete() {
    }

    // G
    @Test
    @DisplayName("Test for READ")
    public void test001Get() {
    }

    // L
    @Test
    @DisplayName("Test for LIST")
    public void test001List() {
    }

    // U
    @Test
    @DisplayName("Test for UPDATE")
    public void test001Update() {
    }

    @BeforeEach
    @Disabled
    public void openSession() {
        session = sessionFactory.openSession();
        System.out.println("Session created");
    }

    @AfterEach
    @Disabled
    public void closeSession() {
        if (session != null) {
            session.close();
        }
        System.out.println("Session closed\n");
    }
}