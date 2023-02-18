package fr.insa.apivt.ressources.payload;

import java.sql.Date;

public interface SeancesProfDto {

    Integer getCodeSeance();

    Date getDateSeance();

    Integer getHeureSeance();

    String getNomEns();

    String getCommentaire();

    Integer getCodeProf();

    String getNomProf();

    String getCodeDiplome();

    String getNomDiplome();

    Integer getCodeResponsable();

    Integer getCodeGroupe();

    String getNomGroupe();

    String getNomSalle();
}
