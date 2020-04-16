package repo;

import entity.ArtistsEntity;
import util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class ArtistRepository {
    PersistenceUtil pu = PersistenceUtil.getInstance();

    public void create(ArtistsEntity entity) {
        EntityManagerFactory factory = pu.getEMF();
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
    }

    public List<ArtistsEntity> findByName(String name) {
        EntityManagerFactory factory = pu.getEMF();
        EntityManager em = factory.createEntityManager();
        Query query = em.createQuery(
                "SELECT a FROM ArtistsEntity a WHERE a.name LIKE :artistName")
                .setParameter("artistName", name)
                .setMaxResults(20);
        return query.getResultList();
    }

    public ArtistsEntity findById(int id) {
        EntityManagerFactory factory = pu.getEMF();
        EntityManager em = factory.createEntityManager();
        Query query = em.createQuery(
                "SELECT a FROM ArtistsEntity a WHERE a.id=:artistId")
                .setParameter("artistId", id)
                .setMaxResults(1);
        return (ArtistsEntity) query.getSingleResult();
    }
}