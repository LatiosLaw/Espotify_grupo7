/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logica.handlers;

/**
 *
 * @author Nico
 */
public interface IListaParticularHandler {
    void crearLista(String nombre, String nickname_cliente);
    void agregarTema(String nick_cliente, String nombre_lista, String nombre_tema);
    void quitarTema(String nick_cliente, String nombre_lista, String nombre_tema);
    void publicarLista(String nick_cliente, String nombre_lista);
    void devolverInformacion(String nombre_lista);
}
