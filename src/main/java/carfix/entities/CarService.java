package carfix.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table( name = "carServices" )
public class CarService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carServiceId")
    private Long serviceId;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "workTime")
    private String workTime;

    @Column(name = "employeesNum")
    private Long employeesNum;

    @OneToMany(mappedBy = "carService")
    private List<Work> works;

    public CarService() {
    }

    public CarService(String name, String address, String workTime, Long employeesNum) {
        this.name = name;
        this.address = address;
        this.workTime = workTime;
        this.employeesNum = employeesNum;
    }

    public CarService(String name, String address, String workTime, Long employeesNum, List<Work> works) {
        this.name = name;
        this.address = address;
        this.workTime = workTime;
        this.employeesNum = employeesNum;
        this.works = works;
    }

    @Override
    public String toString() {
        return "CarService{" +
                "serviceId=" + serviceId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", workTime='" + workTime + '\'' +
                ", employeesNum=" + employeesNum +
                '}';
    }
}
