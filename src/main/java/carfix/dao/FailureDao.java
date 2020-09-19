package carfix.dao;

import carfix.entities.Failure;
import carfix.utils.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class FailureDao {

    private static final Logger LOGGER = LogManager.getLogger(FailureDao.class);

    public void createFailure(Failure failure) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.save(failure);

            transaction.commit();

        } catch (Exception ex) {
            if (null != transaction) {
                transaction.rollback();
                LOGGER.info("\u001B[33mrollback() executed\u001B[0m");
            }
            ex.printStackTrace();
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mCreateFailure(" + failure + "): Process of creating is completed. Session is closed.\u001B[0m");
        }
    }

    public void updateFailure(Failure failure) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.update(failure);

            transaction.commit();

        } catch (Exception ex) {
            if (null != transaction) {
                transaction.rollback();
                LOGGER.info("\u001B[33mrollback() executed\u001B[0m");
            }
            ex.printStackTrace();
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mupdateFailure(" + failure + "): Process of updating is completed. Session is closed.\u001B[0m");
        }
    }

    public void deleteFailure(Failure failure) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.delete(failure);

            transaction.commit();

        } catch (Exception ex) {
            if (null != transaction) {
                transaction.rollback();
                LOGGER.info("\u001B[33mrollback() executed\u001B[0m");
            }
            ex.printStackTrace();
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mdeleteFailure(" + failure + "): Process of deleting is completed. Session is closed.\u001B[0m");
        }
    }

    public Failure getFailureById(final Long failureId) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Failure failure = session.find(Failure.class, failureId);

            return failure;

        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.error(ex);

            return new Failure();

        } finally {
            LOGGER.info("\u001B[33mgetFailureById(" + failureId + "): Process of searching is completed. Session is closed.\u001B[0m");
        }
    }

    public List<Failure> getListOfFailureByQueries(final String queryStatement) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            List<Failure> failureList = session.createQuery(queryStatement, Failure.class).list();

            return failureList;

        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.error(ex);

            return new ArrayList<>();

        } finally {
            LOGGER.info("\u001B[33mgetListOfFailureByQueries(" + queryStatement + "): Process of searching and " +
                    "mapping into the list is completed. Session is closed.\u001B[0m");
        }
    }

    public List<Failure> getListOfFailureByNamedQueries(final String namedQueries, final String query) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Query<Failure> failureQuery = session.createNamedQuery(namedQueries, Failure.class);

            failureQuery = failureQuery.setParameter("parameter", query);

            List<Failure> failureList = failureQuery.list();

            return failureList;

        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.error(ex);

            return new ArrayList<>();

        } finally {
            LOGGER.info("\u001B[33mgetListOfFailureByNamedQueries(" + namedQueries + ", " + query + "): Process of searching\n" +
                    " by Named Queries and mapping into the list is completed. Session is closed.\u001B[0m");
        }
    }
}