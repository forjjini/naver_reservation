package naverreservation.external;

import java.util.Date;
import lombok.Data;

@Data
public class Shop {

    private Long id;
    private Long shopId;
    private Date reservedDate;
    private Integer reservedCnt;
    private Date reservedTime;
    private Long charge;
    private String name;
    private String name;
}
