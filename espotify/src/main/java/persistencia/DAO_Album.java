package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import javax.persistence.NoResultException;
import logica.Album;

public class DAO_Album {

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public DAO_Album() {
        DatabaseInitializer.createDatabase();
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
       List<Album> albums = entityManager.createQuery("SELECT e FROM Album e", Album.class).getResultList();
       return albums.isEmpty() ? null : albums;
    }
    
    public List<String> findAllPorGenero(String nombre_genero) {
        try {
            return entityManager.createQuery(
                    "SELECT a.nombre FROM Album a JOIN a.generos g WHERE g.nombre = :nombre_genero", String.class)
                    .setParameter("nombre_genero", nombre_genero)
                    .getResultList();
        } catch (NoResultException e) {
            return null; // No se encontro ningún album con ese genero
        }
    }

    public List<Album> findAllPorArtista(String nick_artista) {
        try {
            return entityManager.createQuery(
                    "SELECT a FROM Album a JOIN a.creador c WHERE c.nickname = :nick_artista", Album.class)
                    .setParameter("nick_artista", nick_artista)
                    .getResultList();
        } catch (NoResultException e) {
            return null; // No se encontro ningún album con ese artista
        }
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
        if (entityManager != null) {
            entityManager.close();
        }
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
