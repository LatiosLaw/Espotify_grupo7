package logica.controladores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import logica.Album;
import logica.Artista;
import logica.Genero;
import logica.Usuario;
import logica.tema;
import logica.dt.DataAlbum;
import logica.dt.DataArtista;
import logica.dt.DataCliente;
import logica.dt.DataGenero;
import logica.dt.DataTema;
import persistencia.DAO_Album;
import persistencia.DAO_Genero;
import persistencia.DAO_Tema;
import persistencia.DAO_Usuario;

public class ControladorAlbum implements IControladorAlbum {

    @Override
    public DataAlbum agregarAlbum(String artista, String nombAlbum, String imagen, int anioCreacion, Collection<DataTema> temas) {

        DAO_Usuario artistaPersistence = new DAO_Usuario();

        DAO_Tema temaPersistence = new DAO_Tema();

        Usuario art = artistaPersistence.findUsuarioByNick(artista);

        if (art instanceof Artista artista1) {
            Album nuevo_album = new Album(nombAlbum, imagen, anioCreacion, artista1);
            for (DataTema tema : temas) {
                nuevo_album.agregarTema(temaPersistence.find(tema.getNickname(), tema.getNomAlb()));
            }
            DAO_Album persistence = new DAO_Album();
            Album album_vacio = new Album();
            album_vacio.setNombre(nuevo_album.getNombre());
            persistence.save(album_vacio);
            persistence.update(nuevo_album);
            Collection<DataGenero> generos_vacios = new ArrayList<>();
            if (persistence.find(nuevo_album.getNombre()) != null) {
                System.out.println("El album con nickname: " + nuevo_album.getNombre() + " fue persistido correctamente.");
                return new DataAlbum(nuevo_album.getNombre(), nuevo_album.getImagen(), nuevo_album.getanioCreacion(), new DataArtista(art.getNickname(), art.getNombre(), art.getApellido(), art.getContra(), art.getEmail(), art.getFoto(), art.getNacimiento(), artista1.getBiografia(), artista1.getDirWeb()), generos_vacios);
            } else {
                System.out.println("El album no fue persistido correctamente.");
                return null;
            }
        }
        return null;
    }

    @Override
    public Collection<String> retornarAlbumsDelGenero(String genero) {
        Collection<String> lista = new ArrayList<>();
        DAO_Album persistence = new DAO_Album();
        Collection<String> albu = persistence.findAllPorGenero(genero);
        Iterator<String> iterator = albu.iterator();
        while (iterator.hasNext()) {
            String album = iterator.next();
            lista.add(album);
        }
        return lista;
    }
    
    @Override
    public Collection<DataAlbum> retornarDataAlbumes(){
        DAO_Album persistence = new DAO_Album();
        
        Collection<Album> albumes = persistence.findAll();
        
        Collection<DataAlbum> albumesRetornables = new ArrayList<>();
        
        for(Album album : albumes){
            albumesRetornables.add(new DataAlbum(album.getNombre(), album.getImagen(), album.getanioCreacion(), new DataArtista(album.getCreador().getNickname())));
        }
        
        return albumesRetornables;
    }

    @Override
    public Collection<String> retornarAlbumsDelArtista(String nick_arti) {
        Collection<String> lista = new ArrayList<>();
        DAO_Album persistence = new DAO_Album();
        Collection<Album> albu = persistence.findAllPorArtista(nick_arti);
        Iterator<Album> iterator = albu.iterator();
        while (iterator.hasNext()) {
            Album album = iterator.next();
            lista.add(album.getNombre());
        }
        return lista;
    }

    @Override
    public Collection<DataAlbum> retornarAlbumsDelGeneroDT(String genero) {
        Collection<DataAlbum> lista = new ArrayList<>();
        DAO_Album persistence = new DAO_Album();
        Collection<Album> lista_albumes = persistence.findAllPorGeneroCompleto(genero);
        Iterator<Album> iterator = lista_albumes.iterator();
        while (iterator.hasNext()) {
            Album albu = iterator.next();
            DataAlbum album_insertable = new DataAlbum(
                    albu.getNombre(),
                    albu.getImagen(),
                    albu.getanioCreacion(),
                    new DataArtista(albu.getCreador().getNickname()));
            lista.add(album_insertable);
        }
        return lista;
    }

    public DataAlbum retornarInfoAlbum(String nombre_album) {
        DAO_Album persistence = new DAO_Album();
        Album album = persistence.findAlbumByName(nombre_album);
        if (album != null) {
            Collection<DataGenero> generos_album = new ArrayList<>();
            for (Genero genero : album.getGeneros()) {
                generos_album.add(new DataGenero(genero.getNombre()));
            }
            Artista art = album.getCreador();
            return new DataAlbum(album.getNombre(), album.getImagen(), album.getanioCreacion(), new DataArtista(art.getNickname(), art.getNombre(), art.getApellido(), art.getContra(), art.getEmail(), art.getFoto(), art.getNacimiento(), art.getBiografia(), art.getDirWeb()), generos_album);
        } else {
            return new DataAlbum("ALBUM NO EXISTE");
        }
    }

    @Override
    public Collection<String> retornarAlbumsString() {
        DAO_Album persistence = new DAO_Album();
        Collection<String> coleString = new ArrayList<>();
        Collection<Album> cole = persistence.findAll();
        if (cole == null) {
            return null;
        } else {
            for (Album al : cole) {
                coleString.add(al.getNombre());
            }
        }
        return coleString;
    }

    //probablemente agregar como parametro coleccion de temas
    public void actualizarAlbum(DataAlbum dataAlbum, Collection<DataGenero> nuevosGeneros) {
        DAO_Album persistence = new DAO_Album();
        DAO_Genero persistence2 = new DAO_Genero();
        Album albumExistente = persistence.find(dataAlbum.getNombre());
        if (albumExistente != null) {
            albumExistente.setImagen(dataAlbum.getImagen());
            albumExistente.setanioCreacion(dataAlbum.getAnioCreacion());
            for (DataTema tema : dataAlbum.getTemas()) {
                albumExistente.agregarTema(new tema(tema.getNickname(), tema.getNomAlb(), tema.getDuracion(), tema.getPos(), tema.getAccess(), tema.getArchivo()));
            }
            for (DataGenero dataGenero : nuevosGeneros) {
                Genero generoExistente = new Genero(dataGenero.getNombre());
                if (!albumExistente.getGeneros().contains(generoExistente)) {
                    Genero genero = persistence2.find(dataGenero.getNombre());
                    if (genero != null) {
                        albumExistente.agregarGenero(genero);
                        genero.agregarAlbumDelGenero(albumExistente);
                    }
                }
            }
            persistence.update(albumExistente);
            System.out.println("El álbum " + dataAlbum.getNombre() + " fue actualizado correctamente.");
        } else {
            System.out.println("El álbum con nombre: " + dataAlbum.getNombre() + " no existe.");
        }
    }
}
