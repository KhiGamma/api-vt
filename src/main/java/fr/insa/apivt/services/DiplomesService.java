package fr.insa.apivt.services;

import fr.insa.apivt.ressources.payload.ResponsableDiplomeDto;
import fr.insa.apivt.repositories.DiplomesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiplomesService {

    @Autowired
    public DiplomesRepository diplomesRepository;

    /**
     * Récupère les diplômes encadré par un enseignant en fonction de son codeProf.
     * @param codeProf code de l'enseignant responsable.
     * @return une ResponseEntity donc le corps est une liste de DTO
     * et un code HTTP indiquant le bon déroulement de l'opération
     */
    public ResponseEntity<List<ResponsableDiplomeDto>> getDiplomes(Integer codeProf) {
        return  new ResponseEntity<>(this.diplomesRepository.getDiplomes(codeProf), HttpStatus.OK);
    }
}
