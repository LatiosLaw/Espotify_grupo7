/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logica.controladores;

import java.util.Collection;
import logica.Album;
import logica.dt.DataAlbum;
import logica.dt.DataArtista;
import logica.dt.DataGenero;
import logica.dt.DataTema;

/**
 *
 * @author Nico
 */
public interface IControladorAlbum {
    
    public DataAlbum agregarAlbum(DataArtista artista, String nombAlbum, int anioCreacion, Collection<DataGenero>generos, Collection<DataTema>temas);
    public Collection<DataAlbum> retornarAlbumsDelGenero(String genero);
    public Collection<DataAlbum> retornarAlbumsDelArtista(String nick_arti);
    public DataAlbum retornarInfoAlbum(String nombre_album);
}
