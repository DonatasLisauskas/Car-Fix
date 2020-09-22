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
@ToString
@Table( name = "customers" )
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    private Long customerId;

    @Pattern(regexp = NAME_LASTNAME, message = INVALID_NAME_LASTNAME)
    @Column(name = "firstName")
    @NonNull
    private String firstName;

    @Pattern(regexp = NAME_LASTNAME, message = INVALID_NAME_LASTNAME)
    @Column(name = "lastName")
    @NonNull
    private String lastName;

    @Pattern(regexp= EMAIL, message = INVALID_EMAIL)
    @Column(name = "email")
    @NonNull
    private String email;

    @Pattern(regexp = PHONE_NUMBER, message = INVALID_PHONE_NUMBER)
    @Column(name = "phoneNumber")
    @NonNull
    private String phoneNumber;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private List<Registration> registrations;
}
