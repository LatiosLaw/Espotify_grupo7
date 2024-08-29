/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.persistence.Entity;

/**
 *
 * @author Law
 */
@Entity
public class artista extends usuario {

    private String biografia;
    private String dirWeb;

    @Override
    public void mostrarInformacion() {
        System.out.println("Artista: " + nombre + " " + apellido + ". Biografía: " + biografia + ". direccion Web: " + dirWeb);
    }
}
