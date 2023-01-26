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
public class SeancesTampon {

    @Id
    private Integer codeseance;

    private Date dateseance;

    private int heureseance;

    private int dureeseance;

    private int codeenseignement;

    @Column(columnDefinition = "timestamp")
    private Timestamp datemodif;

    @Column(columnDefinition = "datetime")
    private Timestamp datecreation;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean deleted;

    private int codeproprietaire;

    private String commentaire;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean bloquee;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean diffusable;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean annulee;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean controle;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean presentiel;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean sospresentiel;
}
