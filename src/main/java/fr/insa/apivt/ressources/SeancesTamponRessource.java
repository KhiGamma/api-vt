package fr.insa.apivt.ressources;

import fr.insa.apivt.models.SeancesTampon;
import fr.insa.apivt.ressources.payload.SeancesTamponCreateModel;
import fr.insa.apivt.services.SeancesTamponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("seancesTampon")
public class SeancesTamponRessource {

    @Autowired
    public SeancesTamponService seancesTamponService;

    @PostMapping
    public SeancesTampon createSeancesTampon(@RequestBody SeancesTamponCreateModel seancesTamponToCreate) {
        return this.seancesTamponService.saveSeancesTampon(seancesTamponToCreate);
    }
}
