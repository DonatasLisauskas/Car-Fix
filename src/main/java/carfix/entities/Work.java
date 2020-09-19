package carfix.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table( name = "works" )
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workId")
    private Long workId;

    @Column(name = "price")
    private Long price;

    @ManyToOne
    @JoinColumn(name = "carServiceId")
    private CarService carService;

    @ManyToOne
    @JoinColumn(name = "carId")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "failureId")
    private Failure failure;

    // Well,there is a reason: https://www.baeldung.com/hibernate-initialize-proxy-exception
    @OneToMany(mappedBy = "work", fetch = FetchType.EAGER)
    private List<Registration> registrations;

    public Work() {}

    public Work(Long price, CarService carService, Car car, Failure failure) {
        this.price = price;
        this.carService = carService;
        this.car = car;
        this.failure = failure;
    }

    public Work(Long price, CarService carService, Car car, Failure failure, List<Registration> registrations) {
        this.price = price;
        this.carService = carService;
        this.car = car;
        this.failure = failure;
        this.registrations = registrations;
    }

    @Override
    public String toString() {
        return "Work{" +
                "workId=" + workId +
                ", price=" + price + "€" +
                ", carService=" + carService +
                ", car=" + car +
                ", failure=" + failure +
                '}';
    }
}
