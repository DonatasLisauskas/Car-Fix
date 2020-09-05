package carfix.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "carfixdatabase", name = "works")
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workId")
    private Long workId;

    @Column(name = "price")
    private Long price;

    @ManyToOne
    @JoinColumn(name = "carServiceId")
    private CarService carservice;

    @ManyToOne
    @JoinColumn(name = "carId")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "failureId")
    private Failure failure;

    @OneToMany(mappedBy = "work")
    private List<Registration> registrations;
}
