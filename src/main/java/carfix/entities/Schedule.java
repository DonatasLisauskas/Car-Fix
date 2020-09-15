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

    public Long getScheduleId() { return scheduleId; }

    public void setScheduleId(Long scheduleId) { this.scheduleId = scheduleId; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public String getTime() { return time; }

    public void setTime(String time) { this.time = time; }

    public Long getTotalPrice() { return totalPrice; }

    public void setTotalPrice(Long totalPrice) { this.totalPrice = totalPrice; }

    public Registration getRegistration() { return registration; }

    public void setRegistration(Registration registration) { this.registration = registration; }

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
