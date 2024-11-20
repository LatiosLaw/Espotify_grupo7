package persistencia;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import javax.persistence.NoResultException;
import logica.Registro_tema;
import logica.tema;

public class DAO_RegistroTema {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public DAO_RegistroTema() {
        DatabaseInitializer.createDatabaseIfNotExists();
        entityManagerFactory = Persistence.createEntityManagerFactory("espotifyPU");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void save(Registro_tema entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public Registro_tema find(String nombre_tem, String nombre_albu) {
        try {
        return entityManager.createQuery("SELECT r FROM Registro_tema r WHERE r.identificador.nombre_tema = :nombre_tem AND r.identificador.nombre_album = :nombre_albu", Registro_tema.class)
                    .setParameter("nombre_tem", nombre_tem)
                .setParameter("nombre_albu", nombre_albu)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // No se encontro ningún tema de este album
        }
    }

    public List<Registro_tema> findAll() {
        return entityManager.createQuery("SELECT e FROM Registro_tema e", Registro_tema.class).getResultList();
    }
    
    public Collection<Registro_tema> buscarLos100MasPopulares(){
        try {
        Collection<Registro_tema> temazos = entityManager.createQuery("SELECT r FROM Registro_tema r ORDER BY (r.reproducciones * 0.5 + r.descargas * 0.2 + r.agregado_a_lista * 0.15 + r.favoritos * 0.15) DESC", Registro_tema.class)
                    .getResultList();
        
        List<Registro_tema> listaTemazos = new ArrayList<>(temazos);

        // Recortar los primeros 100 elementos
        List<Registro_tema> top100Temazos = listaTemazos.size() > 100 
            ? listaTemazos.subList(0, 100) 
            : listaTemazos;

        return top100Temazos;
        
        } catch (NoResultException e) {
            return null; // No se encontro ningún tema de este album
        }
    }
    
    public void update(Registro_tema entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    public void delete(String nombre, String nombre_album) {
        Registro_tema entity = find(nombre, nombre_album);
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
