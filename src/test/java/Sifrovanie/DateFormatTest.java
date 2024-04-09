package Sifrovanie;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class DateFormatTest {

    @Test
    void overenieDatumuTrue() {
        DateFormat dateFormat = new DateFormat();
        assertTrue(dateFormat.overenie("2024-03-20"));
    }

}