package dataaccess;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DatabaseManager {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("testPU");
    static EntityManager em = emf.createEntityManager();
    public static EntityManager getDBbConnection(){
        if(em.isOpen()){
            return em;
        }
         return emf.createEntityManager();
    }
}
