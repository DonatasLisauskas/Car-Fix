package carfix.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table( name = "schedules" )
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

    public Schedule() {
    }
    public Schedule(String date, String time, Long totalPrice) {
        this.date = date;
        this.time = time;
        this.totalPrice = totalPrice;
    }

    public Schedule(String date, String time, Long totalPrice, Registration registration) {
        this.date = date;
        this.time = time;
        this.totalPrice = totalPrice;
        this.registration = registration;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", totalPrice=" + totalPrice +
                ", registration=" + registration +
                '}';
    }
}
