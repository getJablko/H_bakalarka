package Tabulky;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigInteger;

public class BUdrzbaPoruchyNahradnyDielPK implements Serializable {
    @Column(name = "ID_PORUCHY", nullable = false, precision = 0)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger idPoruchy;
    @Column(name = "OS_CISLO_OPRAVY", nullable = false, precision = 0)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger osCisloOpravy;
    @Column(name = "CISLO_ND", nullable = false, precision = 0)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger cisloNd;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BUdrzbaPoruchyNahradnyDielPK that = (BUdrzbaPoruchyNahradnyDielPK) o;

        if (idPoruchy != null ? !idPoruchy.equals(that.idPoruchy) : that.idPoruchy != null) return false;
        if (osCisloOpravy != null ? !osCisloOpravy.equals(that.osCisloOpravy) : that.osCisloOpravy != null)
            return false;
        if (cisloNd != null ? !cisloNd.equals(that.cisloNd) : that.cisloNd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPoruchy != null ? idPoruchy.hashCode() : 0;
        result = 31 * result + (osCisloOpravy != null ? osCisloOpravy.hashCode() : 0);
        result = 31 * result + (cisloNd != null ? cisloNd.hashCode() : 0);
        return result;
    }
}
