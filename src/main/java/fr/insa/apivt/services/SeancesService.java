package fr.insa.apivt.services;

import fr.insa.apivt.models.Seances;
import fr.insa.apivt.models.dto.SeancesProfDto;
import fr.insa.apivt.repositories.SeancesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeancesService {

    @Autowired
    public SeancesRepository seancesRepository;

    public ResponseEntity<Seances> getSeanceByCode(Integer codeSeance) {
        Optional<Seances> seances = this.seancesRepository.findByCodeseance(codeSeance);
        if (seances.isPresent()) {
            return new ResponseEntity<>(seances.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<Seances>> getAllSeances(Pageable pageable) {
        return new ResponseEntity<>(this.seancesRepository.getAllSeances(pageable), HttpStatus.OK);
    }

    public ResponseEntity<List<SeancesProfDto>> getSeancesOfProf(Integer codeProf) {
        return new ResponseEntity<>(this.seancesRepository.getSeancesOfProf(codeProf), HttpStatus.OK);
    }
}
