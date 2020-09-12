package carfix.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "carfixdatabase", name = "details")
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detailId")
    private Long detailId;

    @Column(name = "detailName")
    private String detailName;

    @Column(name = "price")
    private Long price;

    @ManyToOne
    @JoinColumn(name = "carId")
    private Car car;

    @OneToMany(mappedBy = "detail")
    private List<Registration> registrations;

    public Detail() {
    }

    public Detail(Long detailId, String detailName, Long price) {
        this.detailId = detailId;
        this.detailName = detailName;
        this.price = price;
    }

    public Detail(Long detailId, String detailName, Long price, Car car, List<Registration> registrations) {
        this.detailId = detailId;
        this.detailName = detailName;
        this.price = price;
        this.car = car;
        this.registrations = registrations;
    }

    public Detail(String detailName, Long price, Long carId) {
        this.detailName = detailName;
        this.price = price;
        carId = car.getCarId();
    }

    public Long getDetailId() { return detailId; }

    public void setDetailId(Long detailId) { this.detailId = detailId; }

    public String getDetailName() { return detailName; }

    public void setDetailName(String detailName) { this.detailName = detailName; }

    public Long getPrice() { return price; }

    public void setPrice(Long price) { this.price = price; }

    public Car getCar() { return car; }

    public void setCar(Long carId) { carId = car.getCarId(); }

    public List<Registration> getRegistrations() { return registrations; }

    public void setRegistrations(List<Registration> registrations) { this.registrations = registrations; }
}
