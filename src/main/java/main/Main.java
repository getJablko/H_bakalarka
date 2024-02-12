import Tab.BStroj;
import Tab.BTypStroja;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

           // BTypStroja bTypStroja = new BTypStroja();
           // bTypStroja.setTypStroja("123");
           // bTypStroja.setPrioritaD("2");
           // entityManager.persist(bTypStroja);

            BStroj bStroj = new BStroj();
            bStroj.setIdStroja(BigInteger.valueOf(23));
            bStroj.setTypStroja("123");
            bStroj.setCisloHaly("HS5400");
            bStroj.setZaradenie("23.11.2022");

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
