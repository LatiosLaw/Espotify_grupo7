/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory;

/**
 *
 * @author Law
 */

import logica.usuario;
import logica.cliente;
import logica.Artista;

public class UsuarioFactory {

    public static usuario createUsuario(String tipo, String nickname, String nombre, String apellido, String email, String fecha_naci, String biografia, String dirWeb) {
        if ("Cliente".equalsIgnoreCase(tipo)) {
            return new cliente(nickname, nombre, apellido, email, fecha_naci);
        } else if ("Artista".equalsIgnoreCase(tipo)) {
            return new Artista(nickname, nombre, apellido, email, fecha_naci, biografia, dirWeb);
        } else {
            throw new IllegalArgumentException("Tipo de usuario desconocido: " + tipo);
        }
    }
}
