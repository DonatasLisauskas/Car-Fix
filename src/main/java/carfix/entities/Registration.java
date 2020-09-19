package carfix.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
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

    @OneToMany(mappedBy = "registration", fetch = FetchType.EAGER)
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
