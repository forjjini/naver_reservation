package naverreservation.external;

import java.util.Date;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "reservation", url = "${api.url.reservation}")
public interface ShopService {
    @GetMapping(path = "/shops")
    public List<Shop> getShop();

    @GetMapping(path = "/shops/{id}")
    public Shop getShop(@PathVariable("id") Long id);
}
