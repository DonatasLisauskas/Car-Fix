package Dao;

import Utils.HibernateUtil;
import entities.carService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class carServiceDao {

    private static final Logger LOGGER = LogManager.getLogger(carServiceDao.class);

    public void createCarService(carService carservice) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.save(carservice);

            transaction.commit();

        } catch (Exception ex) {
            if (null != transaction) {
                transaction.rollback();
                LOGGER.info("\u001B[33mrollback() executed\u001B[0m");
            }
            ex.printStackTrace();
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mcreateCarService(" + carservice + "): Process of creating is completed. Session is closed.\u001B[0m");
        }
    }

    public void updateCarService(carService carService) {

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

    public void deleteCarService(carService carService) {

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

    public carService getCarServiceById(final Long carServiceId) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            carService carService = session.find(carService.class, carServiceId);

            return carService;

        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.error(ex);
            return null;
        } finally {
            LOGGER.info("\u001B[33mgetCarServiceById(" + carServiceId + "): Process of searching is completed. Session is closed.\u001B[0m");
        }
    }

    public List<carService> getListOfCarServiceByQueries(final String queryStatement) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            List<carService> carServicesList = session.createQuery(queryStatement, carService.class).list();

            return carServicesList;

        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.error(ex);
            return null;
        } finally {
            LOGGER.info("\u001B[33mgetListOfCarServiceByQueries(" + queryStatement + "): Process of searching \n" +
                    "and mapping into the list is completed. Session is closed.\u001B[0m");
        }
    }

    public List<carService> getListOfCarServiceByNamedQueries(final String namedQueries, final String query) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Query<carService> carServiceQuery = session.createNamedQuery(namedQueries, carService.class);

            carServiceQuery = carServiceQuery.setParameter("parameter", query);

            List<carService> carServicerList = carServiceQuery.list();

            return carServicerList;

        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.error(ex);
            return null;
        } finally {
            LOGGER.info("\u001B[getListOfCarServiceByNamedQueries(" + namedQueries + ", " + query + "): Process of searching\n" +
                    " by Named Queries and mapping into the list is completed. Session is closed.\u001B[0m");
        }
    }
}

