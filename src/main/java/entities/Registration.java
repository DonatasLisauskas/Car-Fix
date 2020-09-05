package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "carfixdatabase", name = "registrations")
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

}
