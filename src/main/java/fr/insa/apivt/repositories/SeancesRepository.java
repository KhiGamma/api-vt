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

    @Query(value = "SELECT s.codeSeance, s.dateSeance, s.heureSeance, ens.nom nomEns, s.commentaire, rsp.codeProf, rsp.nom nomProf, dip.nom nomDiplome, dip.codeResponsable, rsg.codeGroupe, rsg.nom nomGroupe, rss.nom nomSalle " +
            "FROM seances as s, seances_profs as sp, ressources_profs as rsp, enseignements as ens, diplomes as dip, seances_groupes as sg, ressources_groupes as rsg, seances_salles as ss, ressources_salles as rss " +
            "WHERE rsp.codeprof = :codeProf " +
            "and sp.codeRessource = rsp.codeProf " +
            "and sp.codeSeance = s.codeSeance " +
            "and s.codeEnseignement = ens.codeEnseignement " +
            "and dip.codeDiplome = ens.codeDiplome " +
            "and sg.codeSeance = s.codeSeance " +
            "and sg.codeRessource = rsg.codeGroupe " +
            "and ss.codeSeance = s.codeseance " +
            "and ss.codeRessource = rss.codeSalle " +
            "and s.deleted = 0 " +
            "and sp.deleted = 0 " +
            "and sg.deleted = 0 " +
            "and ss.deleted = 0 ", nativeQuery = true)
    List<SeancesProfDto> getSeancesOfProf(@Param("codeProf") Integer codeProf);
}
