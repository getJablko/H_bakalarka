package main;

import GUI.GUIManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
/*
            BStroj bStroj = new BStroj();

            bStroj.setTypStroja("ohrňovák");
            bStroj.setPopis("01");
            bStroj.setCisloHaly("HS5400");
            bStroj.setZaradenie("23.11.2022");

            // Use merge instead of persist to handle detached entities
            entityManager.persist(bStroj);


            BTypStroja bTypStroja = new BTypStroja();
            bTypStroja.setTypStroja("skuska");
            bTypStroja.setPrioritaD(String.valueOf(2));

            entityManager.persist(bTypStroja);


            BNahradnyDiel bNahradnyDiel = new BNahradnyDiel();
            //bNahradnyDiel.setCisloNd(); generovane
            bNahradnyDiel.setTypStroja("ohrňovák");
            bNahradnyDiel.setDostupneMnozstvo(BigInteger.valueOf(2));
            bNahradnyDiel.setDostupnostNdD("NO");
            bNahradnyDiel.setMiestoUskladnenia("skladisko HS5400");

            entityManager.persist(bNahradnyDiel);

            BObjednavka bObjednavka = new BObjednavka();
            bObjednavka.setDatumDorucenia("10.11.2023");
            bObjednavka.setDatumObjednavky("05.11.2023");

            entityManager.persist(bObjednavka);


            BPolozkaObjednavky bPolozkaObjednavky = new BPolozkaObjednavky();
            bPolozkaObjednavky.setCisloObjednavky(BigInteger.valueOf(6));
            bPolozkaObjednavky.setCena(20.00);
            bPolozkaObjednavky.setMnozstvo(BigInteger.valueOf(15));
            bPolozkaObjednavky.setCisloNd(BigInteger.valueOf(7));

            entityManager.persist(bPolozkaObjednavky);

            BZamestnanec bZamestnanec = new BZamestnanec();
            bZamestnanec.setMeno("Mario");
            bZamestnanec.setPriezvisko("Stachera");
            bZamestnanec.setDostupnostZam(BigInteger.valueOf(1));
            bZamestnanec.setPassword("heslo123");
            //bZamestnanec.setOsCislo(BigInteger.valueOf(560300));
            bZamestnanec.setTypZamD("E");
            bZamestnanec.setPracoviskoD("HS6400");

            entityManager.persist(bZamestnanec);


            BUdrzbaPoruchy bUdrzbaPoruchy = new BUdrzbaPoruchy();
            bUdrzbaPoruchy.setIdPoruchy(BigInteger.valueOf(1));
            bUdrzbaPoruchy.setPrebratiePoruchy("10.11.2023");
            bUdrzbaPoruchy.setPricinaPoruchy("zlé tesnenie");
            bUdrzbaPoruchy.setDobaOpravy(BigInteger.valueOf(2));
            bUdrzbaPoruchy.setPopisUdrzby("vymena tesnenia");
            bUdrzbaPoruchy.setOsCisloOpravy(BigInteger.valueOf(6));

            entityManager.persist(bUdrzbaPoruchy);

            BUdrzbaPoruchyNahradnyDiel bUdrzbaPoruchyNahradnyDiel = new BUdrzbaPoruchyNahradnyDiel();
            bUdrzbaPoruchyNahradnyDiel.setIdPoruchy(BigInteger.valueOf(1));
            bUdrzbaPoruchyNahradnyDiel.setCisloNd(BigInteger.valueOf(6));
            bUdrzbaPoruchyNahradnyDiel.setOsCisloOpravy(BigInteger.valueOf(6));
            bUdrzbaPoruchyNahradnyDiel.setPozadavkaNd("objednat tesnenia na kompresor aspon 10 ks");

            entityManager.persist(bUdrzbaPoruchyNahradnyDiel);


            BUdrzbaPoruchy bUdrzbaPoruchy = new BUdrzbaPoruchy();
            bUdrzbaPoruchy.setIdPoruchy(BigInteger.valueOf(2));
            bUdrzbaPoruchy.setPrebratiePoruchy("10.11.2023");
            bUdrzbaPoruchy.setPricinaPoruchy("zlé rameno");
            bUdrzbaPoruchy.setDobaOpravy(2.5);
            bUdrzbaPoruchy.setPopisUdrzby("vymena ramena");
            bUdrzbaPoruchy.setOsCisloOpravy(BigInteger.valueOf(6));

            entityManager.persist(bUdrzbaPoruchy);

            BZamestnanec novyZamestnanec = new BZamestnanec();
            novyZamestnanec.setPriezvisko("Doe2");
            novyZamestnanec.setMeno("John2");
            novyZamestnanec.setDostupnostZam(BigInteger.valueOf(0));
            novyZamestnanec.setPassword(PasswordUtils.hashPassword("heslo2")); // Použite metódu na šifrovanie hesla
            novyZamestnanec.setPracoviskoD("HS6400");
            novyZamestnanec.setTypZamD("E");

*/

/*
            // Získanie existujúceho zamestnanca podľa os_cislo
            BZamestnanec existujuciZamestnanec = entityManager.find(BZamestnanec.class, BigInteger.valueOf(27));

            if (existujuciZamestnanec != null) {
                // Zmena dostupnosti na 0
                existujuciZamestnanec.setDostupnostZam(BigInteger.valueOf(0));
            } else {
                // Ak zamestnanec s os_cislo 27 neexistuje, môžete vypísať chybu alebo vykonať inú logiku
                System.out.println("Zamestnanec s os_cislo 27 neexistuje.");
            }

            // Uloženie zmien na existujúceho zamestnanca
            entityManager.merge(existujuciZamestnanec);

*/
/*
            LoginGUI LoginFrame = new LoginGUI();
            LoginFrame.pack();
            LoginFrame.setLocationRelativeTo(null);
            LoginFrame.setVisible(true);


            HlavneMenuGUI hlavneMenu = new HlavneMenuGUI();
            hlavneMenu.pack();
            hlavneMenu.setLocationRelativeTo(null);
            hlavneMenu.setVisible(true);


*/


/*          PasswordUtils passwordUtils = new PasswordUtils();
            passwordUtils.vratHeslo(27,entityManager,transaction);
*/


            GUIManager guiManager = new GUIManager();
            guiManager.zobrazLogin();
            //guiManager.zobrazHlavneMenu();


            transaction.commit();

        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
