package fr.insa.apivt.ressources.payload;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
public class SeancesAValiderCreateModel {

    private Integer codeseance;

    private Integer codeResponsable;

    private Integer codeDiplome;

    private Date dateseance;

    private int heureseance;

    private String commentaire;

    private boolean controle;
}
