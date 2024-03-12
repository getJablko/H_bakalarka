package Tabulky;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "B_UDRZBA_PORUCHY_NAHRADNY_DIEL", schema = "STACHERA")
@IdClass(BUdrzbaPoruchyNahradnyDielPK.class)
public class BUdrzbaPoruchyNahradnyDiel {

    @Id
    @Column(name = "ID_PORUCHY", nullable = false, precision = 0)
    private BigInteger idPoruchy;

    @Id
    @Column(name = "OS_CISLO_OPRAVY", nullable = false, precision = 0)
    private BigInteger osCisloOpravy;

    @Id
    @Column(name = "CISLO_ND", nullable = false, precision = 0)
    private BigInteger cisloNd;
    @Basic
    @Column(name = "POZADAVKA_ND", nullable = true, length = 50)
    private String pozadavkaNd;

    @Basic
    @Column(name = "POZADOVANE_MNOZSTVO", nullable = false, precision = 0)
    private BigInteger pozadovaneMnozstvo;

    @Basic
    @Column(name = "PRIPRAVENE", nullable = false, precision = 0)
    private BigInteger pripravene;

    public BigInteger getPozadovaneMnozstvo() {
        return this.pozadovaneMnozstvo;
    }

    public BigInteger getPripravene() {
        return this.pripravene;
    }

    public void setPozadovaneMnozstvo(BigInteger pozadovaneMnozstvo) {
        this.pozadovaneMnozstvo = pozadovaneMnozstvo;
    }

    public void setPripravene(BigInteger pripravene) {
        this.pripravene = pripravene;
    }

    public BigInteger getIdPoruchy() {
        return idPoruchy;
    }

    public void setIdPoruchy(BigInteger idPoruchy) {
        this.idPoruchy = idPoruchy;
    }

    public BigInteger getOsCisloOpravy() {
        return osCisloOpravy;
    }

    public void setOsCisloOpravy(BigInteger osCisloOpravy) {
        this.osCisloOpravy = osCisloOpravy;
    }

    public BigInteger getCisloNd() {
        return cisloNd;
    }

    public void setCisloNd(BigInteger cisloNd) {
        this.cisloNd = cisloNd;
    }

    public String getPozadavkaNd() {
        return pozadavkaNd;
    }

    public void setPozadavkaNd(String pozadavkaNd) {
        this.pozadavkaNd = pozadavkaNd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BUdrzbaPoruchyNahradnyDiel that = (BUdrzbaPoruchyNahradnyDiel) o;

        if (idPoruchy != null ? !idPoruchy.equals(that.idPoruchy) : that.idPoruchy != null) return false;
        if (osCisloOpravy != null ? !osCisloOpravy.equals(that.osCisloOpravy) : that.osCisloOpravy != null)
            return false;
        if (cisloNd != null ? !cisloNd.equals(that.cisloNd) : that.cisloNd != null) return false;
        if (pozadavkaNd != null ? !pozadavkaNd.equals(that.pozadavkaNd) : that.pozadavkaNd != null) return false;
        if (pozadovaneMnozstvo != null ? !pozadovaneMnozstvo.equals(that.pozadovaneMnozstvo) : that.pozadovaneMnozstvo != null)
            return false;
        if (pripravene != null ? !pripravene.equals(that.pripravene) : that.pripravene != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = idPoruchy != null ? idPoruchy.hashCode() : 0;
        result = 31 * result + (osCisloOpravy != null ? osCisloOpravy.hashCode() : 0);
        result = 31 * result + (cisloNd != null ? cisloNd.hashCode() : 0);
        result = 31 * result + (pozadavkaNd != null ? pozadavkaNd.hashCode() : 0);
        result = 31 * result + (pozadovaneMnozstvo != null ? pozadovaneMnozstvo.hashCode() : 0);
        result = 31 * result + (pripravene != null ? pripravene.hashCode() : 0);
        return result;
    }
}
