package fr.insa.apivt.services;

import fr.insa.apivt.models.SeancesTampon;
import fr.insa.apivt.repositories.SeancesTamponRepository;
import fr.insa.apivt.ressources.payload.SeancesTamponCreateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeancesTamponService {

    @Autowired
    public SeancesTamponRepository seancesTamponRepository;

    public SeancesTampon saveSeancesTampon(SeancesTamponCreateModel seancesTamponToCreate) {

        SeancesTampon st = SeancesTampon.builder()
                .codeseance(seancesTamponToCreate.getCodeseance())
                .dateseance(seancesTamponToCreate.getDateseance())
                .heureseance(seancesTamponToCreate.getHeureseance())
                .dureeseance(seancesTamponToCreate.getDureeseance())
                .codeenseignement(seancesTamponToCreate.getCodeenseignement())
                .datemodif(seancesTamponToCreate.getDatemodif())
                .datecreation(seancesTamponToCreate.getDatecreation())
                .deleted(seancesTamponToCreate.isDeleted())
                .codeproprietaire(seancesTamponToCreate.getCodeproprietaire())
                .commentaire(seancesTamponToCreate.getCommentaire())
                .bloquee(seancesTamponToCreate.isBloquee())
                .diffusable(seancesTamponToCreate.isDiffusable())
                .annulee(seancesTamponToCreate.isAnnulee())
                .controle(seancesTamponToCreate.isControle())
                .presentiel(seancesTamponToCreate.isPresentiel())
                .sospresentiel(seancesTamponToCreate.isSospresentiel())
                .build();

        return this.seancesTamponRepository.save(st);
    }

}
