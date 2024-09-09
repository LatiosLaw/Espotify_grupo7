/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logica.handlers;

import logica.Album;
import logica.Tema;

/**
 *
 * @author Nico
 */
public interface ITemaHandler {
    public boolean crearTemaDefault(String nombre_tema, int duracion);
    public Tema retornarTema(String nickname);
    public void actualizarTema(Tema tema, Album album);
}
