package fr.insa.apivt.ressources;

import fr.insa.apivt.models.SeancesAValider;
import fr.insa.apivt.ressources.payload.SeancesAValiderCreateModel;
import fr.insa.apivt.services.SeancesAValiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("seances-a-valider")
public class SeancesAValiderRessource {

    @Autowired
    public SeancesAValiderService seancesAValiderService;

    @PostMapping("{codeProf}")
    public SeancesAValider createSeancesAValider(@RequestBody SeancesAValiderCreateModel seancesAValiderToCreate, @PathVariable("codeProf") Integer codeProf) {
        return this.seancesAValiderService.saveSeancesAValider(seancesAValiderToCreate, codeProf);
    }

    @PutMapping("/{codeSeance}")
    public ResponseEntity updateSeancesAValider(@PathVariable("codeSeance") Integer codeSeance,
            @RequestParam(name = "etat") Integer etat) {
        return this.seancesAValiderService.updateSeancesAValider(codeSeance, etat);
    }

    @GetMapping("/responsables")
    public ResponseEntity getSeancesAValiderForResponsable(
            @RequestParam(name = "code-responsable") Integer codeResponsable,
            @RequestParam(name = "code-diplome") Integer codeDiplome) {
        return this.seancesAValiderService.getSeancesAValiderForResponsable(codeResponsable, codeDiplome);
    }

    @GetMapping("/profs")
    public ResponseEntity getSeancesAValiderOfProf(
            @RequestParam(name = "code-prof") Integer codeProf) {
        return this.seancesAValiderService.getSeancesAValiderOfProf(codeProf);
    }
}
