package beer.rest;

import beer.dto.BeerDto;
import beer.service.BeerService;
import beer.task.Sync;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BeerResource {

    private Logger log = LoggerFactory.getLogger(BeerResource.class);

    @Autowired
    private Sync sync;

    @Autowired
    private BeerService beerService;

    @GetMapping("/foodpairings/search/{phrase}")
    public ResponseEntity<List<BeerDto>> findBeersByFoodParing(@PathVariable("phrase") String phrase) {
        log.info("Request for searching beers by foodpairing containing {}", phrase);
        return new ResponseEntity<>(beerService.findByFoodPairing(phrase), HttpStatus.OK);
    }

    @PostMapping("/beers")
    public ResponseEntity<List<BeerDto>> createBeer(@RequestBody List<BeerDto> dtos) {
        log.info("Request for saving and updating beers {}", dtos);
        return new ResponseEntity<>(beerService.saveUpdate(dtos), HttpStatus.OK);
    }
}
