package fr.insa.apivt.ressources.payload;

import java.sql.Date;

public interface ReservationsProfDto {

    String getCommentaire();

    Date getDateReservation();

    String getNom();

    Integer getCodeProf();
}
