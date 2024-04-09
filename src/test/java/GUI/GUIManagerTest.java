package GUI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GUIManagerTest {

    private GUIManager guiManager;

    @BeforeEach
    public void setUp() {
        try {
            guiManager = new GUIManager();
        } catch (IOException e) {
            fail("Inicializacia zlyhala: " + e.getMessage());
        }
    }

    @Test
    public void testZobrazLogin() {
        guiManager.zobrazLogin();
        assertTrue(guiManager.login.isVisible());
    }

    @Test
    public void testZobrazMenu() {
        guiManager.zobrazHlMenuGUI();
        assertTrue(guiManager.hlMenuGUI.isVisible());
    }

    @Test
    public void testDisposeAll() {
        guiManager.disposeAll();
        for (javax.swing.JFrame window : guiManager.oknaGUI) {
            assertFalse(window.isVisible());
        }
    }
}