package beer.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BeerDto {

//    Example beer
//
//    "id": 192,
//    "name": "Punk IPA 2007 - 2010",
//    "tagline": "Post Modern Classic. Spiky. Tropical. Hoppy.",
//    "first_brewed": "04/2007",
//    "description": "Our flagship beer that kick started the craft beer revolution. This is James and Martin's original take on an American IPA, subverted with punchy New Zealand hops. Layered with new world hops to create an all-out riot of grapefruit, pineapple and lychee before a spiky, mouth-puckering bitter finish.",
//    "image_url": "https://images.punkapi.com/v2/192.png",
//    "ibu": 60.0,
//    "food_pairing": [
//            "Spicy carne asada with a pico de gallo sauce",
//            "Shredded chicken tacos with a mango chilli lime salsa",
//            "Cheesecake with a passion fruit swirl sauce"
//    ]
    @JsonIgnore
    @JsonProperty("dbId")
    private Long dbId;

    @JsonProperty("id")
    private Long punkApiId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("tagline")
    private String tagline;

    @JsonProperty("first_brewed")
    private String firstBrewed;

    @JsonProperty("description")
    private String description;

    @JsonProperty("image_url")
    private String imageUrl;

    @JsonProperty("ibu")
    private Long ibu;

    @JsonProperty("food_pairing")
    private List<String> foodPairings;

    public BeerDto() {
    }

    public Long getDbId() {
        return dbId;
    }

    public void setDbId(Long dbId) {
        this.dbId = dbId;
    }

    public Long getPunkApiId() {
        return punkApiId;
    }

    public void setPunkApiId(Long punkApiId) {
        this.punkApiId = punkApiId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getFirstBrewed() {
        return firstBrewed;
    }

    public void setFirstBrewed(String firstBrewed) {
        this.firstBrewed = firstBrewed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getIbu() {
        return ibu;
    }

    public void setIbu(Long ibu) {
        this.ibu = ibu;
    }

    public List<String> getFoodPairings() {
        return foodPairings;
    }

    public void setFoodPairings(List<String> foodPairings) {
        this.foodPairings = foodPairings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BeerDto)) return false;
        BeerDto beerDto = (BeerDto) o;
        return Objects.equals(getDbId(), beerDto.getDbId()) &&
                Objects.equals(getPunkApiId(), beerDto.getPunkApiId()) &&
                Objects.equals(getName(), beerDto.getName()) &&
                Objects.equals(getTagline(), beerDto.getTagline()) &&
                Objects.equals(getFirstBrewed(), beerDto.getFirstBrewed()) &&
                Objects.equals(getDescription(), beerDto.getDescription()) &&
                Objects.equals(getImageUrl(), beerDto.getImageUrl()) &&
                Objects.equals(getIbu(), beerDto.getIbu()) &&
                Objects.equals(getFoodPairings(), beerDto.getFoodPairings());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDbId(), getPunkApiId(), getName(), getTagline(), getFirstBrewed(), getDescription(), getImageUrl(), getIbu(), getFoodPairings());
    }

    @Override
    public String toString() {
        return "BeerDto{" +
                "dbId=" + dbId +
                ", punkApiId=" + punkApiId +
                ", name='" + name + '\'' +
                ", tagline='" + tagline + '\'' +
                ", firstBrewed='" + firstBrewed + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", ibu=" + ibu +
                ", foodPairings=" + foodPairings +
                '}';
    }
}
