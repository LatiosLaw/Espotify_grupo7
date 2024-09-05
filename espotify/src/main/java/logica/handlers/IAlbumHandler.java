/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logica.handlers;

import java.util.Collection;
import logica.Album;
import logica.Artista;
import logica.Genero;
import logica.Tema;

/**
 *
 * @author Nico
 */
public interface IAlbumHandler {
    
    public Album agregarAlbum(Artista artista, String nombAlbum, int anioCreacion, Collection<Genero>generos, Collection<Tema>temas);
    
    public Album consultarAlbum(String alb);
}
