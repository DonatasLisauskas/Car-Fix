package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "carfixdatabase", name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carId")
    private Long carId;

    @Column(name = "seriesName")
    private String seriesName;

    @Column(name = "manufactureYear")
    private String manufactureYear;

    @Column(name = "engineDisplacement_L")
    private Long engineDisplacement_L;

    @Column(name = "enginePower_KW")
    private Long enginePower_KW;

    @OneToMany(mappedBy = "car")
    private List<Work> works;
}
