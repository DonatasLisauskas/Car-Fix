package carfix.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table( name = "cars" )
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carId")
    private Long carId;

    @Column(name = "seriesName")
    private String seriesName;

    @Column(name = "manufactureYear")
    private Long manufactureYear;

    @Column(name = "engineDisplacement_L")
    private String engineDisplacement_L;

    @Column(name = "enginePower_KW")
    private Long enginePower_KW;

    @OneToMany(mappedBy = "car")
    private List<Work> works;

    @OneToMany(mappedBy = "car")
    private List<Detail> details;

    public Car() {}

    public Car(String seriesName, Long manufactureYear, String engineDisplacement_L, Long enginePower_KW) {
        this.seriesName = seriesName;
        this.manufactureYear = manufactureYear;
        this.engineDisplacement_L = engineDisplacement_L;
        this.enginePower_KW = enginePower_KW;
    }

    public Car(String seriesName, Long manufactureYear, String engineDisplacement_L, Long enginePower_KW, List<Work> works, List<Detail> details) {
        this.seriesName = seriesName;
        this.manufactureYear = manufactureYear;
        this.engineDisplacement_L = engineDisplacement_L;
        this.enginePower_KW = enginePower_KW;
        this.works = works;
        this.details = details;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", seriesName='" + seriesName + '\'' +
                ", manufactureYear='" + manufactureYear + '\'' +
                ", engineDisplacement_L=" + engineDisplacement_L +
                ", enginePower_KW=" + enginePower_KW;
    }
}
