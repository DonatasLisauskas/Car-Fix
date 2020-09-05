package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(schema = "carfixdatabase", name = "failures")
public class Failure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "failureId")
    private Long failureId;

    @Column(name = "failureName")
    private String failureName;

    @OneToMany(mappedBy = "failure")
    private List<Work> works;
}
