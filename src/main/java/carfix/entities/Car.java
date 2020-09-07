package carfix.entities;

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
    private Long manufactureYear;

    @Column(name = "engineDisplacement_L")
    private String engineDisplacement_L;

    @Column(name = "enginePower_KW")
    private Long enginePower_KW;

    @OneToMany(mappedBy = "car")
    private List<Work> works;

    @OneToMany(mappedBy = "car")
    private List<Detail> details;

    public Car() {
    }

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

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public Long getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(Long manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public String getEngineDisplacement_L() {
        return engineDisplacement_L;
    }

    public void setEngineDisplacement_L(String engineDisplacement_L) {
        this.engineDisplacement_L = engineDisplacement_L;
    }

    public Long getEnginePower_KW() {
        return enginePower_KW;
    }

    public void setEnginePower_KW(Long enginePower_KW) {
        this.enginePower_KW = enginePower_KW;
    }

    public List<Work> getWorks() {
        return works;
    }

    public void setWorks(List<Work> works) {
        this.works = works;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", seriesName='" + seriesName + '\'' +
                ", manufactureYear='" + manufactureYear + '\'' +
                ", engineDisplacement_L=" + engineDisplacement_L +
                ", enginePower_KW=" + enginePower_KW +
                ", works=" + works +
                ", details=" + details +
                '}';
    }
}
