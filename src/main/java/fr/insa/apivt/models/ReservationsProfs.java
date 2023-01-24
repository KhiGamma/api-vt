package fr.insa.apivt.models;

import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

public class ReservationsProfs {

    @EmbeddedId
    ReservationsProfsKey id;

    @ManyToOne
    @MapsId("codereservation")
    @JoinColumn(name = "codeReservation")
    private Reservations reservations;

    @ManyToOne
    @MapsId("coderessource")
    @JoinColumn(name = "codeRessource")
    private RessourcesProfs ressourcesProf;
}
