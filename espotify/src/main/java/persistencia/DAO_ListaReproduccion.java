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
       DatabaseInitializer.createDatabase();
        entityManagerFactory = Persistence.createEntityManagerFactory("espotifyPU");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void save(ListaReproduccion entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

   
    public List<ListaParticular> findAllListasParticulares() {
        return entityManager.createQuery("SELECT lp FROM ListaParticular lp", ListaParticular.class).getResultList();
    }
    
    public List<ListaParticular> findAllListasParticularesPublicas() {
        return entityManager.createQuery("SELECT lp FROM ListaParticular lp WHERE lp.visibilidad=true", ListaParticular.class).getResultList();
    }

    public ListaParticular findListaPorNicks(String nick_creador, String nick_lista) {
      try {
            return entityManager.createQuery(
                    "SELECT u FROM ListaParticular u WHERE u.identificador.nombre_lista = :nick_lista AND u.identificador.nombre_cliente = :nick_creador",
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
                    .getResultList();
        } catch (NoResultException e) {
            return new ArrayList<>(); // No se encontraron listas para este cliente
        } catch (Exception e) {
            e.printStackTrace(); // Para depuracion
            return null;
        }
    }

    public ListaPorDefecto findListaPorGeneroYNombre(String generoNombre, String nombreLista) {
        try {
            return entityManager.createQuery(
                    "SELECT u FROM ListaReproduccion u WHERE u.genero.nombre = :generoNombre AND u.identificador.nombre_lista = :nombreLista",
                    ListaPorDefecto.class)
                    .setParameter("generoNombre", generoNombre)
                    .setParameter("nombreLista", nombreLista)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ListaPorDefecto findListaPorNombre(String nombreLista) {
        try {
            return entityManager.createQuery(
                    "SELECT u FROM ListaPorDefecto u WHERE u.nombre = :nombreLista",
                    ListaPorDefecto.class)
                    .setParameter("nombreLista", nombreLista)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ListaReproduccion findListaReproduccionPorNombre(String nombreLista, String nombreCliente) {
        try {
            return entityManager.createQuery(
                    "SELECT u FROM ListaReproduccion u WHERE u.identificador.nombre_lista = :nick_lista AND u.identificador.nombre_cliente = :nick_creador",
                    ListaParticular.class)
                    .setParameter("nick_creador", nombreCliente)
                    .setParameter("nick_lista", nombreLista)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // No se encontró ninguna lista con esos parámetros
        } catch (Exception e) {
            e.printStackTrace(); // Para depuración
            return null;
        }
    }
    public ListaPorDefecto findListaPorDefectoPorNombre(String nombreLista) {
       try {
           String nick_creador = "none";
            return entityManager.createQuery(
                    "SELECT u FROM ListaPorDefecto u WHERE u.identificador.nombre_lista = :nick_lista AND u.identificador.nombre_cliente = :nick_creador",
                    ListaPorDefecto.class)
                    .setParameter("nick_creador", nick_creador)
                    .setParameter("nick_lista", nombreLista)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // No se encontró ninguna lista con esos parámetros
        } catch (Exception e) {
            e.printStackTrace(); // Para depuración
            return null;
        }
    }
    public Collection<ListaPorDefecto> findListasPorGeneros(String generoNombre) {
        try {
            return entityManager.createQuery(
                    "SELECT u FROM ListaPorDefecto u WHERE u.genero.nombre = :generoNombre",
                    ListaPorDefecto.class)
                    .setParameter("generoNombre", generoNombre)
                    .getResultList();
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
        ListaReproduccion entity = this.findListaPorNombre(nombre);
        
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

    public Collection<String> devolverListasParticularesString(String nickname) {
        try {
            return entityManager.createQuery(
                    "SELECT l.nombre FROM ListaParticular l WHERE l.creador = :nickname ", String.class)
                    .setParameter("nickname", nickname)
                    .getResultList();

        } catch (NoResultException e) {
            return null; // No se encontro ningún cliente con ese nombre
        }
    }

    public Collection<String> devolverListasPorDefectoString() {
        Collection<String> listas = 
        entityManager.createQuery("SELECT l.identificador.nombre_lista FROM ListaPorDefecto l", String.class).getResultList();
        return listas.isEmpty() ? null : listas;
    }
    
    public Collection<ListaPorDefecto> devolverListasPorDefecto() {
        Collection<ListaPorDefecto> listas = 
        entityManager.createQuery("SELECT l FROM ListaPorDefecto l", ListaPorDefecto.class).getResultList();
        return listas;
    }
    
}
