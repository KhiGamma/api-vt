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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("seances")
public class SeancesRessource {

    @Autowired
    public SeancesService seancesService;

    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE);

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
            @RequestParam(name = "dateAuPlusTot", required = false, defaultValue = "") String dateAuPlusTot) throws ParseException {
        if (!dateAuPlusTot.equals("")) {
            System.out.println(new java.sql.Date(formatter.parse(dateAuPlusTot).getTime()));

            return this.seancesService.getSeancesOfProf(codeProf, new java.sql.Date(formatter.parse(dateAuPlusTot).getTime()));
        } else{
            // TODO arranger les doublons avec des listes contenant les salles/profs/groupes ayant la même séance
            return this.seancesService.getSeancesOfProf(codeProf, new Date(System.currentTimeMillis()));
        }
    }

    @PutMapping("{codeSeance}")
    public ResponseEntity updateSeances(@PathVariable("codeSeance") Integer codeSeance, @RequestBody SeancesAValider seancesAValider) {
        return this.seancesService.updateSeanceFromSeancesTampon(codeSeance, seancesAValider);
    }
}
