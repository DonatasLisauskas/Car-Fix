package Facade_Pattern;

import carfix.dao.*;

public abstract class DaoMaker {

    protected CarDao carDao;
    protected CarServiceDao carServiceDao;
    protected CustomerDao customerDao;
    protected DetailDao detailDao;
    protected FailureDao failureDao;
    protected RegistrationDao registrationDao;
    protected ScheduleDao scheduleDao;
    protected WorkDao workDao;

    protected DaoMaker() {
        carDao = new CarDao();
        carServiceDao = new CarServiceDao();
        customerDao = new CustomerDao();
        detailDao = new DetailDao();
        failureDao = new FailureDao();
        registrationDao = new RegistrationDao();
        scheduleDao = new ScheduleDao();
        workDao = new WorkDao();
    }
}
