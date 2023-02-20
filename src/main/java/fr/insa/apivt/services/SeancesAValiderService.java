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
                .build();

        return this.seancesAValiderRepository.save(st);
    }

    public void deleteSeancesAValider(Integer codeSeance) {
        this.seancesAValiderRepository.deleteById(codeSeance);
    }

    public ResponseEntity getSeancesAValiderForResponsable(Integer codeResponsable, Integer codeDiplome) {
        List<SeancesAValider> seancesAValider = this.seancesAValiderRepository.getSeancesAValiderForResponsable(codeResponsable, codeDiplome);

        List<SeancesAValiderResponse> seancesAValiderResponse = seancesAValider.stream().map(SeancesAValiderResponse::new).collect(Collectors.toList());

        return new ResponseEntity(seancesAValiderResponse, HttpStatus.OK);
    }


}
