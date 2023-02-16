package fr.insa.apivt.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Diplomes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codediplome;

    String nom;
}
