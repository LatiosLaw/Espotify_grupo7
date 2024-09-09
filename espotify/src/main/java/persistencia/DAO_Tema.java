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
import logica.Tema;
import logica.Usuario;

public class DAO_Tema {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public DAO_Tema() {
        entityManagerFactory = Persistence.createEntityManagerFactory("espotifyPU");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void save(Tema entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public Tema find(String nombre) {
        return entityManager.find(Tema.class, nombre);
    }

    public List<Tema> findAll() {
        return entityManager.createQuery("SELECT e FROM TEMA e", Tema.class).getResultList();
    }
    
    public List<Tema> findFromAlbum(String nombre_album) {
        try {
            return entityManager.createQuery(
                "SELECT t FROM Tema t WHERE t.ALBUM_NOMBRE = :nombre_album", Tema.class)
                .setParameter("nombre_album", nombre_album)
                .getResultList();
        } catch (NoResultException e) {
            return null; // No se encontro ningún tema de este album
        }
    }

    public void update(Tema entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    public void delete(String nombre) {
        Tema entity = find(nombre);
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