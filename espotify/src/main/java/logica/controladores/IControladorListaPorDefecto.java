/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logica.controladores;

import logica.Genero;
import logica.dt.DataGenero;

/**
 *
 * @author Nico
 */
public interface IControladorListaPorDefecto {
    void crearLista(String nombre, DataGenero genero);
    void agregarTema(String nombre_lista, String nombre_tema);
    void quitarTema(String nombre_lista, String nombre_tema);
    void devolverInformacion(String nombre_lista);
}
