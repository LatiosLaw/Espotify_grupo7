package logica.dt;

import java.util.ArrayList;
import java.util.Collection;
import java.time.LocalDate;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "DataCliente") // Define el elemento raíz en el XML
@XmlType(propOrder = {"seguidos", "temasFavoritos", "albumesFavoritos", "listasFavoritas"}) // Define el orden de los elementos
public class DataCliente extends DataUsuario {

    private Collection<DataUsuario> seguidos;
    private Collection<DataTema> temasFavoritos;
    private Collection<DataAlbum> albumesFavoritos;
    private Collection<DataListaReproduccion> listasFavoritas;

    public DataCliente() {
        // Constructor por defecto requerido por JAXB
    }

    public DataCliente(String nickname, String nombre, String apellido, String contraseña, String correo, String foto_perfil, LocalDate fechaNac) {
        super(nickname, nombre, apellido, contraseña, correo, foto_perfil, fechaNac);
        this.seguidos = new ArrayList<>();
        this.temasFavoritos = new ArrayList<>();
        this.albumesFavoritos = new ArrayList<>();
        this.listasFavoritas = new ArrayList<>();
    }
    
    public DataCliente(String nombre) {
        super(nombre);
    }

    @XmlElement(name = "seguidos") // Mapea la colección a un elemento XML
    public Collection<DataUsuario> getSeguidos() {
        return seguidos;
    }

    @XmlElement(name = "temasFavoritos") // Mapea la colección a un elemento XML
    public Collection<DataTema> getTemasFavoritos() {
        return temasFavoritos;
    }

    @XmlElement(name = "albumesFavoritos") // Mapea la colección a un elemento XML
    public Collection<DataAlbum> getAlbumesFavoritos() {
        return albumesFavoritos;
    }

    @XmlElement(name = "listasFavoritas") // Mapea la colección a un elemento XML
    public Collection<DataListaReproduccion> getListasFavoritas() {
        return listasFavoritas;
    }

    public void seguir(DataUsuario usuario) {
        this.seguidos.add(usuario);
    }

    public void dejarDeSeguir(DataUsuario usuario) {
        this.seguidos.remove(usuario);
    }

    public void agregarTemaFavorito(DataTema tema) {
        this.temasFavoritos.add(tema);
    }

    public void agregarAlbumFavorito(DataAlbum album) {
        this.albumesFavoritos.add(album);
    }

    public void agregarListaFavorita(DataListaReproduccion lista) {
        this.listasFavoritas.add(lista);
    }

    public void quitarTemaFavorito(DataTema tema) {
        this.temasFavoritos.remove(tema);
    }

    public void quitarAlbumFavorito(DataAlbum album) {
        this.albumesFavoritos.remove(album);
    }

    public void quitarListaFavorita(DataListaReproduccion lista) {
        this.listasFavoritas.remove(lista);
    }

    @Override
    public String toString() {
        return "DataCliente{"
                + "seguido=" + seguidos
                + ", temasFavoritos=" + temasFavoritos
                + ", albumesFavoritos=" + albumesFavoritos
                + ", listasFavoritas=" + listasFavoritas
                + "} " + super.toString();
    }
}
