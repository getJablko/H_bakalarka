package Tabulky;

import java.io.Serializable;
import java.math.BigInteger;

public class BPolozkaObjednavkyPK implements Serializable {

    private BigInteger cisloObjednavky;
    private BigInteger cisloNd;

    // Default constructor
    public BPolozkaObjednavkyPK() {
    }
    public BPolozkaObjednavkyPK(BigInteger cisloObj, BigInteger cisloND) {
        this.cisloObjednavky = cisloObj;
        this.cisloNd = cisloND;
    }

    // Constructors, getters, setters, equals, hashCode, etc.

    // Make sure to annotate these fields with @Id
    // Example:
    // @Id
    // @Column(name = "CISLO_OBJEDNAVKY", nullable = false, precision = 0)
    // private BigInteger cisloObjednavky;

    // @Id
    // @Column(name = "CISLO_ND", nullable = false, precision = 0)
    // private BigInteger cisloNd;
}
