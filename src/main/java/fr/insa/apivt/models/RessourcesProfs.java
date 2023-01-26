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
public class RessourcesProfs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codeprof;

    private String nom;
}
