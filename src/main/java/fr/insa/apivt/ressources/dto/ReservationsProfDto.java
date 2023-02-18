package fr.insa.apivt.ressources.dto;

import java.sql.Date;

public interface ReservationsProfDto {

    String getCommentaire();

    Date getDateReservation();

    String getNom();

    Integer getCodeProf();
}
