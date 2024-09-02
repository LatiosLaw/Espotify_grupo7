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
import logica.Cliente;
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
                "SELECT u FROM Usuario u WHERE u.nickname = :nick_ingresado", Usuario.class)
                .setParameter("nick_ingresado", nick_ingresado)
                .getSingleResult();
        } catch (NoResultException e) {
            return null; // No se encontro ningún cliente con ese nombre
        }
    }
    
    public Usuario findUsuarioByMail(String mail_ingresado) {
    try {
        return entityManager.createQuery(
            "SELECT u FROM Usuario u WHERE u.correo = :mail_ingresado", Usuario.class)
            .setParameter("mail_ingresado", mail_ingresado)
            .getSingleResult();
    } catch (NoResultException e) {
        return null; // No se encontro ningún usuario con ese correo
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

    public Usuario merge(Cliente cli) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    try {
        entityManager.getTransaction().begin();
        // Buscar el cliente existente
        Usuario existingClient = findUsuarioByNick(cli.getNickname());
        if (existingClient != null) {
            // Actualizar los campos necesarios del cliente existente
            existingClient.setNombre(cli.getNombre());
            existingClient.setApellido(cli.getApellido());
            existingClient.setCorreo(cli.getEmail());
            existingClient.setFechaNac(cli.getNacimiento());
            // Aquí puedes agregar otros campos que necesiten actualizarse
            existingClient = entityManager.merge(existingClient);
        } else {
            // Si no existe, persistir el nuevo cliente
            existingClient = entityManager.merge(cli);
        }
        entityManager.getTransaction().commit();
        return existingClient;
    } catch (Exception e) {
        if (entityManager.getTransaction().isActive()) {
            entityManager.getTransaction().rollback();
        }
        e.printStackTrace();
        return null;
    } finally {
        entityManager.close();
    }
}
}