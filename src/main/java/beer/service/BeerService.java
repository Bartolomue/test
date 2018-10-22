package beer.service;

import beer.domain.Beer;
import beer.domain.FoodPairing;
import beer.dto.BeerDto;
import beer.mapper.BeerMapper;
import beer.repository.BeerRepository;
import beer.repository.FoodPairingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BeerService {

    private Logger log = LoggerFactory.getLogger(BeerService.class);

    @Autowired
    private BeerRepository beerRepository;

    @Autowired
    private FoodPairingRepository foodPairingRepository;

    @Autowired
    private BeerMapper mapper;

    /**
      * Should update existing beers according to punk_api_id, add new ones and retain untouched
      */
    public List<BeerDto> saveUpdate(List<BeerDto> beers) {
        log.info("Updating beers in db");
        List<BeerDto> updatedBeers = beers.stream().map(this::saveUpdate).collect(Collectors.toList());
        log.info("Updated beers: {}", updatedBeers);
        return updatedBeers;
    }

    public BeerDto saveUpdate(BeerDto dto) {
        if (dto == null || dto.getPunkApiId() == null) {
            throw new IllegalArgumentException("PunkApiId can not be null");
        }

        Long beerId = beerRepository.findBeerIdByPunkApiId(dto.getPunkApiId());

        Beer beer;
        if (beerId == null) {
            beer = mapper.toEntity(dto);
        } else {
            beer = beerRepository.getOne(dto.getDbId());
            beer = mapToEntity(beer, dto);
        }

        List<FoodPairing> foodPairings = dto.getFoodPairings() == null ? new ArrayList<>() : dto.getFoodPairings().stream().map(FoodPairing::new).collect(Collectors.toList());
        beer.addToChildren(foodPairings);

        return mapper.toDto(beerRepository.save(beer));
    }

    private Beer mapToEntity(Beer beer, BeerDto dto) {
        beer.setId(beer.getId());
        beer.setPunkApiId(dto.getPunkApiId());
        beer.setName(dto.getName());
        beer.setTagline(dto.getTagline());
        beer.setFirstBrewed(dto.getFirstBrewed());
        beer.setDescription(dto.getDescription());
        beer.setImageUrl(dto.getImageUrl());
        beer.setIbu(dto.getIbu());
        return beer;
    }

    public List<BeerDto> findByFoodPairing(String phrase) {
        return beerRepository.findByFoodPairing(phrase.toLowerCase()).stream().map(mapper::toDto).collect(Collectors.toList());
    }
}