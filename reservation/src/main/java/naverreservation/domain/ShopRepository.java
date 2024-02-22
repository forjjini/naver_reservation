package naverreservation.domain;

import naverreservation.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "shops", path = "shops")
public interface ShopRepository
    extends PagingAndSortingRepository<Shop, Long> {}
