package logica.controladores;

import java.util.Collection;
import logica.AlbumEliminados;
import logica.dt.DataAlbum;
import logica.dt.DataTema;

public interface IControladorTema {

    public boolean crearTemaDefault(String nombre_tema, String nombre_album, int duracion, String metodo_de_acceso, String archivo);

    boolean crearTemaCompleto(String nombre_tema, String nombre_album, int duracion, String metodo_de_acceso, String archivo, Integer posicion, DataAlbum album);

    boolean crearTemaCasiCompleto(String nombre_tema, String nombre_album, int duracion, String metodo_de_acceso, String archivo, Integer posicion);

    public DataTema retornarTema(String nickname, String nombre_album);

    Collection<DataTema> retornarTemasDeLaLista(String nombre_lista, Integer tipo_lista);

    public Collection<DataTema> retornarTemasDeAlbum(String nombre_album);

    public void actualizarTema(DataTema tema, DataAlbum album);

    public void BorrarTema(String nickname, String nombre_album);

    public Collection<String> retornarTemasDeAlbumStringEdition(String nombre_album);

    public DataTema retornarTema2LaSecuela(String nickname, String nombre_album);

    public void elminiarDelMapaTemas(String albu, ControladorCliente controlCli, ControladorListaParticular controlLipa, ControladorListaPorDefecto controlLipo);

    public void agregarTemaAeliminados(AlbumEliminados albEli);

    public Collection<DataTema> retornarDataTemasParecidosA(String busqueda);
}
