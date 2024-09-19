package logica.controladores;

import java.util.Collection;
import logica.dt.DataAlbum;
import logica.dt.DataTema;

public interface IControladorTema {

    public boolean crearTemaDefault(String nombre_tema, int duracion, String metodo_de_acceso);

    public DataTema retornarTema(String nickname);

    public Collection<DataTema> retornarTemasDeAlbum(String nombre_album);

    public void actualizarTema(DataTema tema, DataAlbum album);

    public void BorrarTema(String nombre_tema);
    
    public Collection<String> retornarTemasDeAlbumStringEdition(String nombre_album);
}
