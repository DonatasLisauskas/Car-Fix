package carfix.dao;

import carfix.entities.Work;
import carfix.utils.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class WorkDao {

    private static final Logger LOGGER = LogManager.getLogger(WorkDao.class);

    public void createWork(Work work) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.save(work);

            transaction.commit();

        } catch (Exception ex) {
            if (null != transaction) {
                transaction.rollback();
                LOGGER.info("\u001B[33mrollback() executed\u001B[0m");
            }
            ex.printStackTrace();
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mcreateWork(" + work + "): Process of creating is completed. Session is closed.\u001B[0m");
        }
    }

    public void updateWork(Work work) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.update(work);

            transaction.commit();

        } catch (Exception ex) {
            if (null != transaction) {
                transaction.rollback();
                LOGGER.info("\u001B[33mrollback() executed\u001B[0m");
            }
            ex.printStackTrace();
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mupdateWork(" + work + "): Process of updating is completed. Session is closed.\u001B[0m");
        }
    }

    public void deleteWork(Work work) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.delete(work);

            transaction.commit();

        } catch (Exception ex) {
            if (null != transaction) {
                transaction.rollback();
                LOGGER.info("\u001B[33mrollback() executed\u001B[0m");
            }
            ex.printStackTrace();
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mdeleteWork(" + work + "): Process of deleting is completed. Session is closed.\u001B[0m");
        }
    }

    public Work getWorkById(final Long workId) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Work work = session.find(Work.class, workId);

            return work;

        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.error(ex);

            return new Work();

        } finally {
            LOGGER.info("\u001B[33mgetWorkById(" + workId + "): Process of searching is completed. Session is closed.\u001B[0m");
        }
    }

    public List<Work> getListOfWorkByQueries(final String queryStatement) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            List<Work> workList = session.createQuery(queryStatement, Work.class).list();

            return workList;

        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.error(ex);

            return new ArrayList<>();

        } finally {
            LOGGER.info("\u001B[33mgetListOfWorkByQueries(" + queryStatement + "): Process of searching \n" +
                    "and mapping into the list is completed. Session is closed.\u001B[0m");
        }
    }

    public List<Work> getListOfWorkByNamedQueries(final String namedQueries, final String query) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Query<Work> workQuery = session.createNamedQuery(namedQueries, Work.class);

            workQuery = workQuery.setParameter("parameter", query);

            List<Work> workList = workQuery.list();

            return workList;

        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.error(ex);

            return new ArrayList<>();

        } finally {
            LOGGER.info("\u001B[getListOfWorkByNamedQueries(" + namedQueries + ", " + query + "): Process of searching\n" +
                    " by Named Queries and mapping into the list is completed. Session is closed.\u001B[0m");
        }
    }
}