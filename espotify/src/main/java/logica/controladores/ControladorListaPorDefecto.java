/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.controladores;

import logica.Genero;
import logica.ListaPorDefecto;
import logica.ListaReproduccion;
import logica.dt.DataGenero;
import persistencia.DAO_Genero;
import persistencia.DAO_ListaReproduccion;

/**
 *
 * @author Nico
 */
public class ControladorListaPorDefecto implements IControladorListaPorDefecto {

    @Override
    public void crearLista(String nombre, DataGenero dGenero) {
        DAO_ListaReproduccion dao = new DAO_ListaReproduccion();
        DAO_Genero gdao = new DAO_Genero();

        // Verificar si la lista ya existe
        ListaReproduccion listaExistente = dao.find(nombre);
        if (listaExistente != null) {
            throw new IllegalArgumentException("La lista de reproducción ya existe.");
        }

        if (dGenero == null) {
            throw new IllegalArgumentException("DataGenero no puede ser nulo.");
        }

        // Verificar que exista el genero
        Genero generoExistente = gdao.find(dGenero.getNombre());

        if (generoExistente == null) {
            throw new IllegalArgumentException("El genero especificado no existe.");
        }

        ListaPorDefecto nuevaLista = new ListaPorDefecto(nombre, generoExistente);

        // Guardar la nueva lista en la base de datos
        try {
            ListaPorDefecto ls = new ListaPorDefecto();
            ls.setNombre(nuevaLista.getNombre());
            dao.save(ls);
            dao.update(nuevaLista);

            System.out.println("Lista Por Defecto creada exitosamente.");
        } catch (Exception e) {
            System.err.println("Error al guardar la lista: " + e.getMessage());
        }
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
