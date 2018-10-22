package beer.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Long punkApiId;

    private String name;

    private String tagline;

    private String firstBrewed;

    @Column(columnDefinition = "VARCHAR", length = 65535)
    private String description;

    private String imageUrl;

    private Long ibu;

    @OneToMany(mappedBy = "beer", cascade = CascadeType.ALL)
    private List<FoodPairing> foodPairings = new ArrayList<>();

    public Beer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<FoodPairing> getFoodPairings() {
        return foodPairings;
    }

    public void setFoodPairings(List<FoodPairing> foodPairings) {
        this.foodPairings = foodPairings;
    }

    public void addToChildren(FoodPairing foodPairing) {
        foodPairing.setBeer(this);
        this.foodPairings.add(foodPairing);
    }

    public void addToChildren(List<FoodPairing> foodPairings) {
        foodPairings.forEach(this::addToChildren);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Beer)) return false;
        Beer beer = (Beer) o;
        return Objects.equals(getId(), beer.getId()) &&
                Objects.equals(getPunkApiId(), beer.getPunkApiId()) &&
                Objects.equals(getName(), beer.getName()) &&
                Objects.equals(getTagline(), beer.getTagline()) &&
                Objects.equals(getFirstBrewed(), beer.getFirstBrewed()) &&
                Objects.equals(getDescription(), beer.getDescription()) &&
                Objects.equals(getImageUrl(), beer.getImageUrl()) &&
                Objects.equals(getIbu(), beer.getIbu()) &&
                Objects.equals(getFoodPairings(), beer.getFoodPairings());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPunkApiId(), getName(), getTagline(), getFirstBrewed(), getDescription(), getImageUrl(), getIbu(), getFoodPairings());
    }

    @Override
    public String toString() {
        return "Beer{" +
                "id=" + id +
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
