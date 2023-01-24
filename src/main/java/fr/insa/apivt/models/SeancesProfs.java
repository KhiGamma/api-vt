package fr.insa.apivt.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SeancesProfs {

    @EmbeddedId
    SeancesProfsKey id;

    @ManyToOne
    @MapsId("codeseance")
    @JoinColumn(name = "codeSeance")
    private Seances seance;

    @ManyToOne
    @MapsId("coderessource")
    @JoinColumn(name = "codeRessource")
    private RessourcesProfs ressourcesProf;
}
