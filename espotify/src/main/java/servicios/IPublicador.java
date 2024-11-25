package servicios;

import java.util.Collection;
import javax.jws.WebMethod;
import javax.jws.WebService;
import logica.Registro_tema;
import logica.dt.DT_IdTema;
import logica.dt.DataAlbum;
import logica.dt.DataArtista;
import logica.dt.DataCliente;
import logica.dt.DataErrorBundle;
import logica.dt.DataGenero;
import logica.dt.DataListaParticular;
import logica.dt.DataListaPorDefecto;
import logica.dt.DataListaReproduccion;
import logica.dt.DataSus;
import logica.dt.DataTema;
import logica.dt.DataUsuario;

@WebService(targetNamespace = "http://servicios/")
public interface IPublicador {

    @WebMethod
    public DataErrorBundle iniciarSesion(String username, String password);

    @WebMethod
    public String getTipoUsuario(String username);

    @WebMethod
    public Boolean getSuscripcion(String username);

    @WebMethod
    public Boolean seguirUsuario(String username1, String username2);

    @WebMethod
    public Boolean dejarDeSeguirUsuario(String username1, String username2);

    @WebMethod
    public Collection<String> obtenerSeguidoresDe(String username);

    @WebMethod
    public Collection<String> obtenerSeguidosDe(String username);

    @WebMethod
    public DataErrorBundle agregarSuscripcion(String username, String estado, String tipo);

    @WebMethod
    public DataCliente retornarCliente(String username);

    @WebMethod
    public DataUsuario retornarUsuario(String username);

    @WebMethod
    public Collection<DataListaParticular> retornarListasParticularesDeCliente(String username);

    @WebMethod
    public Boolean publicarLista(String nicknameCliente, String nombreLista);

    @WebMethod
    public DataErrorBundle agregarCliente(String nickname, String nombre, String apellido, String pass, String mail, String fileName, String fechaNac);

    @WebMethod
    public DataErrorBundle agregarArtista(String nickname, String nombre, String apellido, String pass, String mail, String fileName, String fechaNac, String biografia, String dirWeb);

    @WebMethod
    public Boolean checkNicknameAvailability(String nickname);

    @WebMethod
    public Boolean checkUCorreoAvailability(String correo);

    @WebMethod
    public Boolean checkAlbumAvailability(String nombreAlbum);

    @WebMethod
    public DataAlbum agregarAlbum(String nickname, String nombreAlbum, String fileName, int anioCreacion, Collection<DataTema> temas);

    @WebMethod
    public DataTema retornarTema(String nombreTema, String nombreAlbum);
    
    @WebMethod
    public DataTema retornarTema2(String nombreTema, String nombreAlbum);

    @WebMethod
    public void actualizarTema(DataTema tema, DataAlbum album);

    @WebMethod
    public void actualizarGenero(DataGenero genero, Collection<String> albumes, DataAlbum album);

    @WebMethod
    public void crearTemaCasiCompleto(String nombre_tema, String nombre_album, int duracion, String metodo_de_acceso, String archivo, Integer posicion);

    @WebMethod
    public Collection<String> retornarAlbumesDelGenero(String nombreGenero);

    @WebMethod
    public Collection<String> obtenerGeneros();

    @WebMethod
    public Collection<DataCliente> obtenerDataClientes();

    @WebMethod
    public Collection<DataArtista> obtenerDataArtistas();
    
    @WebMethod
    public Collection<DataListaPorDefecto> obtenerDataListaPorDefecto();
    
    @WebMethod
    public Collection<DataListaPorDefecto> obtenerDataListasPorGenero(String nombreGenero);
    
    @WebMethod
    public Collection<DataAlbum> obtenerDataAlbumesPorGenero(String nombreGenero);
    
    @WebMethod
    public Collection<DataSus> obtenerDataSuscripciones(String username);
    
    @WebMethod
    public DataSus obtenerDataSuscripcionPorID(Integer identificador);
    
    @WebMethod
    public void actualizarSuscripcion(Integer identificador, String estadoSuscripcion);
    
    @WebMethod
    public Collection<DataAlbum> obtenerDataAlbumes();
    
    @WebMethod
    public DataAlbum obtenerDataAlbum(String nombreAlbum);
    
    @WebMethod
    public Collection<String> obtenerNombreAlbumesFavCliente(String username);
    
