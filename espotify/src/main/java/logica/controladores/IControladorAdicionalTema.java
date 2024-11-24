package logica.controladores;

import java.util.Collection;
import logica.Registro_tema;

public interface IControladorAdicionalTema {

    public void crearRegistroTema(String nombre_tema, String nombre_album_tema);

    public Registro_tema devolverRegistroTema(String nombre_tema, String nombre_album_tema);

    public void incrementarInfoReproduccion(String nombre_tema, String nombre_album);

    public void incrementarInfoAgregadoALista(String nombre_tema, String nombre_album);

    public void incrementarInfoFavorito(String nombre_tema, String nombre_album);

    public void incrementarInfoDescarga(String nombre_tema, String nombre_album);

    public void reducirInfoReproduccion(String nombre_tema, String nombre_album);

    public void reducirInfoAgregadoALista(String nombre_tema, String nombre_album);

    public void reducirInfoFavorito(String nombre_tema, String nombre_album);

    public void reducirInfoDescarga(String nombre_tema, String nombre_album);

    public Collection<Registro_tema> buscarLos100MasPopulares();
}
