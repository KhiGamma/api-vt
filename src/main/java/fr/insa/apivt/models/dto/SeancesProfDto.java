package fr.insa.apivt.models.dto;

import java.sql.Date;

public interface SeancesProfDto {

    Integer getCodeSeance();

    Date getDateSeance();

    Integer getHeureSeance();

    String getNomEns();

    String getCommentaire();

    Integer getCodeProf();

    String getNomProf();

    String getNomDiplome();

    Integer getCodeResponsable();

    Integer getCodeGroupe();

    String getNomGroupe();

    String getNomSalle();
}
