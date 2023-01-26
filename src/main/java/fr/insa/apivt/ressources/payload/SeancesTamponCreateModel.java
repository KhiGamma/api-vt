package fr.insa.apivt.ressources.payload;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
public class SeancesTamponCreateModel {

    private Integer codeseance;

    private Date dateseance;

    private int heureseance;

    private int dureeseance;

    private int codeenseignement;

    private Timestamp datemodif;

    private Timestamp datecreation;

    private boolean deleted;

    private int codeproprietaire;

    private String commentaire;

    private boolean bloquee;

    private boolean diffusable;

    private boolean annulee;

    private boolean controle;

    private boolean presentiel;

    private boolean sospresentiel;
}
