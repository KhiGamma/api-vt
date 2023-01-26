package fr.insa.apivt.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SeancesProfsKey implements Serializable {

    @Column(name = "codeSeance")
    private int codeseance;

    @Column(name = "codeRessource")
    private int coderessource;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeancesProfsKey that = (SeancesProfsKey) o;
        return codeseance == that.codeseance && coderessource == that.coderessource;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeseance, coderessource);
    }
}
