package entities;

import javax.persistence.*;

@Entity

@Table(schema = "carfixdatabase", name = "ContactInfo")
public class ContactInfo {

    @Column(name = "serviceID")
    private long serviceID;

    @Column(name = "address")
    private String address;

    @Column(name = "workingHours")
    private String workingHours;

    @Column(name = "employeeNumber")
    private int employeeNumber;

    @Column(name ="tools")
    private String tools;

}