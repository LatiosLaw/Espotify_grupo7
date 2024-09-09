/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logica.handlers;

import logica.Genero;
import logica.Album;
import logica.ListaReproduccion;
/**
 *
 * @author Nico
 */
public interface IGeneroHandler {
    void crearGenero(String nombre, Genero genero_padre);
    ListaReproduccion buscarListasPorGenero(Genero genero_filtro);
    Album buscarAlbumesPorGenero(Genero genero_filtro);
}
