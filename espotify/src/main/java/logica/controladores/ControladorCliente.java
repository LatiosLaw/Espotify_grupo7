/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import javax.persistence.PersistenceException;
import logica.Album;
import logica.Artista;
import logica.Cliente;
import logica.ListaParticular;
import logica.ListaPorDefecto;
import logica.ListaReproduccion;
import logica.Tema;
import logica.dt.DataAlbum;
import logica.dt.DataArtista;
import logica.dt.DataCliente;
import logica.dt.DataListaParticular;
import logica.dt.DataListaPorDefecto;
import logica.dt.DataListaReproduccion;
import logica.dt.DataTema;
import logica.dt.DataUsuario;
import persistencia.DAO_Usuario;

/**
 *
 * @author Nico
 */
public class ControladorCliente implements IControladorCliente {

    @Override
    public void agregarCliente(String nickname, String nombre, String apellido, String mail, LocalDate fechaNac) {
        // Verificar si el nickname o el correo electronico ya estan en uso
        DAO_Usuario persistence = new DAO_Usuario();

        if (persistence.findUsuarioByNick(nickname) != null) {
            System.out.println("El nickname: " + nickname + " ya esta en uso. Por favor, elige otro.");
            return;
        }

        if (persistence.findUsuarioByMail(mail) != null) {
            System.out.println("El correo electronico: " + mail + " ya esta en uso. Por favor, elige otro.");
            return;
        }

        // Crear el nuevo cliente
        Cliente nuevoCliente = new Cliente(nickname, nombre, apellido, mail, fechaNac);

        // Guardar el cliente en la base de datos
        try {
            persistence.save(nuevoCliente);
            System.out.println("Cliente agregado exitosamente.");
        } catch (PersistenceException e) {
            System.out.println("Error al guardar el cliente: " + e.getMessage());
            if (e.getCause() instanceof SQLIntegrityConstraintViolationException) {
                System.out.println("El nickname ya esta en uso. Por favor, elige otro.");
            }
        }
    }

    @Override
    public void seguirUsuario(DataCliente nick1, DataUsuario nick2) {
        Cliente cli = new Cliente(nick1.getNickname(), nick1.getNombre(), nick1.getApellido(), nick1.getCorreo(), nick1.getFechaNac());
        DAO_Usuario persistence = new DAO_Usuario();
        if (nick2 instanceof DataCliente) {
            cli.seguir(new Cliente(nick2.getNickname(), nick2.getNombre(), nick2.getApellido(), nick2.getCorreo(), nick2.getFechaNac()));
        } else {
            cli.seguir(new Artista(nick2.getNickname(), nick2.getNombre(), nick2.getApellido(), nick2.getCorreo(), nick2.getFechaNac(), ((DataArtista) nick2).getBiografia(), ((DataArtista) nick2).getDirWeb()));
        }

        persistence.update(cli);
    }

    @Override
    public void dejarDeSeguirUsuario(DataCliente nick1, DataUsuario nick2) {
        Cliente cli = new Cliente(nick1.getNickname(), nick1.getNombre(), nick1.getApellido(), nick1.getCorreo(), nick1.getFechaNac());
        DAO_Usuario persistence = new DAO_Usuario();
        if (nick2 instanceof DataCliente) {
            cli.dejarDeSeguir(new Cliente(nick2.getNickname(), nick2.getNombre(), nick2.getApellido(), nick2.getCorreo(), nick2.getFechaNac()));
        } else if (nick2 instanceof DataArtista) {
            cli.dejarDeSeguir(new Artista(nick2.getNickname(), nick2.getNombre(), nick2.getApellido(), nick2.getCorreo(), nick2.getFechaNac(), ((DataArtista) nick2).getBiografia(), ((DataArtista) nick2).getDirWeb()));
        }
        persistence.update(cli);
    }

    @Override
    public void consultarPerfilCliente() {

    }

    @Override
    public void consultarPerfilArtista() {

    }

    @Override
    public void agregarTema(DataCliente nickcli, DataTema nicktem) {
        Cliente cli = new Cliente(nickcli.getNickname(), nickcli.getNombre(), nickcli.getApellido(), nickcli.getCorreo(), nickcli.getFechaNac());
        DAO_Usuario persistence = new DAO_Usuario();
        Tema tem = new Tema(nicktem.getNickname(), nicktem.getDuracion());
        cli.temaFav(tem);
        persistence.update(cli);
    }

    @Override
    public void agregarLista(DataCliente nickcli, DataListaReproduccion nomlista) {
        Cliente cli = new Cliente(nickcli.getNickname(), nickcli.getNombre(), nickcli.getApellido(), nickcli.getCorreo(), nickcli.getFechaNac());
        DAO_Usuario persistence = new DAO_Usuario();
        if (nomlista instanceof DataListaParticular) {
            ListaReproduccion lis = new ListaParticular(nomlista.getNombre(), ((DataListaParticular) nomlista).getVisibilidad());
            cli.listasFav(lis);
        } else if (nomlista instanceof DataListaPorDefecto) {
            ListaReproduccion lis = new ListaPorDefecto(nomlista.getNombre());
            cli.listasFav(lis);
        }
        persistence.update(cli);
    }

    @Override
    public void agregarAlbum(DataCliente nickcli, DataAlbum nomalbum) {
        Cliente cli = new Cliente(nickcli.getNickname(), nickcli.getNombre(), nickcli.getApellido(), nickcli.getCorreo(), nickcli.getFechaNac());
        DAO_Usuario persistence = new DAO_Usuario();
        Album alb = new Album(nomalbum.getNombre(), nomalbum.getAnioCreacion());
        cli.albumFav(alb);
        persistence.update(cli);
    }

    @Override
    public void eliminarTema(DataCliente nickcli, DataTema nicktem) {
        Cliente cli = new Cliente(nickcli.getNickname(), nickcli.getNombre(), nickcli.getApellido(), nickcli.getCorreo(), nickcli.getFechaNac());
        DAO_Usuario persistence = new DAO_Usuario();
        Tema tem = new Tema(nicktem.getNickname(), nicktem.getDuracion());
        cli.quitarTemaFav(tem);
        persistence.update(cli);
    }

    @Override
    public void eliminarLista(DataCliente nickcli, DataListaReproduccion nomlista) {
        Cliente cli = new Cliente(nickcli.getNickname(), nickcli.getNombre(), nickcli.getApellido(), nickcli.getCorreo(), nickcli.getFechaNac());
        DAO_Usuario persistence = new DAO_Usuario();
        if (nomlista instanceof DataListaParticular) {
            ListaReproduccion lis = new ListaParticular(nomlista.getNombre(), ((DataListaParticular) nomlista).getVisibilidad());
            cli.quitarListasFav(lis);
        } else if (nomlista instanceof DataListaPorDefecto) {
            ListaReproduccion lis = new ListaPorDefecto(nomlista.getNombre());
            cli.quitarListasFav(lis);
        }
        persistence.update(cli);
    }

    @Override
    public void eliminarAlbum(DataCliente nickcli, DataAlbum nomalbum) {
        Cliente cli = new Cliente(nickcli.getNickname(), nickcli.getNombre(), nickcli.getApellido(), nickcli.getCorreo(), nickcli.getFechaNac());
        DAO_Usuario persistence = new DAO_Usuario();
        Album alb = new Album(nomalbum.getNombre(), nomalbum.getAnioCreacion());
        cli.quitarAlbumFav(alb);
        persistence.update(cli);
    }

    @Override
    public void consultarListaReproduccion(String nickname) {

    }
}
