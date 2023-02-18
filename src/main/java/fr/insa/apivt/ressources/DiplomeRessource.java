package fr.insa.apivt.ressources;

import fr.insa.apivt.ressources.dto.ResponsableDiplomeDto;
import fr.insa.apivt.services.DiplomesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("diplomes")
public class DiplomeRessource {

    @Autowired
    public DiplomesService diplomesService;

    @GetMapping("/responsables/{codeProf}")
    public ResponseEntity<List<ResponsableDiplomeDto>> getDiplomes(@PathVariable("codeProf") Integer codeProf) {
        return this.diplomesService.getDiplomes(codeProf);
    }
}
