package entities;

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

}
