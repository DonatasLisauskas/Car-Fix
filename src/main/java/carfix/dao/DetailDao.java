package carfix.dao;

import carfix.entities.Detail;
import carfix.utils.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class DetailDao {

    private static final Logger LOGGER = LogManager.getLogger(DetailDao.class);

    public void createDetail(Detail detail) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.save(detail);

            transaction.commit();

        } catch (Exception ex) {
            if (null != transaction) {
                transaction.rollback();
                LOGGER.info("\u001B[33mrollback() executed\u001B[0m");
            }
            ex.printStackTrace();
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mCreateDetail(" + detail + "): Process of creating is completed. Session is closed.\u001B[0m");
        }
    }

    public void updateDetail(Detail detail) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.update(detail);

            transaction.commit();

        } catch (Exception ex) {
            if (null != transaction) {
                transaction.rollback();
                LOGGER.info("\u001B[33mrollback() executed\u001B[0m");
            }
            ex.printStackTrace();
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mupdateDetail(" + detail + "): Process of updating is completed. Session is closed.\u001B[0m");
        }
    }

    public void deleteDetail(Detail detail) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.delete(detail);

            transaction.commit();

        } catch (Exception ex) {
            if (null != transaction) {
                transaction.rollback();
                LOGGER.info("\u001B[33mrollback() executed\u001B[0m");
            }
            ex.printStackTrace();
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mdeleteDetail(" + detail + "): Process of deleting is completed. Session is closed.\u001B[0m");
        }
    }

    public Detail getDetailById(final Long detailId) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Detail detail = session.find(Detail.class, detailId);

            return detail;

        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.error(ex);

            return new Detail();

        } finally {
            LOGGER.info("\u001B[33mgetDetailById(" + detailId + "): Process of searching is completed. Session is closed.\u001B[0m");
        }
    }

    public List<Detail> getListOfDetailByQueries(final String queryStatement) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            List<Detail> detailList = session.createQuery(queryStatement, Detail.class).list();

            return detailList;

        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.error(ex);

            return new ArrayList<>();

        } finally {
            LOGGER.info("\u001B[33mgetListOfDetailByQueries(" + queryStatement + "): Process of searching " +
                    "and mapping into the list is completed. Session is closed.\u001B[0m");
        }
    }

    public List<Detail> getListOfDetailByNamedQueries(final String namedQueries, final String query) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Query<Detail> detailQuery = session.createNamedQuery(namedQueries, Detail.class);

            detailQuery = detailQuery.setParameter("parameter", query);

            List<Detail> detailList = detailQuery.list();

            return detailList;

        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.error(ex);

            return new ArrayList<>();

        } finally {
            LOGGER.info("\u001B[33mgetListOfDetailByNamedQueries(" + namedQueries + ", " + query + "): Process of searching\n" +
                    " by Named Queries and mapping into the list is completed. Session is closed.\u001B[0m");
        }
    }
}