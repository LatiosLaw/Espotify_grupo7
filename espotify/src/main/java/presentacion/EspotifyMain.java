/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package presentacion;

/**
 *
 * @author Law
 */
import logica.artista;
import logica.cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import persistencia.HibernateUtil;

public class EspotifyMain {

    public static void main(String[] args) {
    // Crear el EntityManagerFactory
   

        // Iniciar el formulario
        FormularioPrincipal fp = new FormularioPrincipal();
        fp.setVisible(true);
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        
        // Start a session
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            // Begin a transaction
            transaction = session.beginTransaction();

            // Perform operations, e.g., save an entity
            artista entity = new artista();
            entity.setNickname("Pepe");
            entity.setNombre("Pepe");
            entity.setApellido("Pepe");
            session.save(entity);
            
            cliente entity2 = new cliente();
            entity2.setNickname("Pepez");
            entity2.setNombre("Pepez");
            entity2.setApellido("Pepez");
            session.save(entity2);

            // Commit the transaction
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // Close the session
            session.close();
        }

        // Shutdown the SessionFactory
        HibernateUtil.shutdown();

}
}