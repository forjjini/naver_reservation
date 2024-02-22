package naverreservation.infra;

import naverreservation.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ShopReservationHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<ShopReservation>> {

    @Override
    public EntityModel<ShopReservation> process(
        EntityModel<ShopReservation> model
    ) {
        return model;
    }
}
