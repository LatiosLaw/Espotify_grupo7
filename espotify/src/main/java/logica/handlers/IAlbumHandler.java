/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logica.handlers;

import java.util.Collection;
import logica.Genero;

/**
 *
 * @author Nico
 */
public interface IAlbumHandler {
    
    public void agregarAlbum(String nickArtista, String nombAlbum, int anioCreacion, Collection<Genero>generos);
    
}
