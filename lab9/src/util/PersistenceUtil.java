package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {
    private static PersistenceUtil single_instance = null;
    private EntityManagerFactory emf;

    private PersistenceUtil()
    {
        emf = Persistence.createEntityManagerFactory("MusicAlbumsPU");
    }

    public static PersistenceUtil getInstance()
    {
        if (single_instance == null)
            single_instance = new PersistenceUtil();

        return single_instance;
    }

    public EntityManagerFactory getEMF() {
        return emf;
    }
}