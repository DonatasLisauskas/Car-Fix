package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "carfixdatabase", name = "carServices")
public class carService {

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

    @OneToMany(mappedBy = "carservice")
    private List<Work> works;



}
