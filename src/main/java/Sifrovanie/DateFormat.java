package Sifrovanie;

import javax.swing.*;
import java.util.regex.*;

public class DateFormat {
    public boolean overenie(String date){
        // Regular expression pattern for "yyyy-MM-dd" format
        String pattern = "\\d{4}-\\d{2}-\\d{2}";

        // Create a Pattern object
        Pattern regex = Pattern.compile(pattern);

        // Create a Matcher object
        Matcher matcher = regex.matcher(date);

        // Check if the string matches the pattern
        if (!matcher.matches()) {
            JOptionPane.showMessageDialog(null,"Dátum v zlom formáte! Potrebný formát:YYYY-MM-DD.");
            return false;
        }else {
            return true;
        }
    }
}