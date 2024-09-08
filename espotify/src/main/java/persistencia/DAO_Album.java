/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import javax.persistence.NoResultException;
import logica.Album;
import logica.Usuario;
import org.eclipse.persistence.queries.DataModifyQuery;

public class DAO_Album {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public DAO_Album() {
        entityManagerFactory = Persistence.createEntityManagerFactory("espotifyPU");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void save(Album entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }
    
    public Album findAlbumByName(String nombre_album) {
        try {
            return entityManager.createQuery(
                "SELECT a FROM Album a WHERE a.nombre = :nombre_album", Album.class)
                .setParameter("nombre_album", nombre_album)
                .getSingleResult();
        } catch (NoResultException e) {
            return null; // No se encontro ningún album con ese nombre
        }
    }

    public Album find(String nombre) {
        return entityManager.find(Album.class, nombre);
    }

    public List<Album> findAll() {
        return entityManager.createQuery("SELECT e FROM MyEntity e", Album.class).getResultList();
    }
    
    public List<Album> findAllPorGenero(String nombre_genero) {
        return entityManager.createQuery("SELECT * FROM USUARIO", Album.class).getResultList();
    }
    
    public List<Album> findAllPorArtista(String nick_artista) {
        return entityManager.createQuery("SELECT * FROM USUARIO", Album.class).getResultList();
    }

    public void update(Album entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    public void delete(String nombre) {
        Album entity = find(nombre);
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