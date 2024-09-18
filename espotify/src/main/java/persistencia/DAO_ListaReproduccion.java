package persistencia;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import javax.persistence.NoResultException;
import logica.ListaParticular;
import logica.ListaPorDefecto;
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
                    "SELECT u FROM ListaParticular u WHERE u.nombre = :nick_lista AND u.creador.nickname = :nick_creador",
                    ListaParticular.class)
                    .setParameter("nick_creador", nick_creador)
                    .setParameter("nick_lista", nick_lista)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // No se encontró ninguna lista con esos parámetros
        } catch (Exception e) {
            e.printStackTrace(); // Para depuración
            return null;
        }
    }

    public Collection<ListaParticular> findListaPorCliente(String nick_creador) {
        try {
            return entityManager.createQuery(
                    "SELECT u FROM ListaParticular u WHERE u.creador.nickname = :nick_creador",
                    ListaParticular.class)
                    .setParameter("nick_creador", nick_creador)
                    .getResultList(); // Change here to getResultList()
        } catch (NoResultException e) {
            return new ArrayList<>(); // Return an empty list instead of null
        } catch (Exception e) {
            e.printStackTrace(); // For debugging
            return new ArrayList<>(); // Return an empty list in case of an error
        }
    }

    public ListaPorDefecto findListaPorGeneroYNombre(String generoNombre, String nombreLista) {
        try {
            return entityManager.createQuery(
                    "SELECT u FROM ListaPorDefecto u WHERE u.genero.nombre = :generoNombre AND u.nombre = :nombreLista",
                    ListaPorDefecto.class)
                    .setParameter("generoNombre", generoNombre)
                    .setParameter("nombreLista", nombreLista)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // No se encontró ninguna lista con esos parámetros
        } catch (Exception e) {
            e.printStackTrace(); // Para depuración
            return null;
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
        if (entityManager != null) {
            entityManager.close();
        }
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
