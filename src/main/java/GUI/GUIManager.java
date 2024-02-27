package GUI;

import GUI.Login.LoginGUI;
import GUI.Menu.HlavneMenuGUI;
import GUI.Porucha.PoruchaGUI;
import GUI.Stroje.StrojeGUI;
import GUI.Stroje.TypStroja.TypStrojaGUI;
import GUI.Zamestnanci.TabulkaZamGUI;

public class GUIManager {
    private LoginGUI login;
    private HlavneMenuGUI hlavneMenuGUI;
    private TabulkaZamGUI zamestnanciGUI;
    private StrojeGUI strojeGUI;
    private TypStrojaGUI typStrojaGUI;
    private PoruchaGUI poruchaGUI;

    public GUIManager() {
        login = new LoginGUI(this);
        hlavneMenuGUI = new HlavneMenuGUI(this);
        zamestnanciGUI = new TabulkaZamGUI(this);
        strojeGUI = new StrojeGUI(this);
        typStrojaGUI = new TypStrojaGUI(strojeGUI);
        poruchaGUI = new PoruchaGUI(this, login);
    }

    public void zobrazLogin() {
        login.pack();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }

    public void zobrazHlavneMenu() {
        if (login != null) {
            login.dispose();
        }

        hlavneMenuGUI.pack();
        hlavneMenuGUI.setLocationRelativeTo(null);
        hlavneMenuGUI.setVisible(true);
    }

    public void zviditelniHlavneMenu() {

        if (zamestnanciGUI.isVisible()) {
            zamestnanciGUI.dispose();
        } else if (strojeGUI.isVisible()) {
            strojeGUI.dispose();
        }

        if (!hlavneMenuGUI.isVisible()) {
            hlavneMenuGUI.setVisible(true);
        }
    }

    public void zobrazTabulkuZam() {
        if (hlavneMenuGUI.isVisible()) {
            hlavneMenuGUI.setVisible(false);
        }

        if (zamestnanciGUI.isActive()) {
            zamestnanciGUI.setVisible(true);
        } else {
            zamestnanciGUI.pack();
            zamestnanciGUI.setLocationRelativeTo(null);
            zamestnanciGUI.setVisible(true);
        }
    }

    public void zobrazStoje() {
        if (hlavneMenuGUI.isVisible()) {
            hlavneMenuGUI.setVisible(false);
        }
        if (strojeGUI.isActive()) {
            strojeGUI.setVisible(true);
        } else {
            strojeGUI.pack();
            strojeGUI.setLocationRelativeTo(null);
            strojeGUI.setVisible(true);
        }
    }

    public void zobrazTypStroja() {
        if (typStrojaGUI.isActive()) {
            typStrojaGUI.setVisible(true);
        } else {
            typStrojaGUI.pack();
            typStrojaGUI.setLocationRelativeTo(null);
            typStrojaGUI.setAlwaysOnTop(true);
            typStrojaGUI.setVisible(true);
        }
    }

    public void zobrazPoruchu() {
        if (hlavneMenuGUI.isVisible()) {
            hlavneMenuGUI.setVisible(false);
        }
        if (poruchaGUI.isActive()) {
            poruchaGUI.setVisible(true);
        } else {
            poruchaGUI.pack();
            poruchaGUI.setLocationRelativeTo(null);
            poruchaGUI.setVisible(true);
        }
    }
}
