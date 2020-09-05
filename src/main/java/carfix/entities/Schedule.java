package carfix.entities;

import javax.persistence.*;

@Entity
@Table(schema = "carfixdatabase", name = "schedules")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scheduleId")
    private Long scheduleId;

    @Column(name = "date")
    private String date;

    @Column(name = "time")
    private String time;

    @Column(name = "totalPrice")
    private Long totalPrice;

    @ManyToOne
    @JoinColumn(name = "registrationId")
    private Registration registration;
}
