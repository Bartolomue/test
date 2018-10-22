package beer.task;

import beer.dto.BeerDto;
import beer.service.BeerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class Sync {

    private static final String API_URL = "https://api.punkapi.com/v2/beers";

    private Logger log = LoggerFactory.getLogger(Sync.class);

    private static RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private BeerService beerService;

    @Scheduled(fixedRate = 3600000)
    public void syncBeers() {
        log.info("Request for beers from: {}", API_URL);
        List<BeerDto> beers = new ArrayList<>();
        try {
            beers = restTemplate.exchange(API_URL, HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<BeerDto>>() {
                    }).getBody();
        } catch (Exception e) {
            log.error("Request for beer failed {}", e.getCause());
        }
        beerService.saveUpdate(beers);
    }
}
