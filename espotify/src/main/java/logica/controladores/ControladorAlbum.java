package logica.controladores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import logica.Album;
import logica.Artista;
import logica.Genero;
import logica.tema;
import logica.dt.DataAlbum;
import logica.dt.DataArtista;
import logica.dt.DataGenero;
import logica.dt.DataTema;
import persistencia.DAO_Album;
import persistencia.DAO_Genero;

public class ControladorAlbum implements IControladorAlbum {

    @Override
    public DataAlbum agregarAlbum(String artista, String nombAlbum, String imagen, int anioCreacion, Collection<DataTema> temas) {
        Artista art = new Artista(artista);
        Album nuevo_album = new Album(nombAlbum, imagen, anioCreacion, art);
        Iterator<DataTema> iterator2 = temas.iterator();
        while (iterator2.hasNext()) {
            DataTema tema = iterator2.next();
            nuevo_album.agregarTema(new tema(tema.getNickname(), tema.getDuracion(), tema.getPos(), tema.getAccess(), tema.getArchivo()));
        }
        DAO_Album persistence = new DAO_Album();
        Album album_vacio = new Album();
        album_vacio.setNombre(nuevo_album.getNombre());
        persistence.save(album_vacio);
        persistence.update(nuevo_album);

        if (persistence.find(nuevo_album.getNombre()) != null) {
            System.out.println("El album con nickname: " + nuevo_album.getNombre() + " fue persistido correctamente.");
            return new DataAlbum(nuevo_album.getNombre(), nuevo_album.getImagen(), nuevo_album.getanioCreacion(), new DataArtista(art.getNickname(), art.getNombre(), art.getApellido(), art.getEmail(), art.getFoto(), art.getNacimiento(), art.getBiografia(), art.getDirWeb()));
        } else {
            System.out.println("El album no fue persistido correctamente.");
            return null;
        }
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

    public DataAlbum retornarInfoAlbum(String nombre_album) {
        DAO_Album persistence = new DAO_Album();
        Album album = persistence.findAlbumByName(nombre_album);
        if (album != null) {
            Artista art = album.getCreador();
            return new DataAlbum(album.getNombre(), album.getImagen(), album.getanioCreacion(), new DataArtista(art.getNickname(), art.getNombre(), art.getApellido(), art.getEmail(), art.getFoto(), art.getNacimiento(), art.getBiografia(), art.getDirWeb()));
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
                albumExistente.agregarTema(new tema(tema.getNickname(), tema.getDuracion(), tema.getPos(), tema.getAccess(), tema.getArchivo()));
            }
            // ayudaa

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
