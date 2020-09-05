package entities;

import javax.persistence.*;

@Entity
@Table(schema = "carfixdatabase", name = "service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;

    @Column(name = "serviceName")
    private String serviceName;




}
