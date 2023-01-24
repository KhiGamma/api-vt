package fr.insa.apivt.repositories;

import fr.insa.apivt.models.Reservations;
import fr.insa.apivt.models.dto.ReservationsProfDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationsRepository extends JpaRepository<Reservations, Integer> {

    @Query(value = "SELECT r.commentaire, r.datereservation, rsp.nom, rsp.codeprof " +
            "FROM Reservations r, ressources_profs as rsp, reservations_profs as rp " +
            "WHERE rsp.codeprof = :codeProf " +
            "AND rp.coderessource = rsp.codeprof " +
            "AND rp.codereservation = r.codereservation ", nativeQuery = true)
    List<ReservationsProfDto> getReservationsOfProf(@Param("codeProf") Integer codeProf);
}
