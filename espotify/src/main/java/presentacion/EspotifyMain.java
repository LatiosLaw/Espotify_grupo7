/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package presentacion;

/**
 *
 * @author Law
 */

import logica.controladores.ControladorAlbum;
import logica.controladores.ControladorArtista;
import logica.controladores.ControladorCliente;
import logica.controladores.ControladorGenero;
import logica.controladores.ControladorListaParticular;
import logica.controladores.ControladorListaPorDefecto;
import logica.controladores.ControladorTema;
import logica.controladores.IControladorAlbum;
import logica.controladores.IControladorArtista;
import logica.controladores.IControladorCliente;
import logica.controladores.IControladorGenero;
import logica.controladores.IControladorListaParticular;
import logica.controladores.IControladorListaPorDefecto;
import logica.controladores.IControladorTema;

public class EspotifyMain {

    public static void main(String[] args) {
        
        IControladorArtista artHandler = new ControladorArtista();
        IControladorCliente cliHandler = new ControladorCliente();
        IControladorAlbum albHandler = new ControladorAlbum();
        IControladorGenero genHandler = new ControladorGenero();
        IControladorListaPorDefecto listHandler = new ControladorListaPorDefecto();
        IControladorListaParticular listPHandler = new ControladorListaParticular();
        IControladorTema temHandler = new ControladorTema();
        
         // Iniciar el formulario
        FormPrin fp = new FormPrin(cliHandler,artHandler, albHandler, genHandler, temHandler);
        fp.setVisible(true);
    /*   // Crear el EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("espotifyPU"); // Asegúrate de que "espotifyPU" coincida con tu archivo persistence.xml

        // Crear el EntityManager
        EntityManager em = emf.createEntityManager();
        
        artHandler.agregarArtista("Pepe122", "Pepe", "Cuenca", "pepe@gmail.com", LocalDate.of(2024,5,2), "Me gusta tocar la viola", "pepito.com");
        artHandler.agregarArtista("joselito", "Pepe", "Cuenca", "pepe@gmail.com", LocalDate.of(2024,5,2), "Me gusta tocar la viola", "pepito.com");
        cliHandler.agregarCliente("mario34", "Mario", "Fuentes", "mariofuentes@gmail.com", LocalDate.of(2002, 3, 1));
       /* 
        
        // Crear un nuevo Artista
        Artista art1 = new Artista("nickname", "Nombre", "Apellido", "email@example.com", "sampleimage", LocalDate.of(2005, 5, 11), "Biografía del artista", "http://example.com");
        Cliente cli1 = new Cliente("pepe12", "Pepe", "Suarez", "example@yourmother.com", "sampleimage2", LocalDate.of(2003, 2, 12));
        DataCliente dcli1 = new DataCliente("pepe12", "Pepe", "Suarez", "example@yourmother.com", "sampleimage3", LocalDate.of(2003, 2, 12));
        DataCliente cli2 = new DataCliente("law", "Martin", "Mainentti", "testin@yourmother.com", "staringatyoursoul", LocalDate.of(2004, 11, 27));
        DataTema tem1 = new DataTema("Midnight Mayoi", 20);
        Tema tem2 = new Tema("Despacito", 50);
        Tema tem3 = new Tema("Velociraptor", 34);
        DataTema tem4 = new DataTema("DONMAI", 25);
        DataTema tem5 = new DataTema("GIVE UP 今世 壊", 30);
        Album alb1 = new Album("Wachiturros2", 2020);
        Genero g1 = new Genero("Tango");
        Genero g2 = new Genero("Cumbia");
        DataGenero g3 = new DataGenero("JPop");
        DataGenero g4 = new DataGenero(g1.getNombre());
        ListaPorDefecto lista1 = new ListaPorDefecto("Canciones Epicas", g1);
        ListaParticular lista2 = new ListaParticular("Mis canciones nostalgicas", false, cli1);
        
        cliHandler.agregarTema(cli2, tem5);
        
        // Guardar los Generos en la base de datos
        em.getTransaction().begin();
        em.persist(g1);
        em.persist(g2);
        em.getTransaction().commit();
        
        //cli1.TemaFav(tem1);
        //cli1.Seguir(art1);
        //cli1.AlbumFav(alb1);
        //cli1.ListasFav(lista1);
        //alb1.agregarGenero(g2);
        //g1.agregarSubgenero(g2);
        
        // Guardar el Artista en la base de datos
        em.getTransaction().begin();
        em.persist(art1);
        em.getTransaction().commit();
        
        // Guardar el Tema en la base de datos
      //  em.getTransaction().begin();
       // em.persist(tem1);
       // em.persist(tem2);
       // em.persist(tem3);
       // em.getTransaction().commit();
        
      //  alb1.agregarTema(tem1);
        //alb1.agregarTema(tem2);
        //alb1.agregarTema(tem3);
        
        // Guardar el Album en la base de datos
        em.getTransaction().begin();
        em.persist(alb1);
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
        
        
        listHandler.crearLista("Primera lista", g4);
        listPHandler.crearLista("Lista exitos 2022", dcli1);
        
        // PRUEBA DE FUNCIONAMIENTO DE ALTA ALBUM
        DataArtista art11 = new DataArtista("CalliopeMori", "Karen", "Idk", "moricalliope.hololive@gmail.com", "https://static.zerochan.net/Mori.Calliope.full.3070887.jpg", LocalDate.of(1996, 5, 30), "Nada", "Nada");
        IControladorAlbum manejador_album = new ControladorAlbum();
        Collection<DataGenero> g = new ArrayList<>();
        g.add(g3);
        Collection<DataTema> t = new ArrayList<>();
        t.add(tem1);
        t.add(tem4);
        DataAlbum retorno = manejador_album.agregarAlbum(art11, "Phantomime", "https://i.scdn.co/image/ab67616d0000b2734decfba07e62fcd26eaedc6c", 2024, g, t);
        if (retorno != null) {
            IControladorTema manejador_tema = new ControladorTema();
            manejador_tema.crearTemaDefault("Last Days", 30);
            DataTema tema_a_actualizar;
            tema_a_actualizar = manejador_tema.retornarTema("Last Days");
            if (tema_a_actualizar != null) {
                manejador_tema.actualizarTema(tema_a_actualizar, retorno);
            }
        }
        /////////////////////////////////////////
        //em.getTransaction().begin();
        //em.persist(cli1);
        // em.getTransaction().commit();
        // Cierre del EntityManager y EntityManagerFactory (opcional)
        // em.close();
        // emf.close();
        
        
        // Llamar al método
        DataListaParticular dataLista = listPHandler.devolverInformacion("Lista exitos 2022", cli1.getNickname());
       
        
        
        //PRUEBA CONSULTA DE LISTA PARTICULAR
        
        // Lista particular
        if (dataLista != null) {
            System.out.println("Nombre de la lista: " + dataLista.getNombre());
            System.out.println("Visibilidad: " + dataLista.getVisibilidad());
            DataCliente dataCliente = dataLista.getDataCliente(); // Obtener el DataCliente

            System.out.println("Cliente:");
            System.out.println("  Nickname: " + dataCliente.getNickname());
            System.out.println("  Nombre: " + dataCliente.getNombre());
            System.out.println("  Apellido: " + dataCliente.getApellido());
            System.out.println("  Email: " + dataCliente.getCorreo());
            System.out.println("  Fecha de Nacimiento: " + dataCliente.getFechaNac());
        } else {
            System.out.println("No se encontro la lista para el cliente: " + cli1.getNickname());
        }
        
         DataListaPorDefecto dataLista2 = listHandler.devolverInformacion("Primera lista", g4.getNombre());
        
         // Lista por defecto
        if (dataLista2 != null) {
            System.out.println("Nombre de la lista: " + dataLista2.getNombre());
            DataGenero dataGenero = dataLista2.getGenero(); // Obtener el DataCliente
            System.out.println("Genero: " + dataGenero.getNombre());
        } else {
            System.out.println("No se encontro la lista.");
        }  

        */
    }
}
