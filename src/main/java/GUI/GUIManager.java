package GUI;

import GUI.Login.LoginGUI;
import GUI.Menu.HlavneMenuGUI;

public class GUIManager {
    private LoginGUI login;
    private HlavneMenuGUI hlavneMenuGUI;

    public GUIManager(){
        login = new LoginGUI(this);
        hlavneMenuGUI = new HlavneMenuGUI();
    }

    public void zobrazLogin(){
        login.pack();
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }

    public void zobrazHlavneMunu(){
        if(login!=null) {
            login.dispose();
        }

        hlavneMenuGUI.pack();
        hlavneMenuGUI.setLocationRelativeTo(null);
        hlavneMenuGUI.setVisible(true);
    }
}
