package Tabulky;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@javax.persistence.Table(name = "B_STROJ", schema = "STACHERA", catalog = "")
public class BStroj {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @javax.persistence.Column(name = "ID_STROJA", nullable = false, precision = 0)
    private BigInteger idStroja;

    public BigInteger getIdStroja() {
        return idStroja;
    }

    public void setIdStroja(BigInteger idStroja) {
        this.idStroja = idStroja;
    }

    @Basic
    @Column(name = "POPIS", nullable = true, length = 100)
    private String popis;

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    @Basic
    @Column(name = "CISLO_HALY", nullable = false, length = 6)
    private String cisloHaly;

    public String getCisloHaly() {
        return cisloHaly;
    }

    public void setCisloHaly(String cisloHaly) {
        this.cisloHaly = cisloHaly;
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

    @Basic
    @Column(name = "ZARADENIE", nullable = false)
    private String zaradenie;

    public String getZaradenie() {
        return zaradenie;
    }

    public void setZaradenie(String zaradenie) {
        this.zaradenie = zaradenie;
    }

    @Basic
    @Column(name = "VYRADENIE", nullable = true)
    private String vyradenie;

    public String getVyradenie() {
        return vyradenie;
    }

    public void setVyradenie(String vyradenie) {
        this.vyradenie = vyradenie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BStroj bStroj = (BStroj) o;

        if (idStroja != null ? !idStroja.equals(bStroj.idStroja) : bStroj.idStroja != null) return false;
        if (popis != null ? !popis.equals(bStroj.popis) : bStroj.popis != null) return false;
        if (cisloHaly != null ? !cisloHaly.equals(bStroj.cisloHaly) : bStroj.cisloHaly != null) return false;
        if (typStroja != null ? !typStroja.equals(bStroj.typStroja) : bStroj.typStroja != null) return false;
        if (zaradenie != null ? !zaradenie.equals(bStroj.zaradenie) : bStroj.zaradenie != null) return false;
        if (vyradenie != null ? !vyradenie.equals(bStroj.vyradenie) : bStroj.vyradenie != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idStroja != null ? idStroja.hashCode() : 0;
        result = 31 * result + (popis != null ? popis.hashCode() : 0);
        result = 31 * result + (cisloHaly != null ? cisloHaly.hashCode() : 0);
        result = 31 * result + (typStroja != null ? typStroja.hashCode() : 0);
        result = 31 * result + (zaradenie != null ? zaradenie.hashCode() : 0);
        result = 31 * result + (vyradenie != null ? vyradenie.hashCode() : 0);
        return result;
    }
}
