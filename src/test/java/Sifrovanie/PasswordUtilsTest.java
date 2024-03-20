package Sifrovanie;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PasswordUtilsTest {
    @Test
    void hashPasswordNotEquals() {
        String password = "testPassword";
        String hashedPassword = PasswordUtils.hashPassword(password);

        assertNotEquals(password, hashedPassword);
    }

    @Test
    void checkPasswordTrue() {
        String password = "testPassword";
        String hashedPassword = PasswordUtils.hashPassword(password);

        assertTrue(PasswordUtils.checkPassword(password, hashedPassword));
    }

    @Test
    public void checkPasswordFalse() {
        String password = "testPassword";
        String hashedPassword = "invalidHash";

        assertFalse(PasswordUtils.checkPassword(password, hashedPassword));
    }
}