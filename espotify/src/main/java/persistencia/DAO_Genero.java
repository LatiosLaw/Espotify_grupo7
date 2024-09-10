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
import logica.Genero;
import logica.Tema;

public class DAO_Genero {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public DAO_Genero() {
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
        return entityManager.createQuery("SELECT * FROM genero", Genero.class).getResultList();

    }
    
    public List<String> findfromAlbum(String nombre_album) {
        try {
            return entityManager.createQuery(
                "SELECT g.generos_NOMBRE FROM genero_album g WHERE g.albumes_del_genero_NOMBRE = :nombre_album")
                .setParameter("nombre_album", nombre_album)
                .getResultList();
        } catch (NoResultException e) {
            return null; // No se encontro ningún tema de este album
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
        if (entityManager != null) entityManager.close();
        if (entityManagerFactory != null) entityManagerFactory.close();
    }
}