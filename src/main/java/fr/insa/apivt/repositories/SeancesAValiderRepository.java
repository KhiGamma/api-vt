package fr.insa.apivt.repositories;

import fr.insa.apivt.models.SeancesAValider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeancesAValiderRepository extends JpaRepository<SeancesAValider, Integer> {
}
