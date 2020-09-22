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
@Table(name = "details")
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detailId")
    private Long detailId;

    @Column(name = "detailName")
    @NonNull
    private String detailName;

    @Column(name = "price")
    @NonNull
    private Long price;

    @ManyToOne
    @JoinColumn(name = "carId")
    @NonNull
    private Car car;

    @OneToMany(mappedBy = "detail", fetch = FetchType.LAZY)
    private List<Registration> registrations;

}
