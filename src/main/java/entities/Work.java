package entities;

import javax.persistence.*;

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
    private carService carservice;

    @ManyToOne
    @JoinColumn(name = "carId")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "failureId")
    private Failure failure;
}
