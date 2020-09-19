package carfix.dao;

import carfix.utils.HibernateUtil;
import carfix.entities.CarService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CarServiceDao {

    private static final Logger LOGGER = LogManager.getLogger(CarServiceDao.class);

    public void createCarService(CarService carService) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.save(carService);

            transaction.commit();

        } catch (Exception ex) {
            if (null != transaction) {
                transaction.rollback();
                LOGGER.info("\u001B[33mrollback() executed\u001B[0m");
            }
            ex.printStackTrace();
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mcreateCarService(" + carService + "): Process of creating is completed. Session is closed.\u001B[0m");
        }
    }

    public void updateCarService(CarService carService) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.update(carService);

            transaction.commit();

        } catch (Exception ex) {
            if (null != transaction) {
                transaction.rollback();
                LOGGER.info("\u001B[33mrollback() executed\u001B[0m");
            }
            ex.printStackTrace();
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mupdateCarService(" + carService + "): Process of updating is completed. Session is closed.\u001B[0m");
        }
    }

    public void deleteCarService(CarService carService) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.delete(carService);

            transaction.commit();

        } catch (Exception ex) {
            if (null != transaction) {
                transaction.rollback();
                LOGGER.info("\u001B[33mrollback() executed\u001B[0m");
            }
            ex.printStackTrace();
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mdeleteCarService(" + carService + "): Process of deleting is completed. Session is closed.\u001B[0m");
        }
    }

    public CarService getCarServiceById(final Long carServiceId) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            CarService carService = session.find(CarService.class, carServiceId);

            return carService;

        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.error(ex);

            return new CarService();

        } finally {
            LOGGER.info("\u001B[33mgetCarServiceById(" + carServiceId + "): Process of searching is completed. Session is closed.\u001B[0m");
        }
    }

    public List<CarService> getListOfCarServiceByQueries(final String queryStatement) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            List<CarService> carServicesList = session.createQuery(queryStatement, CarService.class).list();

            return carServicesList;

        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.error(ex);

            return new ArrayList<>();

        } finally {
            LOGGER.info("\u001B[33mgetListOfCarServiceByQueries(" + queryStatement + "): Process of searching \n" +
                    "and mapping into the list is completed. Session is closed.\u001B[0m");
        }
    }

    public List<CarService> getListOfCarServiceByNamedQueries(final String namedQueries, final String query) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Query<CarService> carServiceQuery = session.createNamedQuery(namedQueries, CarService.class);

            carServiceQuery = carServiceQuery.setParameter("parameter", query);

            List<CarService> carServicerList = carServiceQuery.list();

            return carServicerList;

        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.error(ex);

            return new ArrayList<>();

        } finally {
            LOGGER.info("\u001B[getListOfCarServiceByNamedQueries(" + namedQueries + ", " + query + "): Process of searching\n" +
                    " by Named Queries and mapping into the list is completed. Session is closed.\u001B[0m");
        }
    }
}

