package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import javax.persistence.NoResultException;
import logica.Registro_tema;

public class DAO_RegistroTema {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public DAO_RegistroTema() {
        DatabaseInitializer.createDatabaseIfNotExists();
        entityManagerFactory = Persistence.createEntityManagerFactory("espotifyPU");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void save(Registro_tema entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public Registro_tema find(String nombre_tem, String nombre_albu) {
        try {
        return entityManager.createQuery("SELECT r FROM Registro_tema r WHERE r.identificador.nombre_tema = :nombre_tem AND r.identificador.nombre_album = :nombre_albu", Registro_tema.class)
                    .setParameter("nombre_tem", nombre_tem)
                .setParameter("nombre_albu", nombre_albu)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // No se encontro ningún tema de este album
        }
    }

    public List<Registro_tema> findAll() {
        return entityManager.createQuery("SELECT e FROM Registro_tema e", Registro_tema.class).getResultList();
    }
    
    public void update(Registro_tema entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    public void delete(String nombre, String nombre_album) {
        Registro_tema entity = find(nombre, nombre_album);
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
