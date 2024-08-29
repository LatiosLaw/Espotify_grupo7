/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Nico
 */
@Entity
public class Cliente extends Usuario {
    
    public Cliente(){
        
    }

    public Cliente(String nickname, String nombre, String apellido, String email, String fecha_naci) {
        super(nickname, nombre, apellido, email, fecha_naci);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Cliente: " + nombre + " " + apellido);
    }
}
