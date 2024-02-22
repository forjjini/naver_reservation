package naverreservation.domain;

import naverreservation.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "shopReservations",
    path = "shopReservations"
)
public interface ShopReservationRepository
    extends PagingAndSortingRepository<ShopReservation, Long> {}
