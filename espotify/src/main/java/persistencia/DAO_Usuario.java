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
import logica.Usuario;

public class DAO_Usuario {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public DAO_Usuario() {
        entityManagerFactory = Persistence.createEntityManagerFactory("espotifyPU");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void save(Usuario entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public Usuario find(Usuario user) {
        return entityManager.find(Usuario.class, user);
    }

    public Usuario findUsuarioByNick(String nick_ingresado) {
        try {
            return entityManager.createQuery(
                "SELECT * FROM usuario WHERE nickname = :nick_ingresado", Usuario.class)
                .setParameter("nickname", nick_ingresado)
                .getSingleResult();
        } catch (NoResultException e) {
            return null; // No se encontró ningún cliente con ese nombre
        }
    }
    
    public List<Usuario> findAll() {
        return entityManager.createQuery("SELECT * FROM USUARIO", Usuario.class).getResultList();
    }

    public void update(Usuario entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    public void delete(Usuario user) {
        Usuario entity = find(user);
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