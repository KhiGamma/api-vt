package fr.insa.apivt.services;

import fr.insa.apivt.models.Seances;
import fr.insa.apivt.models.SeancesAValider;
import fr.insa.apivt.ressources.dto.SeancesProfDto;
import fr.insa.apivt.repositories.SeancesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
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

    public ResponseEntity<List<SeancesProfDto>> getSeancesOfProf(Integer codeProf, Date dateAuPlusTot) {
        return new ResponseEntity<>(this.seancesRepository.getSeancesOfProf(codeProf, dateAuPlusTot), HttpStatus.OK);
    }

    public ResponseEntity updateSeanceFromSeancesTampon(Integer codeSeance, SeancesAValider seancesAValider) {
        return this.seancesRepository.findByCodeseance(codeSeance)
                .map(seances1 -> {
                    seances1.setCommentaire(seancesAValider.getCommentaire());
                    seances1.setDatemodif(new Timestamp(System.currentTimeMillis()));
                    return new ResponseEntity(this.seancesRepository.save(seances1), HttpStatus.ACCEPTED);
                })
                .orElseGet(() -> {
                    return new ResponseEntity(HttpStatus.NOT_FOUND);
                });
    }
}
