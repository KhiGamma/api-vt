package fr.insa.apivt.services;

import fr.insa.apivt.models.Seances;
import fr.insa.apivt.models.SeancesAValider;
import fr.insa.apivt.ressources.payload.SeancesProfDto;
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

    /**
     * Récupère une séance par son codeSeance.
     * Utilisée pour les testes.
     * @param codeSeance code de la séance à récupérer.
     * @return une ResponseEntity donc le corps est le tuple de la séance
     * et un code HTTP indiquant le bon déroulement de l'opération
     */
    public ResponseEntity<Seances> getSeanceByCode(Integer codeSeance) {
        Optional<Seances> seances = this.seancesRepository.findByCodeseance(codeSeance);
        if (seances.isPresent()) {
            return new ResponseEntity<>(seances.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Récupère un certain nombre de séances parmis toutes les séances de la base de données.
     * Les séances seront segmentées sous forme de page.
     * @param pageable objet indiquant le nombre d'éléments par page ainsi que la page actuelle.
     * @return une ResponseEntity donc le corps est la liste des tuples des séances
     * et un code HTTP indiquant le bon déroulement de l'opération
     */
    public ResponseEntity<List<Seances>> getAllSeances(Pageable pageable) {
        return new ResponseEntity<>(this.seancesRepository.getAllSeances(pageable), HttpStatus.OK);
    }

    /**
     * Récupère la liste des DTO des séances ainsi que d'autres informations relatives à un enseignant à partir d'une date.
     * @param codeProf code de l'enseignant dont on souhaite récupérer l'emploi du temps.
     * @param dateAuPlusTot date des séances au plus tôt.
     * @return une ResponseEntity donc le corps est la liste des DTO des séances
     * et un code HTTP indiquant le bon déroulement de l'opération
     */
    public ResponseEntity<List<SeancesProfDto>> getSeancesOfProf(Integer codeProf, Date dateAuPlusTot) {
        return new ResponseEntity<>(this.seancesRepository.getSeancesOfProf(codeProf, dateAuPlusTot), HttpStatus.OK);
    }

    /**
     * Met à jour une séance avec les informations de la demande de modification.
     * @param codeSeance code de la séance à modifier.
     * @param seancesAValider objet contenant les informations sur la séance à modifier.
     * @return une ResponseEntity donc le corps est la nouvelle séance modifiée
     * et un code HTTP indiquant le bon déroulement de l'opération
     */
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
