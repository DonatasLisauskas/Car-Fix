package carfix.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

import static carfix.Validation.Regexp.INVALID_SERIES_NAME;
import static carfix.Validation.Regexp.SERIES_NAME;

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

    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY)
    private List<Detail> details;

}
