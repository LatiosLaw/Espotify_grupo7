package logica.controladores;

import java.time.LocalDate;
import java.util.Collection;
import logica.dt.DataArtista;
import logica.dt.DataErrorBundle;
import logica.dt.DataUsuario;

public interface IControladorArtista {

    public DataArtista retornarArtista(String nickname);
    
    public DataUsuario retornarUsuario(String nickname);

    public DataErrorBundle agregarArtista(String nickname, String nombre, String apellido, String contra, String mail, String foto, LocalDate fechaNac, String biografia, String dirWeb);

    public Collection<DataArtista> mostrarArtistas();

    public Collection<String> mostrarNicksArtistas();

    public int obtenerNumeroSeguidores(String nick);

    public Collection<String> obtenerSeguidoresArt(String nick);

    public Collection<String> obtenerAlbumsArt(String nick);
}
