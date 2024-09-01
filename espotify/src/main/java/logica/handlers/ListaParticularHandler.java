/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.handlers;

import logica.ListaParticular;
import logica.ListaReproduccion;
import persistencia.DAO_ListaReproduccion;

/**
 *
 * @author Nico
 */
public class ListaParticularHandler implements IListaParticularHandler{
    
    @Override
    public void crearLista(String nombre, String nickname_cliente){
        
    }
    
    @Override
    public void agregarTema(String nick_cliente, String nombre_lista, String nombre_tema){
        
    }
    
    @Override
    public void quitarTema(String nick_cliente, String nombre_lista, String nombre_tema){
        
    }
    
    @Override
    public void publicarLista(String nick_cliente, String nombre_lista){
        DAO_ListaReproduccion persistence = new DAO_ListaReproduccion();
        ListaParticular lista_a_publicar = persistence.findListaPorNicks(nick_cliente, nombre_lista);
        if (lista_a_publicar != null) {
            lista_a_publicar.setVisibilidad(true);
            persistence.update(lista_a_publicar);
        } else {
            throw new IllegalArgumentException("La lista con nombre " + nombre_lista + " no existe.");
        }
    }
    
    @Override
    public void devolverInformacion(String nombre_lista){
        
    }
}
