package logica.controladores;

import java.time.LocalDate;
import java.util.Collection;
import logica.dt.DataAlbum;
import logica.dt.DataCliente;
import logica.dt.DataListaReproduccion;
import logica.dt.DataTema;
import logica.dt.DataErrorBundle;

public interface IControladorCliente {

    public DataErrorBundle agregarCliente(String nickname, String nombre, String apellido, String mail, String foto, LocalDate fechaNac);

    public void seguirUsuario(String nick1, String nick2);

    public void dejarDeSeguirUsuario(String nick1, String nick2);

    public DataCliente consultarPerfilCliente(String nick_cli);

    public void agregarTema(DataCliente nickcli, DataTema nicktem);

    public void agregarLista(DataCliente nickcli, DataListaReproduccion nomlista);

    public void agregarAlbum(DataCliente nickcli, DataAlbum nomalbum);

    public void eliminarTema(DataCliente nickcli, DataTema nicktem);

    public void eliminarLista(DataCliente nickcli, DataListaReproduccion nomlista);

    public void eliminarAlbum(DataCliente nickcli, DataAlbum nomalbum);

    public void consultarListaReproduccion(String nickname);

    public int obtenerNumeroSeguidores(String nick);

    public Collection<DataCliente> mostrarClientes();

    public Collection<String> obtenerSeguidosUsuario(String nick);

    public Collection<String> obtenerSeguidoresUsuario(String nick);

    public Collection<String> obtenerListasDeUsuario(String nick);

    public Collection<String> obtenerListasFavCliente(String nick);

    public Collection<String> obtenerTemaFavCliente(String nick);

    public Collection<String> obtenerAlbumFavCliente(String nick);

    public Collection<String> mostrarUsuarios();

    public boolean corroborarSiEstaenSeguidos(String nickCliente, String nickSeguido);
}
