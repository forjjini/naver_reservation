package naverreservation.infra;

import java.util.List;
import naverreservation.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "reservationInfos",
    path = "reservationInfos"
)
public interface ReservationInfoRepository
    extends PagingAndSortingRepository<ReservationInfo, Long> {}
