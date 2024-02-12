package Tabulky;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@javax.persistence.Table(name = "B_POLOZKA_OBJEDNAVKY", schema = "STACHERA", catalog = "")
@IdClass(Tabulky.BPolozkaObjednavkyPK.class)
public class BPolozkaObjednavky {
    @Basic
    @javax.persistence.Column(name = "CENA", nullable = false, precision = 2)
    private int cena;

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    @Basic
    @javax.persistence.Column(name = "MNOZSTVO", nullable = false, precision = 0)
    private BigInteger mnozstvo;

    public BigInteger getMnozstvo() {
        return mnozstvo;
    }

    public void setMnozstvo(BigInteger mnozstvo) {
        this.mnozstvo = mnozstvo;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CISLO_OBJEDNAVKY", nullable = false, precision = 0)
    private BigInteger cisloObjednavky;

    public BigInteger getCisloObjednavky() {
        return cisloObjednavky;
    }

    public void setCisloObjednavky(BigInteger cisloObjednavky) {
        this.cisloObjednavky = cisloObjednavky;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CISLO_ND", nullable = false, precision = 0)
    private BigInteger cisloNd;

    public BigInteger getCisloNd() {
        return cisloNd;
    }

    public void setCisloNd(BigInteger cisloNd) {
        this.cisloNd = cisloNd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BPolozkaObjednavky that = (BPolozkaObjednavky) o;

        if (cena != that.cena) return false;
        if (mnozstvo != null ? !mnozstvo.equals(that.mnozstvo) : that.mnozstvo != null) return false;
        if (cisloObjednavky != null ? !cisloObjednavky.equals(that.cisloObjednavky) : that.cisloObjednavky != null)
            return false;
        if (cisloNd != null ? !cisloNd.equals(that.cisloNd) : that.cisloNd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cena;
        result = 31 * result + (mnozstvo != null ? mnozstvo.hashCode() : 0);
        result = 31 * result + (cisloObjednavky != null ? cisloObjednavky.hashCode() : 0);
        result = 31 * result + (cisloNd != null ? cisloNd.hashCode() : 0);
        return result;
    }
}
