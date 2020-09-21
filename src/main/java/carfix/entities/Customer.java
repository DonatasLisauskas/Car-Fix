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
@Table( name = "customers" )
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    private Long customerId;

    @Column(name = "firstName")
    @NonNull
    private String firstName;

    @Column(name = "lastName")
    @NonNull
    private String lastName;

    @Column(name = "email")
    @NonNull
    private String email;

    @Column(name = "phoneNumber")
    @NonNull
    private Long phoneNumber;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private List<Registration> registrations;

}