    @WebMethod
    public String corroborarAlbumEnFav(String nombreAlbum, Collection<String> albumes);
    
    @WebMethod
    public void eliminarAlbumDeFav(DataCliente cliente, DataAlbum album);
    
    @WebMethod
    public Collection<String> obtenerNombreTemasFavCliente(String username);   
    
    @WebMethod
    public String corroborarTemaEnFav(String nombreTema, Collection<String> temas);
    
    @WebMethod
    public void eliminarTemaDeFav(DataCliente cliente, DataTema tema);
    
    @WebMethod
    public Collection<String> obtenerNombreListasFavCliente(String username);
    
    @WebMethod
    public String corroborarListaEnFav(String nombreLista, String nombreUsuario, Collection<String> listasCole);
    
    @WebMethod
    public DataListaReproduccion devolverInformacionListaRepro(String idCoso, String idCreadorAlbum);
    
    @WebMethod
    public void eliminarListaDeFav(DataCliente cliente, DataListaReproduccion lista);
    
    @WebMethod
    public void agregarTemaEnFav(DataCliente cliente, DataTema tema);
    
    @WebMethod
    public void agregarListaEnFav(DataCliente cliente, DataListaReproduccion lista);
    
    @WebMethod
    public void agregarAlbumEnFav(DataCliente cliente, DataAlbum album);
    
    @WebMethod
    public DataListaPorDefecto retornarDataListaPorDefecto2(String nombreLista);
    
    @WebMethod
    public DataListaParticular retornarDataListaParticular(String nombreLista, String nombreCreador);
    
    @WebMethod
    public void agregarTemaALista(String nickname, String nombreLista, DataTema temazo);
       
    @WebMethod
    public Collection<DataListaParticular> obtenerDataListaParticualaresPublicas();
    
    @WebMethod
    public Collection<DataTema> obtenerTemasDeListas(String nombreLista, Integer tipoLista);
    
    @WebMethod
    public Collection<DataTema> obtenerTemasDeAlbumes(String nombreAlbum);
    
    @WebMethod
    public void hiroshimaYNagasaki();
    
    @WebMethod
    public void agregarRegistro(String nickname, String os, String navegador, String ip, String url);
    
    @WebMethod
    public void crearListaParticular(String nombreLista, DataCliente cliente);
    
    @WebMethod
    public void actualizarListaParticular(DataListaParticular lista);
    
    @WebMethod
    public Boolean checkSiEsGenero(String nombreGenero);
    
    @WebMethod
    public Registro_tema devolverRegistroTema(String nombreTema, String albumName);
    
    @WebMethod
    public Collection<Registro_tema> obtenerLos100MasPopulares();
    
    @WebMethod
    public void eliminarArtista(String nickname);
    
    @WebMethod
    public Collection<DataListaPorDefecto> obtenerDataListaPorDefectoPorParecido(String busqueda);
    
    @WebMethod
    public Collection<DataListaParticular> obtenerDataListaParticularPorParecido(String busqueda);
    
    @WebMethod
    public Collection<DataAlbum> obtenerDataAlbumPorParecido(String busqueda);
    
    @WebMethod
    public Collection<DataTema> obtenerDataTemaPorParecido(String busqueda);
    
    @WebMethod
    public Collection<String> obtenerSeguidoresDeUsuario(String nickname);
    
    @WebMethod
    public Collection<String> obtenerSeguidosDeUsuario(String nickname);
      
    @WebMethod
    public Collection<DataAlbum> obtenerDataAlbumesDeArtista(String nickname);
    
    @WebMethod
    public Collection<DataListaParticular> obtenerDataListasDeClientes(String nickname);
    
    @WebMethod
    public Collection<DataAlbum> obtenerDataAlbumesFavoritos(String nickname);
    
    @WebMethod
    public Collection<DataListaParticular> obtenerDataListasParticularesFavoritas(String nickname);
    
    @WebMethod
    public Collection<DataListaPorDefecto> obtenerDataListasPorDefectoFavoritas(String nickname);
    
    @WebMethod
    public Collection<DT_IdTema> obtenerDataIdTemasFavoritos(String nickname);
    
    @WebMethod
    public void incrementarInfoDescarga(String nombreTema, String nombreAlbum);
    
    @WebMethod
    public void incrementarInfoReproduccion(String nombreTema, String nombreAlbum);
    
}
