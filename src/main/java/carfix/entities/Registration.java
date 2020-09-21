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
@Table(name = "registrations")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registrationId")
    private Long registrationId;

    @ManyToOne
    @JoinColumn(name = "workId")
    @NonNull
    private Work work;

    @ManyToOne
    @JoinColumn(name = "customerId")
    @NonNull
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "detailId")
    @NonNull
    private Detail detail;

    @OneToMany(mappedBy = "registration", fetch = FetchType.EAGER)
    private List<Schedule> schedules;

}
