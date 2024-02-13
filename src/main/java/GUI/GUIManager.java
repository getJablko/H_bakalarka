package GUI;

import GUI.Login.LoginGUI;
import GUI.Menu.HlavneMenuGUI;
import GUI.Zamestnanci.TabulkaZamGUI;

public class GUIManager {
    private LoginGUI login;
    private HlavneMenuGUI hlavneMenuGUI;
    private TabulkaZamGUI zamestnanciGUI;

    public GUIManager(){
        login = new LoginGUI(this);
        hlavneMenuGUI = new HlavneMenuGUI(this);
        zamestnanciGUI = new TabulkaZamGUI(this);
    }

    public void zobrazLogin(){
        login.pack();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }

    public void zobrazHlavneMenu(){
        if(login!=null) {
            login.dispose();
        }

        hlavneMenuGUI.pack();
        hlavneMenuGUI.setLocationRelativeTo(null);
        hlavneMenuGUI.setVisible(true);
    }

    public void zobrazTabulkuZam(){
        if(hlavneMenuGUI.isVisible()){
            hlavneMenuGUI.setVisible(false);
        }

        zamestnanciGUI.pack();
        zamestnanciGUI.setLocationRelativeTo(null);
        zamestnanciGUI.setVisible(true);
    }
}
