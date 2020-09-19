package carfix.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table( name = "carServices" )
public class CarService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carServiceId")
    private Long serviceId;

    @Column(name = "name")
    @NonNull
    private String name;

    @Column(name = "address")
    @NonNull
    private String address;

    @Column(name = "workTime")
    @NonNull
    private String workTime;

    @Column(name = "employeesNum")
    @NonNull
    private Long employeesNum;

    @OneToMany(mappedBy = "carService", fetch = FetchType.EAGER)
    private List<Work> works;

}
