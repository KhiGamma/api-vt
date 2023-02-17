package fr.insa.apivt.ressources.payload;

import fr.insa.apivt.models.SeancesAValider;
import lombok.*;

import java.sql.Date;
import java.sql.Timestamp;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SeancesAValiderResponse {

    private Integer codeSeance;

    private Integer codeProf;

    private Integer codeResponsable;

    private Integer codeDiplome;

    private String nomProf;

    private String nomEns;

    private Date dateSeance;

    private int heureSeance;

    private Timestamp dateModif;

    private String commentaire;

    private boolean controle;

    public SeancesAValiderResponse(SeancesAValider seancesAValider) {
        this.codeSeance = seancesAValider.getCodeseance();
        this.codeProf = seancesAValider.getCodeprof();
        this.codeResponsable = seancesAValider.getCoderesponsable();
        this.codeDiplome = seancesAValider.getCodediplome();
        this.nomProf = seancesAValider.getNomprof();
        this.nomEns = seancesAValider.getNomens();
        this.dateSeance = seancesAValider.getDateseance();
        this.heureSeance = seancesAValider.getHeureseance();
        this.dateModif = seancesAValider.getDatemodif();
        this.commentaire = seancesAValider.getCommentaire();
        this.controle = seancesAValider.isControle();
    }
}
