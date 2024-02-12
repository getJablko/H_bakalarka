package Tabulky;

import javax.persistence.*;

@Entity
@javax.persistence.Table(name = "B_TYP_STROJA", schema = "STACHERA", catalog = "")
public class BTypStroja {
    @Basic
    @javax.persistence.Column(name = "PRIORITA_D", nullable = false, length = 1)
    private String prioritaD;

    public String getPrioritaD() {
        return prioritaD;
    }

    public void setPrioritaD(String prioritaD) {
        this.prioritaD = prioritaD;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
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

        BTypStroja that = (BTypStroja) o;

        if (prioritaD != null ? !prioritaD.equals(that.prioritaD) : that.prioritaD != null) return false;
        if (typStroja != null ? !typStroja.equals(that.typStroja) : that.typStroja != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = prioritaD != null ? prioritaD.hashCode() : 0;
        result = 31 * result + (typStroja != null ? typStroja.hashCode() : 0);
        return result;
    }
}
