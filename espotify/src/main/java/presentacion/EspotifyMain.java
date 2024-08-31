/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package presentacion;

/**
 *
 * @author Law
 */

import logica.Usuario;
import logica.Artista;
import logica.Cliente;
import logica.Tema;
import logica.Album;
import logica.Genero;
import logica.ListaReproduccion;
import logica.ListaParticular;
import logica.ListaPorDefecto;

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
        Cliente cli1 = new Cliente("pepe12","Pepe","Suarez","example@yourmother.com","2003-02-12");
        Tema tem1 = new Tema("Midnight Mayoi",20);
        Tema tem2 = new Tema("Despacito",50);
        Tema tem3 = new Tema("Velociraptor",34);
        Album alb1 = new Album("Wachiturros2",2020);
        Genero g1 = new Genero("Tango");
        Genero g2 = new Genero("Cumbia");
        ListaPorDefecto lista1 = new ListaPorDefecto("Canciones Epicas",g1);
        ListaParticular lista2 = new ListaParticular("Mis canciones nostalgicas", false);
        
        cli1.TemaFav(tem1);
        cli1.Seguir(art1);
        cli1.AlbumFav(alb1);
        cli1.ListasFav(lista1);
        
        // Guardar el Artista en la base de datos
        em.getTransaction().begin();
        em.persist(art1);
        em.getTransaction().commit();
        
        // Guardar el Tema en la base de datos
        em.getTransaction().begin();
        em.persist(tem1);
        em.persist(tem2);
        em.persist(tem3);
        em.getTransaction().commit();
        
        alb1.agregarTema(tem1);
        alb1.agregarTema(tem2);
        alb1.agregarTema(tem3);
        
        // Guardar el Album en la base de datos
        em.getTransaction().begin();
        em.persist(alb1);
        em.getTransaction().commit();
        
        // Guardar los Generos en la base de datos
        em.getTransaction().begin();
        em.persist(g1);
        em.persist(g2);
        em.getTransaction().commit();
        
        
        // Guardar las Listas en la base de datos
        em.getTransaction().begin();
        em.persist(lista1);
        em.persist(lista2);
        em.getTransaction().commit();
        
       // Guardar el Cliente en la base de datos
        em.getTransaction().begin();
        em.persist(cli1);
        em.getTransaction().commit();
      
        // Cierre del EntityManager y EntityManagerFactory (opcional)
        // em.close();
        // emf.close();
    }
}