package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import javax.persistence.NoResultException;
import logica.tema;

public class DAO_Tema {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public DAO_Tema() {
        entityManagerFactory = Persistence.createEntityManagerFactory("espotifyPU");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void save(tema entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public tema find(tema tema) {
        return entityManager.find(tema.class, tema);
    }

    public List<tema> findAll() {
        return entityManager.createQuery("SELECT e FROM TEMA e", tema.class).getResultList();
    }

    public List<tema> findFromAlbum(String nombre_album) {
        try {
            return entityManager.createQuery("SELECT t FROM tema t JOIN t.album a WHERE a.nombre = :nombre_album ORDER BY t.posicion_album ASC", tema.class)
                    .setParameter("nombre_album", nombre_album)
                    .getResultList();
        } catch (NoResultException e) {
            return null; // No se encontro ningún tema de este album
        }
    }
    
    public List<tema> findFromListaDefecto(String nombre_lista) { // No existen diferencias actualmente, seran implementadas proxima iteracion.
        try {
            return entityManager.createQuery("SELECT t FROM tema t JOIN t.listas l WHERE l.nombre = :nombre_lista", tema.class)
                    .setParameter("nombre_lista", nombre_lista)
                    .getResultList();
        } catch (NoResultException e) {
            return null; // No se encontro ningún tema de este album
        }
    }

    
    public List<tema> findFromListaParticular(String nombre_lista) { // No existen diferencias actualmente, seran implementadas proxima iteracion.
        try {
            return entityManager.createQuery("SELECT t FROM tema t JOIN t.listas WHERE l.nombre = :nombre_lista", tema.class)
                    .setParameter("nombre_lista", nombre_lista)
                    .getResultList();
        } catch (NoResultException e) {
            return null; // No se encontro ningún tema de este album
        }
    }


    public void update(tema entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    public void delete(tema tema){
        tema entity = find(tema);
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
