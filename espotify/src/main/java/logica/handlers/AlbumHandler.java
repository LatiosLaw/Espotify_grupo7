/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.handlers;

import java.util.Collection;
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
    public void agregarAlbum(Artista artista, String nombAlbum, int anioCreacion, Collection<Genero>generos, Collection<Tema>temas){
    Album nuevo_album = new Album(nombAlbum, anioCreacion, artista);
        for (Genero genero : generos) {
            nuevo_album.agregarGenero(genero);
        }
        for (Tema tema : temas) {
            nuevo_album.agregarTema(tema);
        }
        DAO_Album persistence = new DAO_Album();
        persistence.save(nuevo_album);
        
        if (persistence.find(nuevo_album.getNombre()) != null) {
        System.out.println("El album con nickname: " + nuevo_album.getNombre() + " fue persistido correctamente.");
    } else {
        System.out.println("El album no fue persistido correctamente.");
    }
    }
}
