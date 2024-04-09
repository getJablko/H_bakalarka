package GUI.HlMenu.Reporty;

import GUI.GUIManager;
import GUI.HlMenu.HlMenuGUI;
import GUI.Login.LoginGUI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ReportyGUITest {
    private ReportyGUI reportyGUI;

    @BeforeEach
    public void setUp() throws IOException {
        GUIManager guiManager = new GUIManager();
        HlMenuGUI hlMenuGUI = new HlMenuGUI(guiManager, new LoginGUI(guiManager));
        reportyGUI = new ReportyGUI(guiManager, hlMenuGUI);
    }

    @Test
    public void testNaplnPopis1() {
        reportyGUI.setDatumOd("2022-01-01");
        reportyGUI.setDatumDo("2024-01-31");
        reportyGUI.naplnPopis1();
        assertFalse(reportyGUI.getStringPopis1().isEmpty());
    }

    @Test
    public void testNaplnPopis2() {
        reportyGUI.setDatumOd("2022-01-01");
        reportyGUI.setDatumDo("2024-01-31");
        reportyGUI.naplnPopis2();
        assertFalse(reportyGUI.getStringPopis2().isEmpty());
    }

    // Další testy by mohly pokrýt další metody třídy ReportyGUI
}
