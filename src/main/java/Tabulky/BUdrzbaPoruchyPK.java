package Tabulky;

import java.io.Serializable;
import java.math.BigInteger;

public class BUdrzbaPoruchyPK implements Serializable {

    private BigInteger idPoruchy;
    private BigInteger osCisloOpravy;

    // Constructors, getters, setters, equals, hashCode, etc.

    // Annotate these fields with @Id
    // Example:
    // @Id
    // @Column(name = "ID_PORUCHY", nullable = false, precision = 0)
    // private BigInteger idPoruchy;

    // @Id
    // @Column(name = "OS_CISLO_OPRAVY", nullable = false, precision = 0)
    // private BigInteger osCisloOpravy;
}