package carfix.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table( name = "registrations" )
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registrationId")
    private Long registrationId;

    @ManyToOne
    @JoinColumn(name = "workId")
    private Work work;

    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "detailId")
    private Detail detail;

    @OneToMany(mappedBy = "registration")
    private List<Schedule> schedules;

    public Registration() {
    }

    public Registration(Long registrationId) {
        this.registrationId = registrationId;
    }

    public Registration(Work work, Customer customer, Detail detail) {
        this.work = work;
        this.customer = customer;
        this.detail = detail;
    }

    public Registration(Work work, Customer customer, Detail detail, List<Schedule> schedules) {
        this.work = work;
        this.customer = customer;
        this.detail = detail;
        this.schedules = schedules;
    }

    public Long getRegistrationId() { return registrationId; }

    public void setRegistrationId(Long registrationId) { this.registrationId = registrationId; }

    public Work getWork() { return work; }

    public void setWork(Work work) { this.work = work; }

    public Customer getCustomer() { return customer; }

    public void setCustomer(Customer customer) { this.customer = customer; }

    public Detail getDetail() { return detail; }

    public void setDetail(Detail detail) { this.detail = detail; }

    public List<Schedule> getSchedules() { return schedules; }

    public void setSchedules(List<Schedule> schedules) { this.schedules = schedules; }

    @Override
    public String toString() {
        return "Registration{" +
                "registrationId=" + registrationId +
                ", work=" + work +
                ", customer=" + customer +
                ", detail=" + detail +
                '}';
    }
}
