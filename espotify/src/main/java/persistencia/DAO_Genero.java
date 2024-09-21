package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import javax.persistence.NoResultException;
import logica.Genero;

public class DAO_Genero {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public DAO_Genero() {
        DatabaseInitializer.createDatabaseIfNotExists();
        entityManagerFactory = Persistence.createEntityManagerFactory("espotifyPU");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void save(Genero entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public Genero find(String nombre) {
        return entityManager.find(Genero.class, nombre);
    }

    public List<Genero> findAll() {
        return entityManager.createQuery("SELECT g FROM Genero g", Genero.class).getResultList();

    }

    public List<String> findfromAlbum(String nombre_album) {
        try {
            return entityManager.createQuery(
                    "SELECT g.nombre FROM Album a JOIN a.generos g WHERE a.nombre = :nombre_album", String.class)
                    .setParameter("nombre_album", nombre_album)
                    .getResultList();
        } catch (NoResultException e) {
            return null; // No se encontro ningún genero de ese album
        }

    }

    public void update(Genero entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    public void delete(String nombre) {
        Genero entity = find(nombre);
        if (entity != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        }
    }

    public void close() {
        if (entityManager != null) {
            entityManager.close();
        }
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
