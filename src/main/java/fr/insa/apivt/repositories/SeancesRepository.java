package fr.insa.apivt.repositories;

import fr.insa.apivt.models.Seances;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeancesRepository extends JpaRepository<Seances, Integer> {
    public Optional<Seances> findByCodeseance(Integer codeSeance);

    @Query("SELECT s FROM Seances s ORDER BY s.codeseance DESC")
    List<Seances> getAllSeances(Pageable pageable);

    @Query("select *\n" +
            "from seances, seances_profs, ressources_profs\n" +
            "where r.nom = '?1'")
    List<Seances> findByCodeprofJPQL(Integer codeProf);
}
