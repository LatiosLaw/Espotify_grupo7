package logica.controladores;

import java.util.Collection;
import logica.dt.DataAlbum;
import logica.dt.DataGenero;
import logica.dt.DataTema;

public interface IControladorAlbum {

    public DataAlbum agregarAlbum(String artista, String nombAlbum, String imagen, int anioCreacion, Collection<DataTema> temas);

    public Collection<String> retornarAlbumsDelGenero(String genero);

    public Collection<String> retornarAlbumsDelArtista(String nick_arti);

    public DataAlbum retornarInfoAlbum(String nombre_album);
    
    public Collection<String> retornarAlbumsString();
    
    public void actualizarAlbum(DataAlbum dataAlbum, Collection<DataGenero> nuevosGeneros);
}
