/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.handlers;

import logica.Genero;
import logica.Album;
import logica.ListaReproduccion;
import logica.ListaPorDefecto;
/**
 *
 * @author Nico
 */
public class GeneroHandler implements IGeneroHandler{
    @Override
    public void crearGenero(String nombre, Genero genero_padre){
        
    }
    
    @Override
    
    public ListaReproduccion buscarListasPorGenero(Genero genero_filtro){
        ListaReproduccion coso = new ListaPorDefecto(); //Por ahora hasta que la logica exista de verdad
        return coso;
    }
    
    @Override
    public Album buscarAlbumesPorGenero(Genero genero_filtro){
        Album coso = new Album(); //Por ahora hasta que la logica exista de verdad
        return coso;
    }
}
