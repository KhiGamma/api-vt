package fr.insa.apivt.ressources.payload;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.sql.Date;
import java.sql.Timestamp;

@Getter
@Setter
public class SeancesAValiderCreateModel {

    private Integer codeSeance;

    private Integer codeResponsable;

    private Integer codeDiplome;

    private String nomProf;

    private String nomEns;

    private Date dateSeance;

    private int heureSeance;

    private String commentaire;
}
