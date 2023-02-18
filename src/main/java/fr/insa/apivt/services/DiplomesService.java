package fr.insa.apivt.services;

import fr.insa.apivt.ressources.dto.ResponsableDiplomeDto;
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

    public ResponseEntity<List<ResponsableDiplomeDto>> getDiplomes(Integer codeProf) {
        return  new ResponseEntity<>(this.diplomesRepository.getDiplomes(codeProf), HttpStatus.OK);
    }
}
