/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica.factory;

/**
 *
 * @author Law
 */

import java.time.LocalDate;
import logica.Usuario;
import logica.Cliente;
import logica.Artista;

public class UsuarioFactory {

    public static Usuario createUsuario(String tipo, String nickname, String nombre, String apellido, String email, LocalDate fecha_naci, String biografia, String dirWeb) {
        if ("Cliente".equalsIgnoreCase(tipo)) {
            return new Cliente(nickname, nombre, apellido, email, fecha_naci);
        } else if ("Artista".equalsIgnoreCase(tipo)) {
            return new Artista(nickname, nombre, apellido, email, fecha_naci, biografia, dirWeb);
        } else {
            throw new IllegalArgumentException("Tipo de usuario desconocido: " + tipo);
        }
    }
}
