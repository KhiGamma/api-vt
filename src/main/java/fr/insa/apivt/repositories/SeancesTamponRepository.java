package fr.insa.apivt.repositories;

import fr.insa.apivt.models.SeancesTampon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeancesTamponRepository extends JpaRepository<SeancesTampon, Integer> {
}
