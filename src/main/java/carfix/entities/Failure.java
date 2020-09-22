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
@Table( name = "failures" )
public class Failure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "failureId")
    private Long failureId;

    @Column(name = "failureName")
    @NonNull
    private String failureName;

    @OneToMany(mappedBy = "failure", fetch = FetchType.EAGER)
    private List<Work> works;

}
