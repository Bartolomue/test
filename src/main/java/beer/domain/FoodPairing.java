package beer.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class FoodPairing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String value;

    @ManyToOne
    private Beer beer;

    public FoodPairing() {
    }

    public FoodPairing(String value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Beer getBeer() {
        return beer;
    }

    public void setBeer(Beer beer) {
        this.beer = beer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FoodPairing)) return false;
        FoodPairing that = (FoodPairing) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getValue(), that.getValue()) &&
                Objects.equals(getBeer(), that.getBeer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getValue(), getBeer());
    }

    @Override
    public String toString() {
        return "FoodPairing{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", beer=" + beer +
                '}';
    }
}
