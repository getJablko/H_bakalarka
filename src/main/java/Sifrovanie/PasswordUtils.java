package Sifrovanie;

import Tabulky.BZamestnanec;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.*;
import java.awt.*;
import java.math.BigInteger;

//import static main.Main.entityManagerFactory;

public class PasswordUtils extends Component {
    // Generovanie soli pre šifrovanie
    private static final int WORKLOAD = 12;

    // Metóda na šifrovanie hesiel
    public static String hashPassword(String plainTextPassword) {
        String salt = BCrypt.gensalt(WORKLOAD);
        return BCrypt.hashpw(plainTextPassword, salt);
    }

    // Metóda na porovnanie hesla s uloženým zahashovaným heslom
    public static boolean checkPassword(String plainTextPassword, String hashedPassword) {
        try {
            if (null == hashedPassword || !hashedPassword.startsWith("$2a$")) {
                throw new IllegalArgumentException("Neplatné zahešované heslo");
            }
            return BCrypt.checkpw(plainTextPassword, hashedPassword);
        } catch (Exception e) {
            return false;
        }
    }

    public static String vratHesloVseobecne(int id) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        String string = "";
        try {
            transaction.begin();
            BZamestnanec existujuciZamestnanec = entityManager.find(BZamestnanec.class, BigInteger.valueOf(id));

            if (existujuciZamestnanec != null) {
                string = existujuciZamestnanec.getPassword();
            } else {
                // Ak zamestnanec s os_cislom neexistuje
                JOptionPane.showMessageDialog(null, "Zamestnanec s os_cislom " + id + " neexistuje.", "Chyba pri prihlásení", JOptionPane.ERROR_MESSAGE);
                //System.out.println("Zamestnanec s os_cislom " + id + " neexistuje.");
            }
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
        //System.out.println(string);
        return string;
    }
}
