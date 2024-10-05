package logica.controladores;

import java.util.Collection;
import logica.dt.DataAlbum;
import logica.dt.DataGenero;

public interface IControladorGenero {

    public void crearGeneroUnico(String nombre);

    public boolean crearGeneroConSubgeneros(String nombre, Collection<String> genero_padre);

    public Collection<String> mostrarGeneros();

    public Collection<DataGenero> darGenerosDelAlbum(String nombre_album);

    public void actualizarGenero(DataGenero genero, Collection<String> albumes_previos_del_genero, DataAlbum album);
}
