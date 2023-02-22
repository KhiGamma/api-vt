package fr.insa.apivt.repositories;

import fr.insa.apivt.models.SeancesAValider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SeancesAValiderRepository extends JpaRepository<SeancesAValider, Integer> {

    @Query("SELECT s " +
            "FROM SeancesAValider s " +
            "WHERE s.coderesponsable = :codeResponsable " +
            "AND s.codediplome = :codeDiplome " +
            "AND s.etat = 0 " +
            "ORDER BY s.dateseance ASC ")
    List<SeancesAValider> getSeancesAValiderForResponsable(Integer codeResponsable, Integer codeDiplome);

    @Query( "SELECT s " +
            "FROM SeancesAValider s " +
            "WHERE s.codeprof = :codeProf " +
            "AND s.etat = 0 " +
            "ORDER BY s.dateseance ASC ")
    List<SeancesAValider> getSeancesAValiderOfProf(Integer codeProf);

    Optional<SeancesAValider> getSeancesAValiderByCodeseance(Integer codeSeance);
}
