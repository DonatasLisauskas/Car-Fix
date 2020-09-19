package carfix.dao;

import carfix.entities.Schedule;
import carfix.utils.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ScheduleDao {

    private static final Logger LOGGER = LogManager.getLogger(ScheduleDao.class);

    public void createSchedule(Schedule schedule) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.save(schedule);

            transaction.commit();

        } catch (Exception ex) {
            if (null != transaction) {
                transaction.rollback();
                LOGGER.info("\u001B[33mrollback() executed\u001B[0m");
            }
            ex.printStackTrace();
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mCreateSchedule(" + schedule + "): Process of creating is completed. Session is closed.\u001B[0m");
        }
    }

    public void updateSchedule(Schedule schedule) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.update(schedule);

            transaction.commit();

        } catch (Exception ex) {
            if (null != transaction) {
                transaction.rollback();
                LOGGER.info("\u001B[33mrollback() executed\u001B[0m");
            }
            ex.printStackTrace();
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mupdateSchedule(" + schedule + "): Process of updating is completed. Session is closed.\u001B[0m");
        }
    }

    public void deleteSchedule(Schedule schedule) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.delete(schedule);

            transaction.commit();

        } catch (Exception ex) {
            if (null != transaction) {
                transaction.rollback();
                LOGGER.info("\u001B[33mrollback() executed\u001B[0m");
            }
            ex.printStackTrace();
            LOGGER.error(ex);
        } finally {
            LOGGER.info("\u001B[33mdeleteSchedule(" + schedule + "): Process of deleting is completed. Session is closed.\u001B[0m");
        }
    }

    public Schedule getScheduleById(final Long scheduleId) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Schedule schedule = session.find(Schedule.class, scheduleId);

            return schedule;

        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.error(ex);

            // It can be empty object? then use it
            return new Schedule();

        } finally {
            LOGGER.info("\u001B[33mgetScheduleById(" + scheduleId + "): Process of searching is completed. Session is closed.\u001B[0m");
        }
    }

    public List<Schedule> getListOfScheduleByQueries(final String queryStatement) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            List<Schedule> scheduleList = session.createQuery(queryStatement, Schedule.class).list();

            return scheduleList;

        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.error(ex);

            // Do not return nulls, not recommended
            return new ArrayList<>();

        } finally {
            LOGGER.info("\u001B[33mgetListOfScheduleByQueries(" + queryStatement + "): Process of searching " +
                    "and mapping into the list is completed. Session is closed.\u001B[0m");
        }
    }

    public List<Schedule> getListOfScheduleByNamedQueries(final String namedQueries, final String query) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Query<Schedule> scheduleQuery = session.createNamedQuery(namedQueries, Schedule.class);

            scheduleQuery = scheduleQuery.setParameter("parameter", query);

            List<Schedule> scheduleList = scheduleQuery.list();

            return scheduleList;

        } catch (Exception ex) {
            ex.printStackTrace();
            LOGGER.error(ex);

            return new ArrayList<>();

        } finally {
            LOGGER.info("\u001B[33mgetListOfScheduleByNamedQueries(" + namedQueries + ", " + query + "): Process of searching\n" +
                    " by Named Queries and mapping into the list is completed. Session is closed.\u001B[0m");
        }
    }
}
