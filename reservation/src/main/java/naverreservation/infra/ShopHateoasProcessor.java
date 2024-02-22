package naverreservation.infra;

import naverreservation.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ShopHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Shop>> {

    @Override
    public EntityModel<Shop> process(EntityModel<Shop> model) {
        return model;
    }
}
