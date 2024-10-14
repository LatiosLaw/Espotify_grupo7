package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import javax.persistence.NoResultException;
import logica.Suscripcion;

public class DAO_Suscripcion {

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public DAO_Suscripcion() {
        DatabaseInitializer.createDatabaseIfNotExists();
        entityManagerFactory = Persistence.createEntityManagerFactory("espotifyPU");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void save(Suscripcion entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public Suscripcion findSusByName(String nick) {
        try {
            return entityManager.createQuery(
                    "SELECT s FROM Suscripcion s WHERE s.userNick = :nick", Suscripcion.class)
                    .setParameter("nick", nick)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // Sus?
        }
    }

    public Suscripcion find(String nombre) {
        return entityManager.find(Suscripcion.class, nombre);
    }

    public List<Suscripcion> findAll() {
       List<Suscripcion> albums = entityManager.createQuery("SELECT s FROM Suscripcion s", Suscripcion.class).getResultList();
       return albums.isEmpty() ? null : albums;
    }

    public void delete(String nombre) {
        Suscripcion entity = find(nombre);
        if (entity != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        }
    }

   
}
