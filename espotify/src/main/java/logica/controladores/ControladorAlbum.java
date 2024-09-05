/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import java.util.Collection;
import java.util.Iterator;
import logica.Album;
import logica.Artista;
import logica.Genero;
import logica.Tema;
import logica.dt.DataAlbum;
import logica.dt.DataArtista;
import logica.dt.DataGenero;
import logica.dt.DataTema;
import persistencia.DAO_Album;

/**
 *
 * @author Nico
 */
public class ControladorAlbum implements IControladorAlbum{
    
    @Override
    public void agregarAlbum(DataArtista artista, String nombAlbum, int anioCreacion, Collection<DataGenero>generos, Collection<DataTema>temas){
    Artista art = new Artista(artista.getNickname(), artista.getNombre(), artista.getApellido(), artista.getCorreo(), artista.getFechaNac(), artista.getBiografia(), artista.getDirWeb());
        Album nuevo_album = new Album(nombAlbum, anioCreacion, art);
        Iterator<DataGenero> iterator = generos.iterator();
        while (iterator.hasNext()) {
            DataGenero genero  = iterator.next();
            nuevo_album.agregarGenero(new Genero(genero.getNombre()));
        }
        Iterator<DataTema> iterator2 = temas.iterator();
        while (iterator2.hasNext()) {
            DataTema tema  = iterator2.next();
            nuevo_album.agregarTema(new Tema(tema.getNickname(), tema.getDuracion()));
        }
        DAO_Album persistence = new DAO_Album();
        Album album_vacio = new Album();
        album_vacio.setNombre(nuevo_album.getNombre());
        persistence.save(album_vacio);
        persistence.update(nuevo_album);
        
        if (persistence.find(nuevo_album.getNombre()) != null) {
        System.out.println("El album con nickname: " + nuevo_album.getNombre() + " fue persistido correctamente.");
    } else {
        System.out.println("El album no fue persistido correctamente.");
    }
    }

}
