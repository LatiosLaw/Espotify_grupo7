package persistencia;

import java.util.Collection;
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

    public int obtenerCantidadSeguidores(String nickname) {
        try {
            Long count = entityManager.createQuery(
                    "SELECT COUNT(s) FROM Usuario u JOIN u.seguidores s WHERE u.nickname = :nickname", Long.class)
                    .setParameter("nickname", nickname)
                    .getSingleResult();
            return count.intValue();
        } catch (NoResultException e) {
            return 0; // Si no se encontró ningún seguidor, retorna 0
        } catch (Exception e) {
            e.printStackTrace(); // Para depuración
            return -1; // Retorna -1 en caso de error
        }
    }

    public Collection<String> obtenerSeguidoresDeUsuario(String nick_usuario) {
        try {
            return entityManager.createQuery(
                    "SELECT s.nickname FROM Usuario u JOIN u.seguidores s WHERE u.nickname = :nickname ", String.class)
                    .setParameter("nickname", nick_usuario)
                    .getResultList();

        } catch (NoResultException e) {
            return null; // No se encontro ningún cliente con ese nombre
        }
    }

    public Collection<String> obtenerSeguidosDeUsuario(String nick_usuario) {
        try {
            return entityManager.createQuery(
                    "SELECT u.nickname FROM Usuario u JOIN u.seguidores s WHERE s.nickname = :nickname ", String.class)
                    .setParameter("nickname", nick_usuario)
                    .getResultList();
        } catch (NoResultException e) {
            return null; // No se encontro ningún cliente con ese nombre
        }
    }

    public Collection<String> obtenerListasDeUsuario(String nick_usuario) {
        try {
            return entityManager.createQuery(
                    "SELECT l.nombre FROM Cliente u JOIN u.listasReproduccion l WHERE u.nickname = :nickname ", String.class)
                    .setParameter("nickname", nick_usuario)
                    .getResultList();
        } catch (NoResultException e) {
            return null; // No se encontro ningún cliente con ese nombre
        }
    }
    

    public Collection<String> obtenerAlbumArt(String nick_usuario) {
        try {
            return entityManager.createQuery(
                    "SELECT l.nombre FROM Artista a JOIN a.albumes l WHERE a.nickname = :nickname ", String.class)
                    .setParameter("nickname", nick_usuario)
                    .getResultList();
        } catch (NoResultException e) {
            return null; // No se encontro ningún cliente con ese nombre
        }
    }

    public Collection<String> obtenerListasFavCliente(String nick_usuario) {
        try {
            return entityManager.createQuery(
                    "SELECT l.nombre FROM Cliente u JOIN u.listas_favoritas l WHERE u.nickname = :nickname ", String.class)
                    .setParameter("nickname", nick_usuario)
                    .getResultList();
        } catch (NoResultException e) {
            return null; // No se encontro ningún cliente con ese nombre
        }
    }
    public Collection<String> obtenerListasParticularesFavCliente(String nick_usuario) {
        try {
            return entityManager.createQuery(
                    "SELECT l.nombre FROM Cliente u JOIN u.listas_favoritas l WHERE u.nickname = :nickname ", String.class)
                    .setParameter("nickname", nick_usuario)
                    .getResultList();
        } catch (NoResultException e) {
            return null; // No se encontro ningún cliente con ese nombre
        }
    }
    public Collection<String> obtenerTemaFavCliente(String nick_usuario) {
        try {
            return entityManager.createQuery(
                    "SELECT g.nickname FROM Cliente u JOIN u.temas_favoritos g WHERE u.nickname = :nickname ", String.class)
                    .setParameter("nickname", nick_usuario)
                    .getResultList();
        } catch (NoResultException e) {
            return null; // No se encontro ningún cliente con ese nombre
        }
    }

    public Collection<String> obtenerAlbumFavCliente(String nick_usuario) {
        try {
            return entityManager.createQuery(
                    "SELECT a.nombre FROM Cliente u JOIN u.albumes_favoritos a WHERE u.nickname = :nickname ", String.class)
                    .setParameter("nickname", nick_usuario)
                    .getResultList();
        } catch (NoResultException e) {
            return null; // No se encontro ningún cliente con ese nombre
        }
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
        return entityManager.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
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
        if (entityManager != null) {
            entityManager.close();
        }
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }

    public Usuario merge(Cliente cli) {
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
