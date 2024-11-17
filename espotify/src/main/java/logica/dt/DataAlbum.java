package logica.dt;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.Collection;

@XmlRootElement(name = "DataAlbum")
@XmlType(propOrder = {"nombre", "imagen", "anioCreacion", "creador", "generos", "temas"})
public class DataAlbum {

    private String nombre;
    private String imagen;
    private int anioCreacion;
    private DataArtista creador;
    private Collection<DataGenero> generos = new ArrayList<>();
    private Collection<DataTema> temas = new ArrayList<>();

    public DataAlbum(String nombre, String imagen, int anioCreacion, DataArtista creador, Collection<DataGenero> generos) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.anioCreacion = anioCreacion;
        this.creador = creador;
        this.generos = generos;
        this.temas = new ArrayList<>();
    }

    public DataAlbum(String nombre, String imagen, int anioCreacion, DataArtista creador) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.anioCreacion = anioCreacion;
        this.creador = creador;
        this.generos = generos;
        this.temas = new ArrayList<>();
    }

    public DataAlbum() {
        this.setNombre(new String());
        this.setAnioCreacion(0);
        this.creador = new DataArtista();
        this.agregarGenero(new DataGenero());
        this.agregarTema(new DataTema());
    }

    public DataAlbum(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    @XmlElement(name = "creador")
    public DataArtista getCreador() {
        return creador;
    }

    @XmlElement(name = "anioCreacion")
    public int getAnioCreacion() {
        return anioCreacion;
    }

    @XmlElement(name = "generos")
    public Collection<DataGenero> getGeneros() {
        return generos;
    }

    @XmlElement(name = "temas")
    public Collection<DataTema> getTemas() {
        return temas;
    }

    @XmlElement(name = "imagen")
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAnioCreacion(int anioCreacion) {
        this.anioCreacion = anioCreacion;
    }

    public void setCreador(DataArtista creador) {
        this.creador = creador;
    }

    public void agregarGenero(DataGenero genero) {
        this.generos.add(genero);
    }

    public void agregarTema(DataTema tema) {
        this.temas.add(tema);
    }
}
