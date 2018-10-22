package beer.repository;

import beer.domain.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeerRepository extends JpaRepository<Beer, Long> {

    @Query("SELECT id FROM Beer b WHERE b.punkApiId = :punkApiId")
    Long findBeerIdByPunkApiId(@Param("punkApiId") Long punkApiId);

    @Query("SELECT b FROM Beer b " +
            "JOIN b.foodPairings fp " +
            "WHERE LOWER(fp.value) LIKE %:phrase%")
    List<Beer> findByFoodPairing(@Param("phrase") String phrase);
}
