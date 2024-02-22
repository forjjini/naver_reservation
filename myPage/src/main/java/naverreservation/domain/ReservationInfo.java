package naverreservation.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

//<<< EDA / CQRS
@Entity
@Table(name = "ReservationInfo_table")
@Data
public class ReservationInfo {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long shopId;
    private String name;
    private Date reservedDate;
    private Date reservedTime;
    private Long charge;
    private String status;
}
