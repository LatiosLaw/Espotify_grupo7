/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logica.controladores;

import java.util.Collection;
import logica.Genero;
import logica.dt.DataAlbum;
import logica.dt.DataGenero;
/**
 *
 * @author Nico
 */
public interface IControladorGenero {
    public void crearGeneroUnico(String nombre);
    public void crearGeneroConSubgeneros(String nombre, Collection<String> genero_padre);
    public Collection<String> mostrarGeneros();
    public Collection<DataGenero> darGenerosDelAlbum(String nombre_album);
    public void actualizarGenero(DataGenero genero, Collection<String> albumes_previos_del_genero, DataAlbum album);
}