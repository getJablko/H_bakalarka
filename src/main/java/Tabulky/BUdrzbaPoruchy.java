package Tabulky;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
@javax.persistence.Table(name = "B_UDRZBA_PORUCHY", schema = "STACHERA")
@IdClass(Tabulky.BUdrzbaPoruchyPK.class)
public class BUdrzbaPoruchy {
    @Basic
    @javax.persistence.Column(name = "PREBRATIE_PORUCHY", nullable = false)
    private String prebratiePoruchy;

    public String getPrebratiePoruchy() {
        return prebratiePoruchy;
    }

    public void setPrebratiePoruchy(String prebratiePoruchy) {
        this.prebratiePoruchy = prebratiePoruchy;
    }

    @Basic
    @javax.persistence.Column(name = "DOBA_OPRAVY", nullable = true, precision = 0)
    private double dobaOpravy;

    public double getDobaOpravy() {
        return dobaOpravy;
    }

    public void setDobaOpravy(double dobaOpravy) {
        this.dobaOpravy = dobaOpravy;
    }

    @Basic
    @javax.persistence.Column(name = "POPIS_UDRZBY", nullable = true, length = 100)
    private String popisUdrzby;

    public String getPopisUdrzby() {
        return popisUdrzby;
    }

    public void setPopisUdrzby(String popisUdrzby) {
        this.popisUdrzby = popisUdrzby;
    }

    @Basic
    @javax.persistence.Column(name = "PRICINA_PORUCHY", nullable = true, length = 50)
    private String pricinaPoruchy;

    public String getPricinaPoruchy() {
        return pricinaPoruchy;
    }

    public void setPricinaPoruchy(String pricinaPoruchy) {
        this.pricinaPoruchy = pricinaPoruchy;
    }

    @Id
    @Column(name = "ID_PORUCHY", nullable = false, precision = 0)
    private BigInteger idPoruchy;

    public BigInteger getIdPoruchy() {
        return idPoruchy;
    }

    public void setIdPoruchy(BigInteger idPoruchy) {
        this.idPoruchy = idPoruchy;
    }

    @Id
    @Column(name = "OS_CISLO_OPRAVY", nullable = false, precision = 0)
    private BigInteger osCisloOpravy;

    public BigInteger getOsCisloOpravy() {
        return osCisloOpravy;
    }

    public void setOsCisloOpravy(BigInteger osCisloOpravy) {
        this.osCisloOpravy = osCisloOpravy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BUdrzbaPoruchy that = (BUdrzbaPoruchy) o;

        if (prebratiePoruchy != null ? !prebratiePoruchy.equals(that.prebratiePoruchy) : that.prebratiePoruchy != null)
            return false;
        if (!Objects.equals(dobaOpravy, that.dobaOpravy)) return false;
        if (popisUdrzby != null ? !popisUdrzby.equals(that.popisUdrzby) : that.popisUdrzby != null) return false;
        if (pricinaPoruchy != null ? !pricinaPoruchy.equals(that.pricinaPoruchy) : that.pricinaPoruchy != null)
            return false;
        if (idPoruchy != null ? !idPoruchy.equals(that.idPoruchy) : that.idPoruchy != null) return false;
        if (osCisloOpravy != null ? !osCisloOpravy.equals(that.osCisloOpravy) : that.osCisloOpravy != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = prebratiePoruchy != null ? prebratiePoruchy.hashCode() : 0;
        long temp;
        temp = Double.doubleToLongBits(dobaOpravy);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (popisUdrzby != null ? popisUdrzby.hashCode() : 0);
        result = 31 * result + (pricinaPoruchy != null ? pricinaPoruchy.hashCode() : 0);
        result = 31 * result + (idPoruchy != null ? idPoruchy.hashCode() : 0);
        result = 31 * result + (osCisloOpravy != null ? osCisloOpravy.hashCode() : 0);
        return result;
    }
}
