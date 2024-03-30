package GUI.Zamestnanci;

import GUI.GUIManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.table.DefaultTableModel;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TabulkaZamGUITest {
    private TabulkaZamGUI tabulkaZamGUI;

    @BeforeEach
    public void setUp() throws IOException {
        tabulkaZamGUI = new TabulkaZamGUI(new GUIManager());
    }
/*
    @Test
    public void testInsertNewEmployee() {

        tabulkaZamGUI.jTextField1.setText("Test");
        tabulkaZamGUI.jTextField2.setText("Case");
        tabulkaZamGUI.jPasswordField1.setText(null);
        tabulkaZamGUI.jComboBox1.setSelectedItem("1");
        tabulkaZamGUI.jComboBox2.setSelectedItem("HS6400");
        tabulkaZamGUI.jComboBox3.setSelectedItem("I");

        assertThrows(Exception.class, () -> {
            tabulkaZamGUI.jButton1_INSERT_ActionPerformed(null);
        });
    }
 */
}