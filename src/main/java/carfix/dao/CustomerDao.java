package carfix.dao;

import carfix.entities.Customer;
import carfix.utils.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CustomerDao {

    private static final Logger LOGGER = LogManager.getLogger(CustomerDao.class);

    public void createCustomer(Customer customer) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.save(customer);

            transaction.commit();

        } catch (Exception ex) {
            if (null != transaction) {
                transaction.rollback();
                LOGGER.info("\u001B[33mrollback() executed\u001B[0m");
            }
            ex.printStackTrace();
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mCreateCustomer(" + customer + "): Process of creating is completed. Session is closed.\u001B[0m");
        }
    }

    public void updateCustomer(Customer customer) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.update(customer);

            transaction.commit();

        } catch (Exception ex) {
            if (null != transaction) {
                transaction.rollback();
                LOGGER.info("\u001B[33mrollback() executed\u001B[0m");
            }
            ex.printStackTrace();
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mupdateCustomer(" + customer + "): Process of updating is completed. Session is closed.\u001B[0m");
        }
    }

    public void deleteCustomer(Customer customer) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.delete(customer);

            transaction.commit();

        } catch (Exception ex) {
            if (null != transaction) {
                transaction.rollback();
                LOGGER.info("\u001B[33mrollback() executed\u001B[0m");
            }
            ex.printStackTrace();
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mdeleteCustomer(" + customer + "): Process of deleting is completed. Session is closed.\u001B[0m");
        }
    }

    public Customer getCustomerById(final Long customerId) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Customer customer = session.find(Customer.class, customerId);

            return customer;

        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.error(ex);
            return null;
        } finally {
            LOGGER.info("\u001B[33mgetCustomerById(" + customerId + "): Process of searching is completed. Session is closed.\u001B[0m");
        }
    }

    public List<Customer> getListOfCustomerByQueries(final String queryStatement) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            List<Customer> customerList = session.createQuery(queryStatement, Customer.class).list();

            return customerList;

        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.error(ex);
            return null;
        } finally {
            LOGGER.info("\u001B[33mgetListOfCustomerByQueries(" + queryStatement + "): Process of searching " +
                    "and mapping into the list is completed. Session is closed.\u001B[0m");
        }
    }

    public List<Customer> getListOfCustomerByNamedQueries(final String namedQueries, final String query) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Query<Customer> customerQuery = session.createNamedQuery(namedQueries, Customer.class);

            customerQuery = customerQuery.setParameter("parameter", query);

            List<Customer> customerList = customerQuery.list();

            return customerList;

        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.error(ex);
            return null;
        } finally {
            LOGGER.info("\u001B[33mgetListOfCustomerByNamedQueries(" + namedQueries + ", " + query + "): Process of searching\n" +
                    " by Named Queries and mapping into the list is completed. Session is closed.\u001B[0m");
        }
    }
}