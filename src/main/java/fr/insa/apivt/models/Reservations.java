package fr.insa.apivt.models;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Reservations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codereservation;

    private String commentaire;

    private Date datereservation;

    private int heureseance;

    private int dureeseance;

    @Column(columnDefinition = "timestamp")
    private Timestamp datemodif;

    @Column(columnDefinition = "datetime")
    private Timestamp datecreation;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean deleted;

    private int codeproprietaire;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean bloquee;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean diffusable;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean indisponibilite;

    private String idical;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean presentiel;
}
