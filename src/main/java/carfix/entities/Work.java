package carfix.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table( name = "works" )
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workId")
    private Long workId;

    @Column(name = "price")
    @NonNull
    private Long price;

    @ManyToOne
    @JoinColumn(name = "carServiceId")
    @NonNull
    private CarService carService;

    @ManyToOne
    @JoinColumn(name = "carId")
    @NonNull
    private Car car;

    @ManyToOne
    @JoinColumn(name = "failureId")
    @NonNull
    private Failure failure;

    @OneToMany(mappedBy = "work", fetch = FetchType.EAGER)
    private List<Registration> registrations;

}
