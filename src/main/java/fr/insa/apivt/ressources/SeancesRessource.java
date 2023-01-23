package fr.insa.apivt.ressources;

import fr.insa.apivt.models.Seances;
import fr.insa.apivt.services.SeancesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
