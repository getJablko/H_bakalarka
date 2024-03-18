package GUI;

import GUI.Login.LoginGUI;
import GUI.Menu.HlavneMenuGUI;
import GUI.NahradneDiely.NahradneDielyGUI;
import GUI.NahradneDiely.PoziadavkyGUI.ZobrazeniePoziadaviekNdGUI;
import GUI.Objednavky.ObjednavkyGUI;
import GUI.Porucha.PoruchaGUI;
import GUI.Stroje.StrojeGUI;
import GUI.Stroje.TypStroja.TypStrojaGUI;
import GUI.UdrzbaPoruchy.UdrzbaND.UdrzbaNahradnyDielGUI;
import GUI.UdrzbaPoruchy.UdrzbaPoruchyGUI;
import GUI.Zamestnanci.TabulkaZamGUI;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GUIManager {
    private LoginGUI login;
    private HlavneMenuGUI hlavneMenuGUI;
    private TabulkaZamGUI zamestnanciGUI;
    private StrojeGUI strojeGUI;
    private TypStrojaGUI typStrojaGUI;
    private PoruchaGUI poruchaGUI;
    private ObjednavkyGUI objednavkyGUI;
    private UdrzbaPoruchyGUI udrzbaPoruchyGUI;
    private NahradneDielyGUI nahradneDielyGUI;
    private UdrzbaNahradnyDielGUI udrzbaNahradnyDielGUI;
    private ZobrazeniePoziadaviekNdGUI zobrazeniePoziadaviekNdGUI;
    private List<JFrame> oknaGUI = new ArrayList<>();

    public GUIManager() {
        this.login = new LoginGUI(this);
        this.hlavneMenuGUI = new HlavneMenuGUI(this,this.login);
        this.zamestnanciGUI = new TabulkaZamGUI(this);
        this.strojeGUI = new StrojeGUI(this,this.login);
        this.typStrojaGUI = new TypStrojaGUI(this.strojeGUI);
        this.poruchaGUI = new PoruchaGUI(this, this.login);
        this.udrzbaPoruchyGUI = new UdrzbaPoruchyGUI(this,this.login,this.poruchaGUI);
        this.nahradneDielyGUI = new NahradneDielyGUI(this,this.login);
        this.udrzbaNahradnyDielGUI = new UdrzbaNahradnyDielGUI(this.udrzbaPoruchyGUI);
        this.zobrazeniePoziadaviekNdGUI = new ZobrazeniePoziadaviekNdGUI(this,this.login,this.nahradneDielyGUI,this.udrzbaNahradnyDielGUI);
        this.objednavkyGUI = new ObjednavkyGUI(this,this.login,this.nahradneDielyGUI,this.zobrazeniePoziadaviekNdGUI,this.udrzbaNahradnyDielGUI);
        // pridanie do arraylistu okien
        this.oknaGUI.add(login);
        this.oknaGUI.add(hlavneMenuGUI);
        this.oknaGUI.add(zamestnanciGUI);
        this.oknaGUI.add(strojeGUI);
        this.oknaGUI.add(typStrojaGUI);
        this.oknaGUI.add(poruchaGUI);
        this.oknaGUI.add(objednavkyGUI);
        this.oknaGUI.add(udrzbaPoruchyGUI);
        this.oknaGUI.add(nahradneDielyGUI);
        this.oknaGUI.add(udrzbaNahradnyDielGUI);
        this.oknaGUI.add(zobrazeniePoziadaviekNdGUI);
    }

    public void zobrazLogin() {
        this.login.pack();
        this.login.setLocationRelativeTo(null);
        this.login.setVisible(true);
    }

    public void disposeAll() {
        for (javax.swing.JFrame window : oknaGUI) {
            window.dispose();
        }
    }

    public void odhlasenie() {
        this.disposeAll();
        this.zobrazLogin();
    }

    public void zobrazHlavneMenu() {
        if (this.login != null) {
            this.login.dispose();
        }

        this.hlavneMenuGUI.pack();
        this.hlavneMenuGUI.setLocationRelativeTo(null);
        this.hlavneMenuGUI.setVisible(true);
    }

    public void zviditelniHlavneMenu() {

        if (this.zamestnanciGUI.isVisible()) {
            this.zamestnanciGUI.dispose();
        } else if (this.strojeGUI.isVisible()) {
            this.strojeGUI.dispose();
        }

        if (!this.hlavneMenuGUI.isVisible()) {
            this.hlavneMenuGUI.setVisible(true);
        }
    }

    public void zobrazTabulkuZam() {
        if (this.hlavneMenuGUI.isVisible()) {
            this.hlavneMenuGUI.setVisible(false);
        }

        if (this.zamestnanciGUI.isActive()) {
            this.zamestnanciGUI.setVisible(true);
        } else {
            this.zamestnanciGUI.pack();
            this.zamestnanciGUI.setLocationRelativeTo(null);
            this.zamestnanciGUI.setVisible(true);
        }
    }

    public void zobrazStoje() {
        if (this.hlavneMenuGUI.isVisible()) {
            this.hlavneMenuGUI.setVisible(false);
        }
        if (this.strojeGUI.isActive()) {
            this.strojeGUI.setVisible(true);
        } else {
            this.strojeGUI.pack();
            this.strojeGUI.setLocationRelativeTo(null);
            this.strojeGUI.setVisible(true);
        }
    }

    public void zobrazTypStroja() {
        if (this.typStrojaGUI.isActive()) {
            this.typStrojaGUI.setVisible(true);
        } else {
            this.typStrojaGUI.pack();
            this.typStrojaGUI.setLocationRelativeTo(null);
            this.typStrojaGUI.setAlwaysOnTop(true);
            this.typStrojaGUI.setVisible(true);
        }
    }

    public void zobrazPoruchu() {
        if (this.hlavneMenuGUI.isVisible()) {
            this.hlavneMenuGUI.setVisible(false);
        }
        if (this.poruchaGUI.isActive()) {
            this.poruchaGUI.setVisible(true);
        } else {
            this.poruchaGUI.pack();
            this.poruchaGUI.setLocationRelativeTo(null);
            this.poruchaGUI.setVisible(true);
        }
    }

    public void zobrazObjednavky() {
        if (this.hlavneMenuGUI.isVisible()) {
            this.hlavneMenuGUI.setVisible(false);
        }
        if (this.objednavkyGUI.isActive()) {
            this.objednavkyGUI.setVisible(true);
        } else {
            this.objednavkyGUI.pack();
            this.objednavkyGUI.setLocationRelativeTo(null);
            this.objednavkyGUI.setVisible(true);
        }
    }

    public void zobrazUdrzbuPoruchy() {
        if (this.hlavneMenuGUI.isVisible()) {
            this.hlavneMenuGUI.setVisible(false);
        }
        if (this.udrzbaPoruchyGUI.isActive()) {
            this.udrzbaPoruchyGUI.setVisible(true);
        } else {
            this.udrzbaPoruchyGUI.pack();
            this.udrzbaPoruchyGUI.setLocationRelativeTo(null);
            this.udrzbaPoruchyGUI.setVisible(true);
        }
    }

    public void zobrazNahradneDiely() {
        if (this.hlavneMenuGUI.isVisible()) {
            this.hlavneMenuGUI.setVisible(false);
        }
        if (this.nahradneDielyGUI.isActive()) {
            this.nahradneDielyGUI.setVisible(true);
        } else {
            this.nahradneDielyGUI.pack();
            this.nahradneDielyGUI.setLocationRelativeTo(null);
            this.nahradneDielyGUI.setVisible(true);
        }
    }

    public void zobrazUdrzbaNahradnyDiel() {
        if (this.hlavneMenuGUI.isVisible()) {
            this.hlavneMenuGUI.setVisible(false);
        }
        if (this.udrzbaNahradnyDielGUI.isActive()) {
            this.udrzbaNahradnyDielGUI.setVisible(true);
        } else {
            this.udrzbaNahradnyDielGUI.pack();
            this.udrzbaNahradnyDielGUI.setLocationRelativeTo(null);
            this.udrzbaNahradnyDielGUI.setVisible(true);
        }
    }

    public void zobrazeniePoziadaviek() {
        if (this.hlavneMenuGUI.isVisible()) {
            this.hlavneMenuGUI.setVisible(false);
        }
        if (this.zobrazeniePoziadaviekNdGUI.isActive()) {
            this.zobrazeniePoziadaviekNdGUI.setVisible(true);
        } else {
            this.zobrazeniePoziadaviekNdGUI.pack();
            this.zobrazeniePoziadaviekNdGUI.setLocationRelativeTo(null);
            this.zobrazeniePoziadaviekNdGUI.setVisible(true);
        }
    }

}
