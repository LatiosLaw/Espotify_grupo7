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
import javax.persistence.NoResultException;
import logica.ListaParticular;
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
    
    public ListaParticular findListaPorNicks(String nick_creador, String nick_lista) {
        try {
            return entityManager.createQuery(
                "SELECT u FROM ListaReproduccion u WHERE u.nickname = :nick_lista AND u.creador = :nick_creador", ListaParticular.class)
                .setParameter("nick_creador", nick_creador)
                .setParameter("nick_lista", nick_lista)
                .getSingleResult();
        } catch (NoResultException e) {
            return null; // No se encontro ningún cliente con ese nombre
        }
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