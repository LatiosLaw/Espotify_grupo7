/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.persistence.PersistenceException;
import logica.Album;
import logica.Artista;
import logica.Cliente;
import logica.ListaParticular;
import logica.ListaPorDefecto;
import logica.ListaReproduccion;
import logica.tema;
import logica.Usuario;
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
    public void agregarCliente(String nickname, String nombre, String apellido, String mail, String foto, LocalDate fechaNac) {
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
        Cliente nuevoCliente = new Cliente(nickname, nombre, apellido, mail, foto, fechaNac);

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
    public void seguirUsuario(String nick1, String nick2) {
        DAO_Usuario persistence = new DAO_Usuario();

        // Obtener Usuario usando nick1
        Usuario usuarioBase = persistence.findUsuarioByNick(nick1);
        if (usuarioBase == null) {
            throw new IllegalArgumentException("Cliente no encontrado.");
        }

        // Hacer el cast a Cliente
        if (!(usuarioBase instanceof Cliente cliente)) {
            throw new IllegalArgumentException("El usuario encontrado no es un cliente.");
        }

        Usuario usuario = persistence.findUsuarioByNick(nick2);
        if (usuario == null) {
            throw new IllegalArgumentException("Usuario a seguir no encontrado.");
        }

        if (usuario instanceof Cliente dataCliente) {
            cliente.seguir(new Cliente(dataCliente.getNickname(), dataCliente.getNombre(), dataCliente.getApellido(), dataCliente.getEmail(), dataCliente.getFoto(), dataCliente.getNacimiento()));
        } else if (usuario instanceof Artista dataArtista) {
            cliente.seguir(new Artista(dataArtista.getNickname(), dataArtista.getNombre(), dataArtista.getApellido(), dataArtista.getEmail(), dataArtista.getFoto(), dataArtista.getNacimiento(), dataArtista.getBiografia(), dataArtista.getDirWeb()));
        } else {
            // Manejar el caso donde usuario no es ni un DataCliente ni un DataArtista
            throw new IllegalArgumentException("El usuario a seguir no es ni un cliente ni un artista.");
        }

        persistence.update(cliente);
    }

    @Override
    public void dejarDeSeguirUsuario(String nick1, String nick2) {
        DAO_Usuario persistence = new DAO_Usuario();

        // Obtener Usuario usando nick1
        Usuario usuarioBase = persistence.findUsuarioByNick(nick1);
        if (usuarioBase == null) {
            throw new IllegalArgumentException("Cliente no encontrado.");
        }

        // Hacer el cast a Cliente
        if (!(usuarioBase instanceof Cliente cliente)) {
            throw new IllegalArgumentException("El usuario encontrado no es un cliente.");
        }

        Usuario usuario = persistence.findUsuarioByNick(nick2);
        if (usuario == null) {
            throw new IllegalArgumentException("Usuario a dejar de seguir no encontrado.");
        }
        
        cliente.dejarDeSeguir(usuario);
 
        // Actualizar la tabla
        persistence.update(cliente);
    }

@Override
public DataCliente consultarPerfilCliente(String nick_cli) {
    Usuario retorno;
    DAO_Usuario persistence = new DAO_Usuario();
    
    try {
        retorno = persistence.findUsuarioByNick(nick_cli);
        if (retorno != null && retorno instanceof Cliente cliente) {
            return new DataCliente(
                retorno.getNickname(),
                retorno.getNombre(),
                retorno.getApellido(),
                retorno.getFoto(),
                retorno.getEmail(),
                retorno.getNacimiento()
            );
        } else {
            System.out.println("El usuario con nickname " + nick_cli + " no es un Cliente.");
            return null;
        }
    } catch (Exception e) {
        System.err.println("Error al buscar el cliente: " + e.getMessage());
        return null;
    }
}

    @Override
    public void agregarTema(DataCliente nickcli, DataTema nicktem) {
        Cliente cli = new Cliente(nickcli.getNickname(), nickcli.getNombre(), nickcli.getApellido(), nickcli.getCorreo(), nickcli.getFoto(), nickcli.getFechaNac());
        DAO_Usuario persistence = new DAO_Usuario();
        tema tem = new tema(nicktem.getNickname(), nicktem.getDuracion());
        cli.temaFav(tem);
        persistence.update(cli);
    }

    @Override
    public void agregarLista(DataCliente nickcli, DataListaReproduccion nomlista) {
        Cliente cli = new Cliente(nickcli.getNickname(), nickcli.getNombre(), nickcli.getApellido(), nickcli.getCorreo(), nickcli.getFoto(), nickcli.getFechaNac());
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
        Cliente cli = new Cliente(nickcli.getNickname(), nickcli.getNombre(), nickcli.getApellido(), nickcli.getCorreo(), nickcli.getFoto(), nickcli.getFechaNac());
        DAO_Usuario persistence = new DAO_Usuario();
        Album alb = new Album(nomalbum.getNombre(), nomalbum.getAnioCreacion());
        cli.albumFav(alb);
        persistence.update(cli);
    }

    @Override
    public void eliminarTema(DataCliente nickcli, DataTema nicktem) {
        Cliente cli = new Cliente(nickcli.getNickname(), nickcli.getNombre(), nickcli.getApellido(), nickcli.getCorreo(), nickcli.getFoto(), nickcli.getFechaNac());
        DAO_Usuario persistence = new DAO_Usuario();
        tema tem = new tema(nicktem.getNickname(), nicktem.getDuracion());
        cli.quitarTemaFav(tem);
        persistence.update(cli);
    }

    @Override
    public void eliminarLista(DataCliente nickcli, DataListaReproduccion nomlista) {
        Cliente cli = new Cliente(nickcli.getNickname(), nickcli.getNombre(), nickcli.getApellido(), nickcli.getCorreo(), nickcli.getFoto(), nickcli.getFechaNac());
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
        Cliente cli = new Cliente(nickcli.getNickname(), nickcli.getNombre(), nickcli.getApellido(), nickcli.getCorreo(), nickcli.getFoto(), nickcli.getFechaNac());
        DAO_Usuario persistence = new DAO_Usuario();
        Album alb = new Album(nomalbum.getNombre(), nomalbum.getAnioCreacion());
        cli.quitarAlbumFav(alb);
        persistence.update(cli);
    }

    @Override
    public void consultarListaReproduccion(String nickname) {

    }
    
    @Override
    public int obtenerNumeroSeguidores(String nick){
        DAO_Usuario dao = new DAO_Usuario();
        return dao.obtenerCantidadSeguidores(nick);
    }
    @Override
    public Collection<String> obtenerSeguidoresUsuario(String nick){
        DAO_Usuario dao = new DAO_Usuario();
        return dao.obtenerSeguidoresDeUsuario(nick);
    }
     @Override
    public Collection<String> obtenerSeguidosUsuario(String nick){
        DAO_Usuario dao = new DAO_Usuario();
        return dao.obtenerSeguidosDeUsuario(nick);
    }
     @Override
    public Collection<String> obtenerListasDeUsuario(String nick){
        DAO_Usuario dao = new DAO_Usuario();
        return dao.obtenerListasDeUsuario(nick);
    }
    @Override
    public Collection<DataCliente> mostrarClientes(){
        Collection<DataCliente> lista = new ArrayList<>();
        DAO_Usuario persistence = new DAO_Usuario();
        Collection<Usuario> cliente = persistence.findAll();
        Iterator<Usuario> iterator = cliente.iterator();
        while (iterator.hasNext()) {
            Usuario usr = iterator.next();
            if(usr instanceof Cliente cli){
              lista.add(new DataCliente(cli.getNickname(),cli.getNombre(),cli.getApellido(), cli.getEmail(), cli.getFoto(), cli.getNacimiento()));
            }
        }       
        return lista;
    }
     @Override
    public Collection<String> obtenerListasFavCliente(String nick){
        DAO_Usuario dao = new DAO_Usuario();
        return dao.obtenerListasFavCliente(nick);
    }
     @Override
    public Collection<String> obtenerTemaFavCliente(String nick){
        DAO_Usuario dao = new DAO_Usuario();
        return dao.obtenerTemaFavCliente(nick);
    }
     @Override
    public Collection<String> obtenerAlbumFavCliente(String nick){
        DAO_Usuario dao = new DAO_Usuario();
        return dao.obtenerAlbumFavCliente(nick);
    }
     @Override
    public Collection<String> mostrarUsuarios(){
        Collection<String> lista = new ArrayList<>();
        DAO_Usuario persistence = new DAO_Usuario();
        Collection<Usuario> usuario = persistence.findAll();
        Iterator<Usuario> iterator = usuario.iterator();
        while (iterator.hasNext()) {
            Usuario usr = iterator.next();
              lista.add(usr.getNickname());
        }       
        return lista;
        
    }
    
    @Override
    public boolean corroborarSiEstaenSeguidos(String nickCliente, String nickSeguido){
         DAO_Usuario persistence = new DAO_Usuario();
        Collection<String> cole = persistence.obtenerSeguidosDeUsuario(nickCliente);
        boolean token = false;
         for (String elemento : cole) {
            String nick = elemento;
            System.out.println("Nick dentro de la lista: " +nick);
            if(nick.equals(nickSeguido)){
                System.out.println("Ah jah!");
                token = true;
                break;
            }
        }
        
        return token;
    }
    
    
    
    
    
    
}

