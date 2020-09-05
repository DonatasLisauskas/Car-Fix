package carfix.dao.test;

import carfix.entities.Car;
import carfix.utils.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.*;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.fail;

// Following guidelines: https://www.codejava.net/testing/junit-5-tutorial-for-beginner-test-crud-for-hibernate
public class CarPersistenceTest {

    private static SessionFactory factory;
    private static final Logger log = LogManager.getLogger(CarPersistenceTest.class);

    @BeforeAll
    public static void initAll() {
    // initializes resources before all test methods

            log.info( "Run :: BeforeAll");
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();
            factory = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
    }

    @BeforeEach
    public void init() {
        log.warn("Run :: BeforeEach" );
        // initializes resources before each test method
    }

    @Test
    public void CarEntityPersist() {
    // This test should pass

            final Car message = new Car();

            // ARM, remember?
            try (Session session = factory.openSession()) {
                Transaction tx = session.beginTransaction();
                session.persist(message);
                tx.commit();
            } catch ( Exception sqlException ) {
                log.error( sqlException );
                fail( sqlException );
            }
    }

    @Test
    @Disabled
    public void failTest() {
        fail("this test will fail");
    }

    @AfterEach
    public void tearDown() {
        // releases resources after each test method
        log.warn("Run :: AfterEach" );
    }

    @AfterAll
    public static void tearDownAll() {
        // releases resources after all test methods
        log.info("Run :: AfterAll" );
    }

}
