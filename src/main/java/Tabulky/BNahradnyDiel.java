package Tabulky;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@javax.persistence.Table(name = "B_NAHRADNY_DIEL", schema = "STACHERA", catalog = "")
public class BNahradnyDiel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @javax.persistence.Column(name = "CISLO_ND", nullable = false, precision = 0)
    private BigInteger cisloNd;

    public BigInteger getCisloNd() {
        return cisloNd;
    }

    public void setCisloNd(BigInteger cisloNd) {
        this.cisloNd = cisloNd;
    }

    @Basic
    @Column(name = "DOSTUPNOST_ND_D", nullable = false, length = 2)
    private String dostupnostNdD;

    public String getDostupnostNdD() {
        return dostupnostNdD;
    }

    public void setDostupnostNdD(String dostupnostNdD) {
        this.dostupnostNdD = dostupnostNdD;
    }

    @Basic
    @Column(name = "MIESTO_USKLADNENIA", nullable = true, length = 50)
    private String miestoUskladnenia;

    public String getMiestoUskladnenia() {
        return miestoUskladnenia;
    }

    public void setMiestoUskladnenia(String miestoUskladnenia) {
        this.miestoUskladnenia = miestoUskladnenia;
    }

    @Basic
    @Column(name = "DOSTUPNE_MNOZSTVO", nullable = false, precision = 0)
    private BigInteger dostupneMnozstvo;

    public BigInteger getDostupneMnozstvo() {
        return dostupneMnozstvo;
    }

    public void setDostupneMnozstvo(BigInteger dostupneMnozstvo) {
        this.dostupneMnozstvo = dostupneMnozstvo;
    }

    @Basic
    @Column(name = "TYP_STROJA", nullable = false, length = 20)
    private String typStroja;

    public String getTypStroja() {
        return typStroja;
    }

    public void setTypStroja(String typStroja) {
        this.typStroja = typStroja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BNahradnyDiel that = (BNahradnyDiel) o;

        if (cisloNd != null ? !cisloNd.equals(that.cisloNd) : that.cisloNd != null) return false;
        if (dostupnostNdD != null ? !dostupnostNdD.equals(that.dostupnostNdD) : that.dostupnostNdD != null)
            return false;
        if (miestoUskladnenia != null ? !miestoUskladnenia.equals(that.miestoUskladnenia) : that.miestoUskladnenia != null)
            return false;
        if (dostupneMnozstvo != null ? !dostupneMnozstvo.equals(that.dostupneMnozstvo) : that.dostupneMnozstvo != null)
            return false;
        if (typStroja != null ? !typStroja.equals(that.typStroja) : that.typStroja != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cisloNd != null ? cisloNd.hashCode() : 0;
        result = 31 * result + (dostupnostNdD != null ? dostupnostNdD.hashCode() : 0);
        result = 31 * result + (miestoUskladnenia != null ? miestoUskladnenia.hashCode() : 0);
        result = 31 * result + (dostupneMnozstvo != null ? dostupneMnozstvo.hashCode() : 0);
        result = 31 * result + (typStroja != null ? typStroja.hashCode() : 0);
        return result;
    }
}
