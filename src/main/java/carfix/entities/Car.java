package carfix.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

import static carfix.Validation.Regexp.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Table( name = "cars" )
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carId")
    private Long carId;

    @Pattern(regexp = SERIES_NAME, message = INVALID_SERIES_NAME)
    @Column(name = "seriesName")
    @NonNull
    private String seriesName;

    @Pattern(regexp = MANUFACTURE_YEAR,message = INVALID_MANUFACTURE_YEAR)
    @Column(name = "manufactureYear")
    @NonNull
    private Long manufactureYear;

    @Pattern(regexp = ENGINE_DISPLACEMENT, message = INVALID_ENGINE_DISPLACEMENT)
    @Column(name = "engineDisplacement_L")
    @NonNull
    private String engineDisplacement_L;

    @Pattern(regexp = ID_OR_NUMBER, message = INVALID_ID_OR_NUMBER)
    @Column(name = "enginePower_KW")
    @NonNull
    private Long enginePower_KW;

    @OneToMany(mappedBy = "car", fetch = FetchType.EAGER)
    private List<Work> works;

    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY)
    private List<Detail> details;

}
