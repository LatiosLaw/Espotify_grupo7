package logica.dt;

import java.util.ArrayList;
import java.util.Collection;

public class DataAlbum {
    private String nombre;
    private int anioCreacion;
    private DataArtista creador; 
    private Collection<DataGenero> generos;
    private Collection<DataTema> temas;

    public DataAlbum(String nombre, int anioCreacion, DataArtista creador) {
        this.nombre = nombre;
        this.anioCreacion = anioCreacion;
        this.creador = creador;
        this.generos = new ArrayList<>();
        this.temas = new ArrayList<>();
    }

    public DataAlbum() {
        this.setNombre(new String());
        this.setAnioCreacion(0);
        this.creador = new DataArtista();
        this.agregarGenero(new DataGenero());
        this.agregarTema(new DataTema());
    }

    public String getNombre() {
        return nombre;
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