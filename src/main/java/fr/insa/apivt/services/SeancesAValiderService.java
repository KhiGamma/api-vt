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

    public ResponseEntity getSeancesAValiderForResponsable(Integer codeResponsable, Integer codeDiplome) {
        List<SeancesAValider> seancesAValider = this.seancesAValiderRepository.getSeancesAValiderForResponsable(codeResponsable, codeDiplome);

        return new ResponseEntity(this.convertToListOfResponse(seancesAValider), HttpStatus.OK);
    }

    public ResponseEntity getSeancesAValiderOfProf(Integer codeProf) {
        List<SeancesAValider> seancesAValider = this.seancesAValiderRepository.getSeancesAValiderOfProf(codeProf);

        return new ResponseEntity(this.convertToListOfResponse(seancesAValider), HttpStatus.OK);
    }

    private List<SeancesAValiderResponse> convertToListOfResponse(List<SeancesAValider> seancesAValiders) {
        return seancesAValiders.stream().map(SeancesAValiderResponse::new).collect(Collectors.toList());
    }

    private boolean etatValide(Integer etat) {
        return Arrays.stream(Etat.values()).anyMatch(value -> value.label.equals(etat));
    }
}
