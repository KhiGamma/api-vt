package fr.insa.apivt.repositories;

import fr.insa.apivt.models.Seances;
import fr.insa.apivt.models.dto.SeancesProfDto;
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

    @Query("SELECT s " +
            "FROM Seances s " +
            "ORDER BY s.codeseance DESC")
    List<Seances> getAllSeances(Pageable pageable);

    @Query(value = "SELECT s.commentaire, s.dateseance, rsp.nom, rsp.codeprof " +
            "FROM Seances s, ressources_profs as rsp, seances_profs as sp " +
            "WHERE rsp.codeprof = :codeProf " +
            "AND sp.coderessource = rsp.codeprof " +
            "AND sp.codeseance = s.codeseance ", nativeQuery = true)
    List<SeancesProfDto> getSeancesOfProf(@Param("codeProf") Integer codeProf);
}
