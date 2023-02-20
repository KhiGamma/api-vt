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
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeancesAValiderService {

    @Autowired
    public SeancesAValiderRepository seancesAValiderRepository;

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

    public void deleteSeancesAValider(Integer codeSeance) {
        this.seancesAValiderRepository.deleteById(codeSeance);
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
}
