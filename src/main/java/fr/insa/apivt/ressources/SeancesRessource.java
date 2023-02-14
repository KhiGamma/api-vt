package fr.insa.apivt.ressources;

import fr.insa.apivt.models.Seances;
import fr.insa.apivt.models.SeancesAValider;
import fr.insa.apivt.models.dto.SeancesProfDto;
import fr.insa.apivt.services.SeancesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("seances")
public class SeancesRessource {

    @Autowired
    public SeancesService seancesService;

    @GetMapping("{codeSeance}")
    public ResponseEntity<Seances> getSeanceByCode(@PathVariable("codeSeance") Integer codeSeance) {
        return this.seancesService.getSeanceByCode(codeSeance);
    }

    @GetMapping()
    public ResponseEntity<List<Seances>> getAllSeances() {
        return this.seancesService.getAllSeances(Pageable.ofSize(50));
    }

    @GetMapping("/profs/{codeProf}")
    public ResponseEntity<List<SeancesProfDto>> getSeancesOfProf(
            @PathVariable("codeProf") Integer codeProf,
            @RequestParam(
                name = "codeMatiere",
                required = false,
                defaultValue = "0") Integer codeMatiere,
            @RequestParam(
                name = "codeFiliaire",
                required = false,
                defaultValue = "0") Integer codeFiliaire) {
        if ((codeMatiere != 0) && (codeFiliaire != 0)) {
            // TODO recherche par code Filière et code matière
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else{
            // TODO arranger les doublons avec des listes contenant les salles/profs/groupes ayant la même séance
            return this.seancesService.getSeancesOfProf(codeProf);
        }
    }

    @PutMapping("{codeSeance}")
    public ResponseEntity updateSeances(@PathVariable("codeSeance") Integer codeSeance, @RequestBody SeancesAValider seancesAValider) {
        return this.seancesService.updateSeanceFromSeancesTampon(codeSeance, seancesAValider);
    }
}
