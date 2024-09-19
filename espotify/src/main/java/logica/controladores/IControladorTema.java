package logica.controladores;

import java.util.Collection;
import logica.dt.DataAlbum;
import logica.dt.DataTema;
import logica.dt.errorBundle;

public interface IControladorTema {

    public errorBundle crearTemaDefault(String nombre_tema, int duracion, String metodo_de_acceso, String archivo, String nombre_album);

    boolean crearTemaCompleto(String nombre_tema, int duracion, String metodo_de_acceso, String archivo, Integer posicion, DataAlbum album);
            
    public DataTema retornarTema(String nickname, String nombre_album);
    
    Collection<DataTema> retornarTemasDeLaLista(String nombre_lista, Integer tipo_lista);

    public Collection<DataTema> retornarTemasDeAlbum(String nombre_album);

    public void actualizarTema(DataTema tema, DataAlbum album);

    public void BorrarTema(String nombre_tema, String nombre_album);
    
    public Collection<String> retornarTemasDeAlbumStringEdition(String nombre_album);
}
