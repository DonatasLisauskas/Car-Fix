package entities;

import javax.persistence.*;

@Entity
@Table(schema = "carfixdatabase", name = "Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountID;

    @Column(name = "repairPrice")
    private double repairPrice;

    @Column(name = "detailPrice")
    private double detailPrice;

    @Column(name = "totalPrice")
    private double totalPrice;

    @Column(name = "invoice")
    private boolean invoice;


}
