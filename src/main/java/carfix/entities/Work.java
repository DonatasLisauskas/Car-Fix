package carfix.entities;

import javax.persistence.*;
import java.util.List;

@Entity
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

    @OneToMany(mappedBy = "work")
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

    public Long getWorkId() { return workId; }

    public void setWorkId(Long workId) { this.workId = workId; }

    public Long getPrice() { return price; }

    public void setPrice(Long price) { this.price = price; }

    public CarService getCarService() { return carService; }

    public void setCarService(CarService carService) { this.carService = carService; }

    public Car getCar() { return car; }

    public void setCar(Car car) { this.car = car; }

    public Failure getFailure() { return failure; }

    public void setFailure(Failure failure) { this.failure = failure; }

    public List<Registration> getRegistrations() { return registrations; }

    public void setRegistrations(List<Registration> registrations) { this.registrations = registrations; }

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
