package Tabulky;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@javax.persistence.Table(name = "B_OBJEDNAVKA", schema = "STACHERA")
public class BObjednavka {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "b_objednavka_cislo_obj")
    @SequenceGenerator(name = "b_objednavka_cislo_obj", sequenceName = "b_objednavka_cislo_obj", allocationSize = 1)
    @javax.persistence.Column(name = "CISLO_OBJEDNAVKY", nullable = false, precision = 0)
    private BigInteger cisloObjednavky;

    public BigInteger getCisloObjednavky() {
        return cisloObjednavky;
    }

    public void setCisloObjednavky(BigInteger cisloObjednavky) {
        this.cisloObjednavky = cisloObjednavky;
    }

    @Basic
    @Column(name = "DATUM_OBJEDNAVKY", nullable = false)
    private String datumObjednavky;

    public String getDatumObjednavky() {
        return datumObjednavky;
    }

    public void setDatumObjednavky(String datumObjednavky) {
        this.datumObjednavky = datumObjednavky;
    }

    @Basic
    @Column(name = "DATUM_DORUCENIA", nullable = true)
    private String datumDorucenia;

    public String getDatumDorucenia() {
        return datumDorucenia;
    }

    public void setDatumDorucenia(String datumDorucenia) {
        this.datumDorucenia = datumDorucenia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BObjednavka that = (BObjednavka) o;

        if (cisloObjednavky != null ? !cisloObjednavky.equals(that.cisloObjednavky) : that.cisloObjednavky != null)
            return false;
        if (datumObjednavky != null ? !datumObjednavky.equals(that.datumObjednavky) : that.datumObjednavky != null)
            return false;
        if (datumDorucenia != null ? !datumDorucenia.equals(that.datumDorucenia) : that.datumDorucenia != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cisloObjednavky != null ? cisloObjednavky.hashCode() : 0;
        result = 31 * result + (datumObjednavky != null ? datumObjednavky.hashCode() : 0);
        result = 31 * result + (datumDorucenia != null ? datumDorucenia.hashCode() : 0);
        return result;
    }
}
