package Tabulky;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "B_ZAMESTNANEC", schema = "STACHERA", catalog = "")
public class BZamestnanec {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "OS_CISLO", nullable = false, precision = 0)
    private BigInteger osCislo;
    @Basic
    @Column(name = "DOSTUPNOST_ZAM", nullable = false, precision = 0)
    private BigInteger dostupnostZam;
    @Basic
    @Column(name = "PRIEZVISKO", nullable = false, length = 20)
    private String priezvisko;
    @Basic
    @Column(name = "MENO", nullable = false, length = 20)
    private String meno;
    @Basic
    @Column(name = "PASSWORD", nullable = false, length = 20)
    private String password;
    @Basic
    @Column(name = "PRACOVISKO_D", nullable = false, length = 6)
    private String pracoviskoD;
    @Basic
    @Column(name = "TYP_ZAM_D", nullable = false, length = 1)
    private String typZamD;

    public BigInteger getOsCislo() {
        return osCislo;
    }

    public void setOsCislo(BigInteger osCislo) {
        this.osCislo = osCislo;
    }

    public BigInteger getDostupnostZam() {
        return dostupnostZam;
    }

    public void setDostupnostZam(BigInteger dostupnostZam) {
        this.dostupnostZam = dostupnostZam;
    }

    public String getPriezvisko() {
        return priezvisko;
    }

    public void setPriezvisko(String priezvisko) {
        this.priezvisko = priezvisko;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPracoviskoD() {
        return pracoviskoD;
    }

    public void setPracoviskoD(String pracoviskoD) {
        this.pracoviskoD = pracoviskoD;
    }

    public String getTypZamD() {
        return typZamD;
    }

    public void setTypZamD(String typZamD) {
        this.typZamD = typZamD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BZamestnanec that = (BZamestnanec) o;

        if (osCislo != null ? !osCislo.equals(that.osCislo) : that.osCislo != null) return false;
        if (dostupnostZam != null ? !dostupnostZam.equals(that.dostupnostZam) : that.dostupnostZam != null)
            return false;
        if (priezvisko != null ? !priezvisko.equals(that.priezvisko) : that.priezvisko != null) return false;
        if (meno != null ? !meno.equals(that.meno) : that.meno != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (pracoviskoD != null ? !pracoviskoD.equals(that.pracoviskoD) : that.pracoviskoD != null) return false;
        if (typZamD != null ? !typZamD.equals(that.typZamD) : that.typZamD != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = osCislo != null ? osCislo.hashCode() : 0;
        result = 31 * result + (dostupnostZam != null ? dostupnostZam.hashCode() : 0);
        result = 31 * result + (priezvisko != null ? priezvisko.hashCode() : 0);
        result = 31 * result + (meno != null ? meno.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (pracoviskoD != null ? pracoviskoD.hashCode() : 0);
        result = 31 * result + (typZamD != null ? typZamD.hashCode() : 0);
        return result;
    }
}
