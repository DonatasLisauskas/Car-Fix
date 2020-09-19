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

    public Detail(String detailName, Long price, Car car) {
        this.detailName = detailName;
        this.price = price;
        this.car = car;
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
