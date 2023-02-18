package fr.insa.apivt.repositories;

import fr.insa.apivt.models.Seances;
import fr.insa.apivt.ressources.dto.SeancesProfDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface SeancesRepository extends JpaRepository<Seances, Integer> {
    public Optional<Seances> findByCodeseance(Integer codeSeance);

    @Query("SELECT s " +
            "FROM Seances s " +
            "ORDER BY s.codeseance DESC")
    List<Seances> getAllSeances(Pageable pageable);

    @Query(value = "SELECT s.codeSeance, s.dateSeance, s.heureSeance, ens.nom nomEns, s.commentaire, rsp.codeProf, rsp.nom nomProf, dip.codeDiplome, dip.nom nomDiplome, dip.codeResponsable, rsg.codeGroupe, rsg.nom nomGroupe, rss.nom nomSalle " +
            "FROM seances as s, seances_profs AS sp, ressources_profs AS rsp, enseignements AS ens, diplomes AS dip, seances_groupes AS sg, ressources_groupes AS rsg, seances_salles AS ss, ressources_salles AS rss " +
            "WHERE rsp.codeprof = :codeProf " +
            "AND s.dateSeance >= :dateAuPlusTot " +
            "AND sp.codeRessource = rsp.codeProf " +
            "AND sp.codeSeance = s.codeSeance " +
            "AND s.codeEnseignement = ens.codeEnseignement " +
            "AND dip.codeDiplome = ens.codeDiplome " +
            "AND sg.codeSeance = s.codeSeance " +
            "AND sg.codeRessource = rsg.codeGroupe " +
            "AND ss.codeSeance = s.codeseance " +
            "AND ss.codeRessource = rss.codeSalle " +
            "AND s.deleted = 0 " +
            "AND sp.deleted = 0 " +
            "AND sg.deleted = 0 " +
            "AND ss.deleted = 0 " +
            "ORDER BY s.dateSeance ASC ", nativeQuery = true)
    List<SeancesProfDto> getSeancesOfProf(@Param("codeProf") Integer codeProf, @Param("dateAuPlusTot") Date dateAuPlusTot);
}
