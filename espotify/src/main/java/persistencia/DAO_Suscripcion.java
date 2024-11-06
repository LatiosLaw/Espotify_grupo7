package persistencia;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import javax.persistence.NoResultException;
import logica.Suscripcion;
import logica.Usuario;

public class DAO_Suscripcion {

    private final EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public DAO_Suscripcion() {
        DatabaseInitializer.createDatabaseIfNotExists();
        entityManagerFactory = Persistence.createEntityManagerFactory("espotifyPU");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void save(Suscripcion entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public Suscripcion findSusByName(String nick, int id) {
        try {
            return entityManager.createQuery(
                    "SELECT s FROM Suscripcion s WHERE s.userNick = :nick AND s.id = _id", Suscripcion.class)
                    .setParameter("nick", nick)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // Sus?
        }
    }

    public Suscripcion find(int id) {
        return entityManager.find(Suscripcion.class, id);
    }

    public List<Suscripcion> findAll() {
       List<Suscripcion> sus = entityManager.createQuery("SELECT s FROM Suscripcion s", Suscripcion.class).getResultList();
       return sus.isEmpty() ? null : sus;
    }
    public Collection<Integer> findAllInteger() {
        List<Integer> sus = entityManager.createQuery("SELECT s.id FROM Suscripcion s", Integer.class).getResultList();
       return sus.isEmpty() ? null : sus;
    
    }
    public Collection<Suscripcion> findPendientesString(String nick) {
       try {
            return entityManager.createQuery(
                    "SELECT s FROM Suscripcion s where s.estado = 'Pendiente' AND s.userNick = :nick", Suscripcion.class)
                    .setParameter("nick", nick)
                    .getResultList();
        } catch (NoResultException e) {
            return null; // Sus?
        }

    }
    public Collection<Suscripcion> findPendientesVencidasString(String nick){
        try {
            return entityManager.createQuery(
                    "SELECT s FROM Suscripcion s where s.userNick = :nick AND s.estado = 'Pendiente' OR s.estado = 'Vencida' AND s.userNick = :nick", Suscripcion.class)
                    .setParameter("nick", nick)
                    .getResultList();
        } catch (NoResultException e) {
            return null; // Sus?
        }
        
    }

    
     public Collection<Integer> findAllPorNombre(String nick) {
       try {
            return entityManager.createQuery(
                    "SELECT s.id FROM Suscripcion s where s.userNick = :nick", Integer.class)
                    .setParameter("nick", nick)
                    .getResultList();
        } catch (NoResultException e) {
            return null; // Sus?
        }

    }

     public List<Suscripcion> findVigentes() {
       List<Suscripcion> sus = entityManager.createQuery("SELECT s FROM Suscripcion s where s.estado = 'Vigente'", Suscripcion.class).getResultList();
       return sus.isEmpty() ? null : sus;
    }

    public void delete(int id) {
        Suscripcion entity = find(id);
        if (entity != null) {
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        }
    }
    
    public void update(Suscripcion entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    public int darIdSus() {
       int sus = entityManager.createQuery("SELECT max(s.id) FROM Suscripcion s"
               ,int.class)
               .getSingleResult();

       return sus;
    
    
    }

    public Collection<Suscripcion> findAllPorCliente(String nick) {
        try {
            return entityManager.createQuery(
                    "SELECT s FROM Suscripcion s where s.userNick = :nick", Suscripcion.class)
                    .setParameter("nick", nick)
                    .getResultList();
        } catch (NoResultException e) {
            return null; // Sus?
        }
    }

    

   
}
