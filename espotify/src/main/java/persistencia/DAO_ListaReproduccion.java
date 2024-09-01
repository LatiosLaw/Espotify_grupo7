/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

/**
 *
 * @author Nico
 */
 
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import logica.ListaReproduccion;

public class DAO_ListaReproduccion {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public DAO_ListaReproduccion() {
        entityManagerFactory = Persistence.createEntityManagerFactory("espotifyPU");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void save(ListaReproduccion entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public ListaReproduccion find(String nombre) {
        return entityManager.find(ListaReproduccion.class, nombre);
    }

    public List<ListaReproduccion> findAll() {
        return entityManager.createQuery("SELECT e FROM MyEntity e", ListaReproduccion.class).getResultList();
    }

    public void update(ListaReproduccion entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    public void delete(String nombre) {
        ListaReproduccion entity = find(nombre);
        if (entity != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        }
    }

    public void close() {
        if (entityManager != null) entityManager.close();
        if (entityManagerFactory != null) entityManagerFactory.close();
    }
}