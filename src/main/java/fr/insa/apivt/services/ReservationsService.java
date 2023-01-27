package fr.insa.apivt.services;

import fr.insa.apivt.models.dto.ReservationsProfDto;
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

    public ResponseEntity<List<ReservationsProfDto>> getReservationsOfProf(Integer codeProf) {
        return new ResponseEntity<>(this.reservationsRepository.getReservationsOfProf(codeProf), HttpStatus.OK);
    }
}
