/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package presentacion;

/**
 *
 * @author Law
 */

import logica.Artista;
import javax.swing.JFrame;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EspotifyMain {

    public static void main(String[] args) {
        // Crear el EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("espotifyPU"); // Asegúrate de que "espotifyPU" coincida con tu archivo persistence.xml
        
        // Crear el EntityManager
        EntityManager em = emf.createEntityManager();

        // Iniciar el formulario
        FormularioPrincipal fp = new FormularioPrincipal();
        fp.setVisible(true);
        
       
        // Crear un nuevo Artista
        Artista art1 = new Artista("nickname", "Nombre", "Apellido", "email@example.com", "2000-01-01", "Biografía del artista", "http://example.com");

        // Guardar el Artista en la base de datos
        em.getTransaction().begin();
        em.persist(art1);
        em.getTransaction().commit();
        
        // Cierre del EntityManager y EntityManagerFactory (opcional)
        // em.close();
        // emf.close();
    }
}