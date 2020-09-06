package carfix.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "carfixdatabase", name = "carServices")
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

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public Long getEmployeesNum() {
        return employeesNum;
    }

    public void setEmployeesNum(Long employeesNum) {
        this.employeesNum = employeesNum;
    }

    public List<Work> getWorks() {
        return works;
    }

    public void setWorks(List<Work> works) {
        this.works = works;
    }
}
