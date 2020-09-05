package entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(schema = "carfixdatabase", name = "Registry")
public class Registry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long registryID;

    @Column(name = "registryDate")
    private LocalDate registryDate;

    @Column(name = "registryTime")
    private LocalTime registryTime;

    @Column(name = "serviceID")
    private long serviceID;

    @Column(name = "repairID")
    private long repairID;
}
