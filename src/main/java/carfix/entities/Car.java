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
@Table( name = "cars" )
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carId")
    private Long carId;

    @Column(name = "seriesName")
    @NonNull
    private String seriesName;

    @Column(name = "manufactureYear")
    @NonNull
    private Long manufactureYear;

    @Column(name = "engineDisplacement_L")
    @NonNull
    private String engineDisplacement_L;

    @Column(name = "enginePower_KW")
    @NonNull
    private Long enginePower_KW;

    @OneToMany(mappedBy = "car", fetch = FetchType.EAGER)
    private List<Work> works;

    @OneToMany(mappedBy = "car", fetch = FetchType.EAGER)
    private List<Detail> details;

}
