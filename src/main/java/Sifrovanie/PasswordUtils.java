package Sifrovanie;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtils {
    // Generovanie soli pre šifrovanie
    private static final int WORKLOAD = 12;

    // Metóda na šifrovanie hesiel
    public static String hashPassword(String plainTextPassword) {
        String salt = BCrypt.gensalt(WORKLOAD);
        return BCrypt.hashpw(plainTextPassword, salt);
    }

    // Metóda na porovnanie hesla s uloženým zahashovaným heslom
    public static boolean checkPassword(String plainTextPassword, String hashedPassword) {
        if (null == hashedPassword || !hashedPassword.startsWith("$2a$"))
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

        return BCrypt.checkpw(plainTextPassword, hashedPassword);
    }
}
