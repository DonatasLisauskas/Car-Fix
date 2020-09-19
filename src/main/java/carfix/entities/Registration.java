package carfix.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    public Registration(Long registrationId) {
        this.registrationId = registrationId;
    }

    public Registration(Work work, Customer customer, Detail detail) {
        this.work = work;
        this.customer = customer;
        this.detail = detail;
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
