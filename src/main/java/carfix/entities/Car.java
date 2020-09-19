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
@AllArgsConstructor
@NoArgsConstructor
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

    @OneToMany(mappedBy = "car", fetch = FetchType.EAGER)
    private List<Work> works;

    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY)
    private List<Detail> details;

    public Car(String seriesName, Long manufactureYear, String engineDisplacement_L, Long enginePower_KW) {
        this.seriesName = seriesName;
        this.manufactureYear = manufactureYear;
        this.engineDisplacement_L = engineDisplacement_L;
        this.enginePower_KW = enginePower_KW;
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
