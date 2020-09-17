package carfix.entities;

import javax.persistence.*;
import java.util.List;

@Entity
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

    public Long getFailureId() { return failureId; }

    public void setFailureId(Long failureId) { this.failureId = failureId; }

    public String getFailureName() { return failureName; }

    public void setFailureName(String failureName) { this.failureName = failureName; }

    public List<Work> getWorks() { return works; }

    public void setWorks(List<Work> works) { this.works = works; }

    @Override
    public String toString() {
        return "Failure{" +
                "failureId=" + failureId +
                ", failureName='" + failureName + '\'' +
                '}';
    }
}
