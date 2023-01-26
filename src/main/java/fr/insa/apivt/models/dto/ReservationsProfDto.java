package fr.insa.apivt.models.dto;

import java.sql.Date;

public interface ReservationsProfDto {

    String getCommentaire();

    Date getDateReservation();

    String getNom();

    Integer getCodeProf();
}
