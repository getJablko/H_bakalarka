package Sifrovanie;

import javax.swing.*;
import java.util.regex.*;

public class DateFormat {
    public boolean overenie(String date){
        // format "yyyy-MM-dd"
        String pattern = "\\d{4}-\\d{2}-\\d{2}";
        // Create a Pattern object
        Pattern regex = Pattern.compile(pattern);
        // Create a Matcher object
        Matcher matcher = regex.matcher(date);

        // overenie formatu
        if (!matcher.matches()) {
            JOptionPane.showMessageDialog(null,"Dátum v zlom formáte! Potrebný formát: YYYY-MM-DD.");
            return false;
        } else {
            // ziskanie udajov cez substring
            int year = Integer.parseInt(date.substring(0, 4));
            int month = Integer.parseInt(date.substring(5, 7));
            int day = Integer.parseInt(date.substring(8, 10));

            // overenie mesiacov
            if (month < 1 || month > 12) {
                JOptionPane.showMessageDialog(null,"Nesprávny mesiac! Mesiac musí byť medzi 01 a 12.");
                return false;
            }
            // overenie dni
            if (day < 1 || day > 31) {
                JOptionPane.showMessageDialog(null,"Nesprávny deň! Deň musí byť medzi 01 a 31.");
                return false;
            }
            // februar
            if (month == 2) {
                boolean jePriestupny = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
                if (day > 29 || (day == 29 && !jePriestupny)) {
                    JOptionPane.showMessageDialog(null,"Nesprávny deň pre február! V priestupnom roku deň musí byť najviac 29.");
                    return false;
                }
            }
            // april, jun, september, november
            if (month == 4 || month == 6 || month == 9 || month == 11) {
                if (day > 30) {
                    JOptionPane.showMessageDialog(null,"Nesprávny deň! Apríl, jún, september a november majú najviac 30 dní.");
                    return false;
                }
            }
            return true;
        }
    }
}