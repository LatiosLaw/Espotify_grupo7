/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logica.controladores;

import logica.dt.DataCliente;
import logica.dt.DataListaParticular;

/**
 *
 * @author Nico
 */
public interface IControladorListaParticular {
    void crearLista(String nombre, DataCliente cli);
    void agregarTema(String nick_cliente, String nombre_lista, String nombre_tema);
    void quitarTema(String nick_cliente, String nombre_lista, String nombre_tema);
    void publicarLista(String nick_cliente, String nombre_lista);
    DataListaParticular devolverInformacion(String nombre_lista, String nick_cliente);
}
