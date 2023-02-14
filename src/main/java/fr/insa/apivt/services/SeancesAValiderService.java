package fr.insa.apivt.services;

import fr.insa.apivt.models.SeancesAValider;
import fr.insa.apivt.repositories.SeancesAValiderRepository;
import fr.insa.apivt.ressources.payload.SeancesAValiderCreateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class SeancesAValiderService {

    @Autowired
    public SeancesAValiderRepository seancesAValiderRepository;

    public SeancesAValider saveSeancesAValider(SeancesAValiderCreateModel seancesAValiderToCreate, Integer codeProf) {

        SeancesAValider st = SeancesAValider.builder()
                .codeseance(seancesAValiderToCreate.getCodeseance())
                .codeprof(codeProf)
                .dateseance(seancesAValiderToCreate.getDateseance())
                .heureseance(seancesAValiderToCreate.getHeureseance())
                .datemodif(new Timestamp(System.currentTimeMillis()))
                .commentaire(seancesAValiderToCreate.getCommentaire())
                .build();

        return this.seancesAValiderRepository.save(st);
    }

    public void deleteSeancesAValider(Integer codeSeance) {
        this.seancesAValiderRepository.deleteById(codeSeance);
    }
}
