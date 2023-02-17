package fr.insa.apivt.repositories;

import fr.insa.apivt.models.SeancesAValider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SeancesAValiderRepository extends JpaRepository<SeancesAValider, Integer> {

    @Query("SELECT s " +
            "FROM SeancesAValider s " +
            "WHERE s.coderesponsable = :codeResponsable " +
            "AND s.codediplome = :codeDiplome " +
            "ORDER BY s.dateseance ASC ")
    List<SeancesAValider> getSeancesAValider(Integer codeResponsable, Integer codeDiplome);
}
