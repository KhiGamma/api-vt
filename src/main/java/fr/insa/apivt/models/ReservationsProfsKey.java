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
public class ReservationsProfsKey implements Serializable {

    @Column(name = "codeReservation")
    private int codereservation;

    @Column(name = "codeRessource")
    private int coderessource;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationsProfsKey that = (ReservationsProfsKey) o;
        return codereservation == that.codereservation && coderessource == that.coderessource;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codereservation, coderessource);
    }
}
