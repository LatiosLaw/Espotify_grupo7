/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.handlers;

import java.util.Collection;
import java.util.Iterator;
import logica.Album;
import logica.Artista;
import logica.Genero;
import logica.Tema;
import persistencia.DAO_Album;

/**
 *
 * @author Nico
 */
public class AlbumHandler implements IAlbumHandler{
    
    @Override
    public Album agregarAlbum(Artista artista, String nombAlbum, int anioCreacion, Collection<Genero>generos, Collection<Tema>temas){
    Album nuevo_album = new Album(nombAlbum, anioCreacion, artista);
        Iterator<Genero> iterator = generos.iterator();
        while (iterator.hasNext()) {
            Genero genero  = iterator.next();
            nuevo_album.agregarGenero(genero);
        }
        Iterator<Tema> iterator2 = temas.iterator();
        while (iterator2.hasNext()) {
            Tema tema  = iterator2.next();
            nuevo_album.agregarTema(tema);
        }
        DAO_Album persistence = new DAO_Album();
        Album album_vacio = new Album();
        album_vacio.setNombre(nuevo_album.getNombre());
        persistence.save(album_vacio);
        persistence.update(nuevo_album);
        
        if (persistence.find(nuevo_album.getNombre()) != null) {
        System.out.println("El album con nickname: " + nuevo_album.getNombre() + " fue persistido correctamente.");
        return nuevo_album;
    } else {
        System.out.println("El album no fue persistido correctamente.");
        return null;
    }
    }
}
