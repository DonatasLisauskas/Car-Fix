package carfix.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table( name = "details" )
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

    public Detail(String detailName, Long price, Car car) {
        this.detailName = detailName;
        this.price = price;
        this.car = car;
    }

    public Detail(Long detailId, String detailName, Long price, Car car, List<Registration> registrations) {
        this.detailId = detailId;
        this.detailName = detailName;
        this.price = price;
        this.car = car;
        this.registrations = registrations;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "detailId=" + detailId +
                ", detailName='" + detailName + '\'' +
                ", price=" + price +
                ", car=" + car +
                '}';
    }
}
