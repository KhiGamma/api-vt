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

    @DeleteMapping("{codeSeance}")
    public ResponseEntity deleteSeancesAValider(@PathVariable("codeSeance") Integer codeSeance) {
        this.seancesAValiderService.deleteSeancesAValider(codeSeance);
        return ResponseEntity.ok().build();
    }

    @GetMapping()
    public ResponseEntity getSeancesAValiderForresponsable(
            @RequestParam(name = "code-responsable") Integer codeResponsable,
            @RequestParam(name = "code-diplome") Integer codeDiplome) {
        System.out.println(codeResponsable + " " + codeDiplome);
        return this.seancesAValiderService.getSeancesAValiderForResponsable(codeResponsable, codeDiplome);
    }
}
