package fr.insa.apivt.ressources;

import fr.insa.apivt.models.dto.ReservationsProfDto;
import fr.insa.apivt.services.ReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("reservations")
public class ReservationsRessource {

    @Autowired
    public ReservationsService reservationsService;

    @GetMapping("/profs/{codeProf}")
    public ResponseEntity<List<ReservationsProfDto>> getReservationsOfProf(@PathVariable("codeProf") Integer codeProf) {
        return this.reservationsService.getReservationsOfProf(codeProf);
    }
}
