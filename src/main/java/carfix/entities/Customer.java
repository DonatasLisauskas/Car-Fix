package carfix.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

import static carfix.utils.ValidationMessages.INVALID_EMAIL;
import static carfix.utils.ValidationMessages.REGEX_PHONE_NUMBERS;

@Entity
@Getter
@Setter
@Table( name = "customers" )
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerId")
    private Long customerId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    // Looks ugly, but serves the purpose
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\."
            +"[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
            +"(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?",
            message= INVALID_EMAIL)
    @Column(name = "email")
    @NotNull
    private String email;

    // Let's load from properties instead:
    @Column(  name = "phoneNumber" )
    @Pattern( regexp= REGEX_PHONE_NUMBERS, message="{invalid.phonenumber}")
    @NotNull
    private Long phoneNumber;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private List<Registration> registrations;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String email, Long phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Customer(String firstName, String lastName, String email, Long phoneNumber, List<Registration> registrations) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.registrations = registrations;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
