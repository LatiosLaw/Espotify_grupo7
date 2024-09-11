package logica.dt;

import java.util.ArrayList;
import java.util.Collection;
import java.time.LocalDate;

public class DataCliente extends DataUsuario {
    private Collection<DataUsuario> seguidos; // Almacena los usuarios seguidos
    private Collection<DataTema> temasFavoritos; // Almacena los temas favoritos
    private Collection<DataAlbum> albumesFavoritos; // Almacena los albumes favoritos
    private Collection<DataListaReproduccion> listasFavoritas; // Almacena las listas de reproduccion favoritas

    public DataCliente(){

    }

    public DataCliente(String nickname, String nombre, String apellido, String correo, String foto_perfil, LocalDate fechaNac) {
        super(nickname, nombre, apellido, correo, foto_perfil, fechaNac);
        this.seguidos = new ArrayList<>();
        this.temasFavoritos = new ArrayList<>();
        this.albumesFavoritos = new ArrayList<>();
        this.listasFavoritas = new ArrayList<>();
    }

    public Collection<DataUsuario> getSeguidos() {
        return seguidos;
    }

    public Collection<DataTema> getTemasFavoritos() {
        return temasFavoritos;
    }

    public Collection<DataAlbum> getAlbumesFavoritos() {
        return albumesFavoritos;
    }

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
        return "DataCliente{" +
                "seguido=" + seguidos +
                ", temasFavoritos=" + temasFavoritos +
                ", albumesFavoritos=" + albumesFavoritos +
                ", listasFavoritas=" + listasFavoritas +
                "} " + super.toString();
    }
}