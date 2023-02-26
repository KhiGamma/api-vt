package fr.insa.apivt.services;

import fr.insa.apivt.ressources.payload.ReservationsProfDto;
import fr.insa.apivt.repositories.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationsService {

    @Autowired
    private ReservationsRepository reservationsRepository;

    /**
     * Récupère la liste des DTO des réservations ainsi que d'autres informations relatives à un enseignant.
     * @param codeProf code de l'enseignant dont on souhaite récupérer les réservations.
     * @return une ResponseEntity donc le corps est la liste des DTO des réservations
     * et un code HTTP indiquant le bon déroulement de l'opération
     */
    public ResponseEntity<List<ReservationsProfDto>> getReservationsOfProf(Integer codeProf) {
        return new ResponseEntity<>(this.reservationsRepository.getReservationsOfProf(codeProf), HttpStatus.OK);
    }
}
