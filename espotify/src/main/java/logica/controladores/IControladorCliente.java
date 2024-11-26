package logica.controladores;

import java.time.LocalDate;
import java.util.Collection;
import logica.dt.DT_IdTema;
import logica.dt.DataAlbum;
import logica.dt.DataCliente;
import logica.dt.DataListaReproduccion;
import logica.dt.DataTema;
import logica.dt.DataErrorBundle;
import logica.dt.DataListaParticular;
import logica.dt.DataListaPorDefecto;
import logica.dt.DataRegi;
import logica.dt.DataSus;
import logica.dt.DataUsuario;

public interface IControladorCliente {

    public DataErrorBundle agregarCliente(String nickname, String nombre, String apellido, String contra, String mail, String foto, LocalDate fechaNac);

    public void seguirUsuario(String nick1, String nick2);

    public void dejarDeSeguirUsuario(String nick1, String nick2);

    public boolean seguirUsuarioWeb(String nick1, String nick2);

    public boolean dejarDeSeguirUsuarioWeb(String nick1, String nick2);

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

    public DataErrorBundle iniciarSesion(String nickOmail, String pass);

    public boolean corroborarSiEstaenSeguidos(String nickCliente, String nickSeguido);

    public DataSus devolverSus(String nick);

    public String corroborarTemaEnFav(String nombreTema, Collection<String> temasCole);

    public String corroborarAlbumEnFav(String nombreAlbum, Collection<String> albumsCole);

    public String corroborarListaEnFav(String nombreLista, String nombreUsuario, Collection<String> listasCole);

    public void agregarRegistro(String nick, String os, String nave, String ip, String url);

    public Collection<DataRegi> retornarRegistros();

    public void nukearAlosViejos();

    public void controlDePoblacion();

    public void hiroshimaYnagasaki();

    public void eliminarTemaDeTodos(DataTema nicktem);

    public void eliminarAlbumDeTodos(DataAlbum nomalbum);

    public void eliminarAlbum2(DataCliente nickcli, DataAlbum nomalbum);

    public void eliminarDeTodosAlrtista(String nickArt);

    public Collection<DataAlbum> obtenerDataAlbumesFavoritos(String nickname);

    public Collection<DataListaParticular> obtenerDataListasDeClientes(String nickname);
    
    public Collection<DataListaParticular> obtenerDataListasParticularesFavoritas(String nickname);
    
    public Collection<DataListaPorDefecto> obtenerDataListasPorDefectoFavoritas(String nickname);
    
    public Collection<DT_IdTema> obtenerDataIdTemasFavoritos(String nickname);

    public Collection<DataUsuario> listarUsuariosPorFama();
    
     public void mailMomento(IControladorSuscripcion controlSus, String nick, int idSus);

}
