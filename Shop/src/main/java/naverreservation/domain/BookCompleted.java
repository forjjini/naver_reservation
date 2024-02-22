package naverreservation.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import naverreservation.domain.*;
import naverreservation.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class BookCompleted extends AbstractEvent {

    private Long shopId;
    private Date reservedDate;
    private Date reservedTime;
    private Long charge;
    private String status;
    private Long userId;

    public BookCompleted(ShopReservation aggregate) {
        super(aggregate);
    }

    public BookCompleted() {
        super();
    }
}
//>>> DDD / Domain Event
