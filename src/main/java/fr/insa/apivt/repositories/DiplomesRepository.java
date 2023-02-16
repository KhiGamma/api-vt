package fr.insa.apivt.repositories;

import fr.insa.apivt.models.Diplomes;
import fr.insa.apivt.models.dto.ResponsableDiplomeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiplomesRepository extends JpaRepository<Diplomes, Integer> {

    @Query(value = "SELECT d.nom nomDiplome, d.codeDiplome, d.alias " +
            "FROM ressources_profs AS rsp, diplomes as d " +
            "WHERE rsp.codeProf = :codeProf " +
            "AND d.codeResponsable = rsp.codeProf ", nativeQuery = true)
    List<ResponsableDiplomeDto> getDiplomes(@Param("codeProf") Integer codeProf);
}
