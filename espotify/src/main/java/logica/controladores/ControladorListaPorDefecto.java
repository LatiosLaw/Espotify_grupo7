/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import logica.Genero;
import logica.ListaPorDefecto;
import logica.ListaReproduccion;
import persistencia.DAO_ListaReproduccion;

/**
 *
 * @author Nico
 */
public class ControladorListaPorDefecto implements IControladorListaPorDefecto {

    @Override
    public void crearLista(String nombre, Genero genero) {
        DAO_ListaReproduccion dao = new DAO_ListaReproduccion();

        // Verificar si la lista ya existe
        ListaReproduccion listaExistente = dao.find(nombre);
        if (listaExistente != null) {
            throw new IllegalArgumentException("La lista de reproduccion ya existe.");
        }

        ListaPorDefecto nuevaLista = new ListaPorDefecto(nombre, genero);

        // Guardar la nueva lista en la base de datos
        dao.save(nuevaLista);
        System.out.println("Lista Por Defecto creada exitosamente.");
    }

    @Override
    public void agregarTema(String nombre_lista, String nombre_tema) {

    }

    @Override
    public void quitarTema(String nombre_lista, String nombre_tema) {

    }

    @Override
    public void devolverInformacion(String nombre_lista) {

    }
}
