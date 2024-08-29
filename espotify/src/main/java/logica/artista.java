/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

/**
 *
 * @author Law
 */
public class artista extends usuario {

    private String biografia;
    private String dirWeb;

    public artista(String nickname, String nombre, String apellido, String email, String fecha_naci, String biografia, String dirWeb) {
        super(nickname, nombre, apellido, email, fecha_naci);
        this.biografia = biografia;
        this.dirWeb = dirWeb;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Artista: " + nombre + " " + apellido + ". Biografía: " + biografia);
    }
}
