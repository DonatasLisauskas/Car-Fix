package carfix.entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table( name = "schedules" )
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scheduleId")
    private Long scheduleId;

    @Column(name = "date")
    @NonNull
    private Date date; //TODO: write a JUnit test for what kind of writing format of SQL date is.

    @Column(name = "time")
    @NonNull
    private Time time;  //TODO: write a JUnit test for what kind of writing format of SQL time is.

    @Column(name = "totalPrice")
    @NonNull
    private Long totalPrice;

    @ManyToOne
    @JoinColumn(name = "registrationId")
    @NonNull
    private Registration registration;

}
