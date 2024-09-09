/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import logica.Genero;
import logica.Album;
import logica.ListaReproduccion;
import logica.ListaPorDefecto;
import logica.dt.DataGenero;
import persistencia.DAO_Genero;
/**
 *
 * @author Nico
 */
public class ControladorGenero implements IControladorGenero{
    @Override
    public void crearGenero(String nombre, Genero genero_padre){
        
    }
    
    @Override
    public Collection<DataGenero> mostrarGeneros(){
        Collection<DataGenero> lista = new ArrayList<>();
        DAO_Genero persistence = new DAO_Genero();
        Collection<Genero> gene = persistence.findAll();
        Iterator<Genero> iterator = gene.iterator();
        while (iterator.hasNext()) {
            Genero genero = iterator.next();
            lista.add(new DataGenero(genero.getNombre()));
        }
        return lista;
    }
}
