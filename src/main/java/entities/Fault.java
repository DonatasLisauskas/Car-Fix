package entities;

import javax.persistence.*;

@Entity
@Table(schema = "carfixdatabase", name = "Fault")
public class Fault {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long faultID;

    @Column(name = "repairID")
    private long repairID;

    @Column(name = "detailID")
    private long detailID;

}
