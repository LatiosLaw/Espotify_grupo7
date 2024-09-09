package logica.dt;

import java.util.ArrayList;
import java.util.Collection;

public class DataGenero {
    private String nombre;
    private Collection<DataGenero> subgeneros;
    private Collection<DataAlbum> albumesDelGenero; 


    public DataGenero(String nombre) {
        this.nombre = nombre;
        this.subgeneros = new ArrayList<>();
        this.albumesDelGenero = new ArrayList<>();
    }

    public DataGenero() {
        this.setNombre(new String());
        this.subgeneros = new ArrayList<>();
        this.albumesDelGenero = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Collection<DataGenero> getSubgeneros() {
        return subgeneros;
    }

    public Collection<DataAlbum> getAlbumesDelGenero() {
        return albumesDelGenero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarSubgenero(DataGenero subgenero) {
        this.subgeneros.add(subgenero);
    }

    public void agregarAlbumDelGenero(DataAlbum album) {
        this.albumesDelGenero.add(album);
    }

    @Override
    public String toString() {
        return "DataGenero{" +
                "nombre='" + nombre + '\'' +
                ", subgeneros=" + subgeneros +
                ", albumesDelGenero=" + albumesDelGenero +
                '}';
    }
}