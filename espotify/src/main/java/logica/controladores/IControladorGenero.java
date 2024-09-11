/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logica.controladores;

import java.util.Collection;
import logica.Genero;
import logica.Album;
import logica.dt.DataGenero;
/**
 *
 * @author Nico
 */
public interface IControladorGenero {
    void crearGenero(String nombre, Genero genero_padre);
    public Collection<DataGenero> mostrarGeneros();
    public Collection<DataGenero> darGenerosDelAlbum(String nombre_album);
}
