package naverreservation.domain;

import java.util.*;
import lombok.*;
import naverreservation.domain.*;
import naverreservation.infra.AbstractEvent;

@Data
@ToString
public class BookCancelled extends AbstractEvent {

    private Long shopId;
    private Date reservedDate;
    private Date reservedTime;
    private Long charge;
    private String status;
    private Long userId;
}
