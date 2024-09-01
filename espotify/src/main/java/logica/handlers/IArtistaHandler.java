/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package logica.handlers;

import java.time.LocalDate;
import logica.Artista;

/**
 *
 * @author Nico
 */
public interface IArtistaHandler {
    public Artista retornarArtista(String nickname);
    public void agregarArtista(String nickname, String nombre, String apellido, String mail, LocalDate fechaNac, String biografia, String dirWeb);
}
