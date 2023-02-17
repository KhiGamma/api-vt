package fr.insa.apivt.models;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "seances_a_valider")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SeancesAValider {

    @Id
    private Integer codeseance;

    private Integer codeprof;

    private Integer coderesponsable;

    private Integer codediplome;

    private String nomprof;

    private String nomens;

    private Date dateseance;

    private int heureseance;

    @Column(columnDefinition = "timestamp")
    private Timestamp datemodif;

    private String commentaire;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean controle;
}
