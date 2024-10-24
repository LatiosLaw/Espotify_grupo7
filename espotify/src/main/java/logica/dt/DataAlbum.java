package logica.dt;

import java.util.ArrayList;
import java.util.Collection;

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

    public String getNombre() {
        return nombre;
    }
    
    public DataArtista getCreador() {
        return creador;
    }

    public int getAnioCreacion() {
        return anioCreacion;
    }

    public Collection<DataGenero> getGeneros() {
        return generos;
    }

    public Collection<DataTema> getTemas() {
        return temas;
    }

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

    public void agregarGenero(DataGenero genero) {
        this.generos.add(genero);
    }

    public void agregarTema(DataTema tema) {
        this.temas.add(tema);
    }
}
