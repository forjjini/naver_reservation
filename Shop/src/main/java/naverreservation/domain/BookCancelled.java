package naverreservation.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import naverreservation.domain.*;
import naverreservation.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class BookCancelled extends AbstractEvent {

    private Long shopId;
    private Date reservedDate;
    private Date reservedTime;
    private Long charge;
    private String status;
    private Long userId;

    public BookCancelled(ShopReservation aggregate) {
        super(aggregate);
    }

    public BookCancelled() {
        super();
    }
}
//>>> DDD / Domain Event
