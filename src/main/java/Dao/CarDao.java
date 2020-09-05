package Dao;

import Utils.HibernateUtil;
import entities.Car;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


public class CarDao {

    private static final Logger LOGGER = LogManager.getLogger(CarDao.class);

    public void createCar(Car car) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.save(car);

            transaction.commit();

        } catch (Exception ex) {
            if (null != transaction) {
                transaction.rollback();
            }
            ex.printStackTrace();
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mCreateCar(" + car + "): Process of creating is completed. Session is closed.\u001B[0m");
        }
    }

    public void updateCar(Car car) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.update(car);

            transaction.commit();

        } catch (Exception ex) {
            if (null != transaction) {
                transaction.rollback();
            }
            ex.printStackTrace();
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mupdateCar(" + car + "): Process of updating is completed. Session is closed.\u001B[0m");
        }
    }

    public void deleteCar(Car car) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.delete(car);

            transaction.commit();

        } catch (Exception ex) {
            if (null != transaction) {
                transaction.rollback();
            }
            ex.printStackTrace();
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mdeleteCar(" + car + "): Process of deleting is completed. Session is closed.\u001B[0m");
        }
    }

    public Car getCarById(final Long carId) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Car car = session.find(Car.class, carId);

            return car;

        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.error(ex);
            return null;
        } finally {
            LOGGER.info("\u001B[33mgetCarById(" + carId + "): Process of searching is completed. Session is closed.\u001B[0m");
        }
    }

    public List<Car> getListOfCarByQueries(final String queryStatement) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            List<Car> carList = session.createQuery(queryStatement, Car.class).list();

            return carList;

        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.error(ex);
            return null;
        } finally {
            LOGGER.info("\u001B[33mgetListOfCarByQueries(" + queryStatement + "): Process of searching and mapping into the list is completed. Session is closed.\u001B[0m");
        }
    }

    public List<Car> getListOfCarByNamedQueries(final String namedQueries, final String query) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Query<Car> carQuery = session.createNamedQuery(namedQueries, Car.class);

            carQuery = carQuery.setParameter("parameter", query);

            List<Car> carList = carQuery.list();

            return carList;

        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.error(ex);
            return null;
        } finally {
            LOGGER.info("\u001B[33mgetListOfCarByNamedQueries(" + namedQueries + ", " + query + "): Process of searching\n" +
                    " by Named Queries and mapping into the list is completed. Session is closed.\u001B[0m");
        }
    }
}
