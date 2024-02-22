package naverreservation.domain;

import java.util.*;
import lombok.*;
import naverreservation.domain.*;
import naverreservation.infra.AbstractEvent;

@Data
@ToString
public class PaymentCancelled extends AbstractEvent {

    private Long id;
}
