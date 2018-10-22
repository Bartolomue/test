package beer.mapper;

import beer.domain.Beer;
import beer.domain.FoodPairing;
import beer.dto.BeerDto;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class BeerMapper {

    public Beer toEntity(BeerDto dto) {
        Beer beer = new Beer();
        beer.setId(dto.getDbId());
        beer.setPunkApiId(dto.getPunkApiId());
        beer.setName(dto.getName());
        beer.setTagline(dto.getTagline());
        beer.setFirstBrewed(dto.getFirstBrewed());
        beer.setDescription(dto.getDescription());
        beer.setImageUrl(dto.getImageUrl());
        beer.setIbu(dto.getIbu());
        return beer;
    }

    public BeerDto toDto(Beer beer) {
        BeerDto dto = new BeerDto();
        dto.setDbId(beer.getId());
        dto.setPunkApiId(beer.getPunkApiId());
        dto.setName(beer.getName());
        dto.setTagline(beer.getTagline());
        dto.setFirstBrewed(beer.getFirstBrewed());
        dto.setDescription(beer.getDescription());
        dto.setImageUrl(beer.getImageUrl());
        dto.setIbu(beer.getIbu());
        dto.setFoodPairings(beer.getFoodPairings().stream().map(FoodPairing::getValue).collect(Collectors.toList()));
        return dto;
    }

}
