package carfix.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table( name = "failures" )
public class Failure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "failureId")
    private Long failureId;

    @Column(name = "failureName")
    private String failureName;

    @OneToMany(mappedBy = "failure")
    private List<Work> works;

    public Failure(String failureName) {
        this.failureName = failureName;
    }

    @Override
    public String toString() {
        return "Failure{" +
                "failureId=" + failureId +
                ", failureName='" + failureName + '\'' +
                '}';
    }
}
