package carfix.dao;

import carfix.entities.Registration;
import carfix.utils.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class RegistrationDao {

    private static final Logger LOGGER = LogManager.getLogger(RegistrationDao.class);

    public void createRegistration(Registration registration) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.save(registration);

            transaction.commit();

        } catch (Exception ex) {
            if (null != transaction) {
                transaction.rollback();
                LOGGER.info("\u001B[33mrollback() executed\u001B[0m");
            }
            ex.printStackTrace();
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mCreateRegistration(" + registration + "): Process of creating is completed. Session is closed.\u001B[0m");
        }
    }

    public void updateRegistration(Registration registration) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.update(registration);

            transaction.commit();

        } catch (Exception ex) {
            if (null != transaction) {
                transaction.rollback();
                LOGGER.info("\u001B[33mrollback() executed\u001B[0m");
            }
            ex.printStackTrace();
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mupdateRegistration(" + registration + "): Process of updating is completed. Session is closed.\u001B[0m");
        }
    }

    public void deleteRegistration(Registration registration) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.delete(registration);

            transaction.commit();

        } catch (Exception ex) {
            if (null != transaction) {
                transaction.rollback();
                LOGGER.info("\u001B[33mrollback() executed\u001B[0m");
            }
            ex.printStackTrace();
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mdeleteRegistration(" + registration + "): Process of deleting is completed. Session is closed.\u001B[0m");
        }
    }

    public Registration getRegistrationById(final Long registrationId) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Registration registration = session.find(Registration.class, registrationId);

            return registration;

        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.error(ex);
            return null;
        } finally {
            LOGGER.info("\u001B[33mgetRegistrationById(" + registrationId + "): Process of searching is completed. Session is closed.\u001B[0m");
        }
    }

    public List<Registration> getListOfRegistrationByQueries(final String queryStatement) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            List<Registration> registrationList = session.createQuery(queryStatement, Registration.class).list();

            return registrationList;

        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.error(ex);
            return null;
        } finally {
            LOGGER.info("\u001B[33mgetListOfRegistrationByQueries(" + queryStatement + "): Process of searching " +
                    "and mapping into the list is completed. Session is closed.\u001B[0m");
        }
    }

    public List<Registration> getListOfRegistrationByNamedQueries(final String namedQueries, final String query) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Query<Registration> registrationQuery = session.createNamedQuery(namedQueries, Registration.class);

            registrationQuery = registrationQuery.setParameter("parameter", query);

            List<Registration> registrationList = registrationQuery.list();

            return registrationList;

        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.error(ex);
            return null;
        } finally {
            LOGGER.info("\u001B[33mgetListOfRegistrationByNamedQueries(" + namedQueries + ", " + query + "): Process of searching\n" +
                    " by Named Queries and mapping into the list is completed. Session is closed.\u001B[0m");
        }
    }
}
