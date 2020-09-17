package carfix.dao.test;

import carfix.entities.Car;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.jupiter.api.*;   // Jupiper == JUnit5
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

// TDD (Test driven -development)
import javax.persistence.Query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static carfix.dao.CarDao.Statements.ALL_FROM_CAR;
import static org.junit.jupiter.api.Assertions.*;

// Following guidelines: https://www.codejava.net/testing/junit-5-tutorial-for-beginner-test-crud-for-hibernate

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
// https://www.baeldung.com/junit-5-test-order

// TODO:  1) Hypersonic DB Demo for memory-only DB
//        2) Parametrized testing
//        3) Site for JUnit5 test reports

public class CarPersistenceTest {

    private static SessionFactory factory;
    private static final Logger LOGGER = LogManager.getLogger(CarPersistenceTest.class);

    @BeforeAll
    public static void initAll() {
    // initializes resources before all test methods

            LOGGER.info( "Run :: BeforeAll");
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();

            factory = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();

            // Check the transaction mechanism
            try (Session session = factory.openSession()) {
                Transaction tx = session.beginTransaction();
                tx.commit();
            } catch ( Exception sqlException ) {
                LOGGER.error( sqlException );
                fail( sqlException );
            }
    }

    @BeforeEach
    public void init() {
        LOGGER.warn("Run :: BeforeEach" );
        // initializes resources before each test method
    }

    @Order(1)
    @ParameterizedTest
    @ValueSource(strings = {"Car One", "Car Two", "Car Three"}) // three cars
    public void persistCarEntity( final String carName ) {
    // This test should pass

            final Car car = new Car();
            car.setSeriesName( carName );

            // ARM, remember?
            try (Session session = factory.openSession()) {
                Transaction tx = session.beginTransaction();
                session.persist(car);
                tx.commit();
            } catch ( Exception sqlException ) {
                LOGGER.error( sqlException );
                fail( sqlException );
            }
    }

    @Test
    @Order(2)
    public void readCarEntity() {

        // ARM, remember?
        try (Session session = factory.openSession()) {

            Query query = session.createQuery( ALL_FROM_CAR );
            List resultSet = query.getResultList();

            resultSet.stream().forEach( LOGGER::debug );

            assertNotNull( resultSet );
            assertTrue( !resultSet.isEmpty() );

        } catch ( Exception sqlException ) {

            LOGGER.error( sqlException );
            fail( sqlException );
        }
    }

    @AfterEach
    public void tearDown() {
        // releases resources after each test method
        LOGGER.warn("Run :: AfterEach" );
    }

    @AfterAll
    public static void tearDownAll() {
        // releases resources after all test methods
        LOGGER.info("Run :: AfterAll" );

        if ( !factory.isClosed() ) {
            factory.close();
        }
    }

}
