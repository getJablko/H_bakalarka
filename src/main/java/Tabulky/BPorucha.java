package Tabulky;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@javax.persistence.Table(name = "B_PORUCHA", schema = "STACHERA")
public class BPorucha {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "b_porucha_generovanie_id")
    @SequenceGenerator(name = "b_porucha_generovanie_id", sequenceName = "b_porucha_generovanie_id", allocationSize = 1)
    @javax.persistence.Column(name = "ID_PORUCHY", nullable = false, precision = 0)
    private BigInteger idPoruchy;

    public BigInteger getIdPoruchy() {
        return idPoruchy;
    }

    public void setIdPoruchy(BigInteger idPoruchy) {
        this.idPoruchy = idPoruchy;
    }

    @Basic
    @Column(name = "PORUCHA_OD", nullable = false)
    private String poruchaOd;

    public String getPoruchaOd() {
        return poruchaOd;
    }

    public void setPoruchaOd(String poruchaOd) {
        this.poruchaOd = poruchaOd;
    }

    @Basic
    @Column(name = "ID_STROJA", nullable = false, precision = 0)
    private BigInteger idStroja;

    public BigInteger getIdStroja() {
        return idStroja;
    }

    public void setIdStroja(BigInteger idStroja) {
        this.idStroja = idStroja;
    }

    @Basic
    @Column(name = "POPIS_PORUCHY", nullable = true, length = 100)
    private String popisPoruchy;

    public String getPopisPoruchy() {
        return popisPoruchy;
    }

    public void setPopisPoruchy(String popisPoruchy) {
        this.popisPoruchy = popisPoruchy;
    }

    @Basic
    @Column(name = "STROJ_V_PREVADZKE", nullable = false, precision = 0)
    private BigInteger strojVPrevadzke;

    public BigInteger getStrojVPrevadzke() {
        return strojVPrevadzke;
    }

    public void setStrojVPrevadzke(BigInteger strojVPrevadzke) {
        this.strojVPrevadzke = strojVPrevadzke;
    }

    @Basic
    @Column(name = "ZAVAZNOST_D", nullable = false, length = 1)
    private String zavaznostD;

    public String getZavaznostD() {
        return zavaznostD;
    }

    public void setZavaznostD(String zavaznostD) {
        this.zavaznostD = zavaznostD;
    }

    @Basic
    @Column(name = "TYP_PORUCHY_D", nullable = false, length = 1)
    private String typPoruchyD;

    public String getTypPoruchyD() {
        return typPoruchyD;
    }

    public void setTypPoruchyD(String typPoruchyD) {
        this.typPoruchyD = typPoruchyD;
    }

    @Basic
    @Column(name = "OS_CISLO_NAHLASENIA", nullable = false, precision = 0)
    private BigInteger osCisloNahlasenia;

    public BigInteger getOsCisloNahlasenia() {
        return osCisloNahlasenia;
    }

    public void setOsCisloNahlasenia(BigInteger osCisloNahlasenia) {
        this.osCisloNahlasenia = osCisloNahlasenia;
    }

    @Basic
    @Column(name = "PORUCHA_DO", nullable = true)
    private String poruchaDo;

    public String getPoruchaDo() {
        return poruchaDo;
    }

    public void setPoruchaDo(String poruchaDo) {
        this.poruchaDo = poruchaDo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BPorucha bPorucha = (BPorucha) o;

        if (idPoruchy != null ? !idPoruchy.equals(bPorucha.idPoruchy) : bPorucha.idPoruchy != null) return false;
        if (poruchaOd != null ? !poruchaOd.equals(bPorucha.poruchaOd) : bPorucha.poruchaOd != null) return false;
        if (idStroja != null ? !idStroja.equals(bPorucha.idStroja) : bPorucha.idStroja != null) return false;
        if (popisPoruchy != null ? !popisPoruchy.equals(bPorucha.popisPoruchy) : bPorucha.popisPoruchy != null)
            return false;
        if (strojVPrevadzke != null ? !strojVPrevadzke.equals(bPorucha.strojVPrevadzke) : bPorucha.strojVPrevadzke != null)
            return false;
        if (zavaznostD != null ? !zavaznostD.equals(bPorucha.zavaznostD) : bPorucha.zavaznostD != null) return false;
        if (typPoruchyD != null ? !typPoruchyD.equals(bPorucha.typPoruchyD) : bPorucha.typPoruchyD != null)
            return false;
        if (osCisloNahlasenia != null ? !osCisloNahlasenia.equals(bPorucha.osCisloNahlasenia) : bPorucha.osCisloNahlasenia != null)
            return false;
        if (poruchaDo != null ? !poruchaDo.equals(bPorucha.poruchaDo) : bPorucha.poruchaDo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPoruchy != null ? idPoruchy.hashCode() : 0;
        result = 31 * result + (poruchaOd != null ? poruchaOd.hashCode() : 0);
        result = 31 * result + (idStroja != null ? idStroja.hashCode() : 0);
        result = 31 * result + (popisPoruchy != null ? popisPoruchy.hashCode() : 0);
        result = 31 * result + (strojVPrevadzke != null ? strojVPrevadzke.hashCode() : 0);
        result = 31 * result + (zavaznostD != null ? zavaznostD.hashCode() : 0);
        result = 31 * result + (typPoruchyD != null ? typPoruchyD.hashCode() : 0);
        result = 31 * result + (osCisloNahlasenia != null ? osCisloNahlasenia.hashCode() : 0);
        result = 31 * result + (poruchaDo != null ? poruchaDo.hashCode() : 0);
        return result;
    }
}
