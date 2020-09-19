package carfix.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table( name = "failures" )
public class Failure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "failureId")
    private Long failureId;

    @Column(name = "failureName")
    private String failureName;

    @OneToMany(mappedBy = "failure", fetch = FetchType.EAGER)
    private List<Work> works;

    public Failure() {
    }

    public Failure(String failureName) {
        this.failureName = failureName;
    }

    public Failure(Long failureId, String failureName, List<Work> works) {
        this.failureId = failureId;
        this.failureName = failureName;
        this.works = works;
    }

    @Override
    public String toString() {
        return "Failure{" +
                "failureId=" + failureId +
                ", failureName='" + failureName + '\'' +
                '}';
    }
}
