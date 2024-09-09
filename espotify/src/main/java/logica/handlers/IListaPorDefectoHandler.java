/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logica.handlers;

import logica.Genero;

/**
 *
 * @author Nico
 */
public interface IListaPorDefectoHandler {
    void crearLista(String nombre, Genero genero);
    void agregarTema(String nombre_lista, String nombre_tema);
    void quitarTema(String nombre_lista, String nombre_tema);
    void devolverInformacion(String nombre_lista);
}
