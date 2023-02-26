package fr.insa.apivt.services;

import fr.insa.apivt.models.SeancesAValider;
import fr.insa.apivt.repositories.SeancesAValiderRepository;
import fr.insa.apivt.ressources.payload.SeancesAValiderCreateModel;
import fr.insa.apivt.ressources.payload.SeancesAValiderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SeancesAValiderService {

    @Autowired
    public SeancesAValiderRepository seancesAValiderRepository;

    enum Etat {
        EN_ATTENTE(0),
        ACCEPTEE(1),
        REFUSEE(2);

        Integer label;

        Etat (Integer label) {
            this.label = label;
        }
    }

    /**
     * Ajoute une séance à valider à la base de données.
     * @param seancesAValiderToCreate objet contenant les informations sur l'élément à ajouter.
     * @param codeProf code de l'enseignant à l'origine de la demande.
     * @return la SeanceAValider qui à été créée.
     */
    public SeancesAValider saveSeancesAValider(SeancesAValiderCreateModel seancesAValiderToCreate, Integer codeProf) {

        SeancesAValider st = SeancesAValider.builder()
                .codeseance(seancesAValiderToCreate.getCodeSeance())
                .codeprof(codeProf)
                .nomprof(seancesAValiderToCreate.getNomProf())
                .nomens(seancesAValiderToCreate.getNomEns())
                .coderesponsable(seancesAValiderToCreate.getCodeResponsable())
                .codediplome(seancesAValiderToCreate.getCodeDiplome())
                .dateseance(seancesAValiderToCreate.getDateSeance())
                .heureseance(seancesAValiderToCreate.getHeureSeance())
                .datemodif(new Timestamp(System.currentTimeMillis()))
                .commentaire(seancesAValiderToCreate.getCommentaire())
                .etat(0)
                .build();

        return this.seancesAValiderRepository.save(st);
    }

    /**
     * Met à jour une séance à valider en modifiant l'état de la séance.
     * @param codeSeance code de la séance à modifier.
     * @param etat nouvel état de la séance.
     * @return une ResponseEntity donc le corps est la séance à valider modifiée
     * et un code HTTP indiquant le bon déroulement de l'opération
     */
    public ResponseEntity updateSeancesAValider(Integer codeSeance, Integer etat) {

        if (etat.equals(Etat.EN_ATTENTE.label) || !etatValide(etat)) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        Optional<SeancesAValider> seancesAValider = this.seancesAValiderRepository.getSeancesAValiderByCodeseance(codeSeance);

        if (seancesAValider.isPresent()) {
            seancesAValider.get().setEtat(etat);
            this.seancesAValiderRepository.save(seancesAValider.get());

            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Récupère la liste des séances à valider d'une filière encadré par un responsable.
     * @param codeResponsable code du responsable.
     * @param codeDiplome code de la filière.
     * @return une ResponseEntity donc le corps est la liste des séances à valider
     * et un code HTTP indiquant le bon déroulement de l'opération
     */
    public ResponseEntity getSeancesAValiderForResponsable(Integer codeResponsable, Integer codeDiplome) {
        List<SeancesAValider> seancesAValider = this.seancesAValiderRepository.getSeancesAValiderForResponsable(codeResponsable, codeDiplome);

        return new ResponseEntity(this.convertToListOfResponse(seancesAValider), HttpStatus.OK);
    }

    /**
     * Récupère la liste des demandes de modifications d'un enseignant.
     * @param codeProf code de l'enseignant à l'origine des demandes.
     * @return une ResponseEntity donc le corps est la liste des séances à valider de l'enseignant
     * et un code HTTP indiquant le bon déroulement de l'opération
     */
    public ResponseEntity getSeancesAValiderOfProf(Integer codeProf) {
        List<SeancesAValider> seancesAValider = this.seancesAValiderRepository.getSeancesAValiderOfProf(codeProf);

        return new ResponseEntity(this.convertToListOfResponse(seancesAValider), HttpStatus.OK);
    }

    /**
     * Converti une liste de SeancesAValider en liste de SeancesAValiderResponse.
     * Permet de filtrer les informations renvoyer à l'éxterieure de l'API.
     * @param seancesAValiders liste des séances à convertir.
     * @return la liste des séances converties.
     */
    private List<SeancesAValiderResponse> convertToListOfResponse(List<SeancesAValider> seancesAValiders) {
        return seancesAValiders.stream().map(SeancesAValiderResponse::new).collect(Collectors.toList());
    }

    /**
     * Indique si l'état correspond à un état valide de l'enum Etat.
     * @param etat état à verifier.
     * @return vrai l'état est bien une valeur correcte.
     * @see Etat
     */
    private boolean etatValide(Integer etat) {
        return Arrays.stream(Etat.values()).anyMatch(value -> value.label.equals(etat));
    }
}
