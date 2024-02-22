package naverreservation.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import naverreservation.infra.AbstractEvent;

@Data
public class BookCompleted extends AbstractEvent {

    private Long shopId;
    private Date reservedDate;
    private Date reservedTime;
    private Long charge;
    private String status;
    private Long userId;
}
