/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Law
 */

public class cliente extends usuario {

    public cliente(String nickname, String nombre, String apellido, String email, String fecha_naci) {
        super(nickname, nombre, apellido, email, fecha_naci);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Cliente: " + nombre + " " + apellido);
    }
}
