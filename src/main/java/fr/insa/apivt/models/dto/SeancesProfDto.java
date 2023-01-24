package fr.insa.apivt.models.dto;

import java.sql.Date;

public interface SeancesProfDto {

    String getCommentaire();

    Date getDateSeance();

    String getNom();

    Integer getCodeProf();

}
