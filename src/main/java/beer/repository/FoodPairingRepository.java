package beer.repository;

import beer.domain.FoodPairing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodPairingRepository extends JpaRepository<FoodPairing, Long> {

}
