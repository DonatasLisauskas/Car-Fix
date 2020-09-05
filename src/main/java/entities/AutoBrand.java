package entities;

import javax.persistence.*;
import java.sql.Date;


@Entity

@Table(schema = "carfixdatabase", name = "AutoBrand")
    public class AutoBrand {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long brandID;

        @Column(name = "serviceID")
        private long serviceID;

        @Column(name = "brandName")
        private String brandName;

        @Column(name = "manufacturedDate")
        private Date manufacturedDate;


       }


